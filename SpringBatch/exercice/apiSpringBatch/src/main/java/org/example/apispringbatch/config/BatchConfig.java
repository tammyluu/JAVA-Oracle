package org.example.apispringbatch.config;

import org.example.apispringbatch.entity.Film;
import org.example.apispringbatch.tasklet.FileCleaningTasklet;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;


@Configuration
public class BatchConfig {

    private final FileCleaningTasklet fileCleaningTasklet;

    @Autowired
    public BatchConfig(FileCleaningTasklet fileCleaningTasklet) {
        this.fileCleaningTasklet = fileCleaningTasklet;
    }

    @Bean
    public FlatFileItemReader<Film> reader() {
        return new FlatFileItemReaderBuilder<Film>()
                .name("filmItemReader")
                .resource(new ClassPathResource("films.csv"))
                .linesToSkip(1)
                .delimited()
                .names("id", "name", "date", "director", "genre", "spectator")
                .fieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
                    setTargetType(Film.class);
                }})
                .build();
    }
    // l'itemWriter permet de venir enregistrer les informations dans un fichier ou une base de donnée en fin de step
    @Bean
    public JdbcBatchItemWriter<Film> writer(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Film>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO film ( id,name, date, director, genre, spectator ) VALUES ( :id, :name, :date, :director, :genre,:spectator)")
                .dataSource(dataSource)
                .build();
    }

    @Bean
    public ItemProcessor<Film, Film> processor() {
        return film -> {
            // Ici, aucune transformation n'est nécessaire pour l'instant
            return film;
        };
    }

    //Le job est l'object qui nous permet de definir les etape et l'ordre dans le quel elles vont etre executé
    @Bean
    public Job importJob(JobRepository jobRepository, Step step, Step stepCleaning) {
        return new JobBuilder("importFilmsJob",jobRepository)
                .start(step)
                .next(stepCleaning)
                .build();
    }
    //Le Step est une etape qui peut etre soit composer de reader/processor/writer ou d'un tasklet
    @Bean
    public Step step(ItemReader<Film> reader,
                     ItemProcessor<Film, Film> processor,
                     ItemWriter<Film> writer, JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("step",jobRepository)
                .<Film, Film>chunk(10,transactionManager)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }
    @Bean
    public Step stepCleaning (JobRepository jobRepository, PlatformTransactionManager transactionManager){
        return new StepBuilder("CleaningStep",jobRepository)
                .tasklet(fileCleaningTasklet)
                .transactionManager(transactionManager)
                .build();
    }



}
