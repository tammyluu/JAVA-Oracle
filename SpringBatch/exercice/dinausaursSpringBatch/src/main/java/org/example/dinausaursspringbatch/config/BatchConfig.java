package org.example.dinausaursspringbatch.config;



import org.example.dinausaursspringbatch.entity.Dinosaur;
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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class BatchConfig {
    public BatchConfig(){}

    // Lecture des données du fichier CSV
    @Bean
    public FlatFileItemReader<Dinosaur> reader() {
        return new FlatFileItemReaderBuilder<Dinosaur>()
                .name("dinosaurItemReader")
                .resource(new ClassPathResource("dinosaurs.csv")) // Le fichier CSV à lire
                .linesToSkip(1) // Ignorer la ligne d'en-tête
                .delimited()
                .names("id", "name", "species", "ageInCenturies") // Correspondance des colonnes
                .fieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
                    setTargetType(Dinosaur.class);
                }})
                .build();
    }

    // Traitement des données : convertir `age_million_years` en siècles
    @Bean
    public ItemProcessor<Dinosaur, Dinosaur> processor() {
        return dinosaur -> {
            double ageInMillionYears = dinosaur.getAgeInCenturies(); // Lire la colonne `age_million_years`
            dinosaur.setAgeInCenturies(ageInMillionYears * 10); // Conversion en siècles
            return dinosaur;
        };
    }

    // Écriture des données dans la base de données
    @Bean
    public JdbcBatchItemWriter<Dinosaur> writer(DataSource dataSource) {
        return new org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder<Dinosaur>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO dinosaur (id, name, species, age_in_centuries) VALUES (:id, :name, :species, :ageInCenturies)")
                .dataSource(dataSource)
                .build();
    }

    // Configuration du job
    @Bean
    public Job importDinosaursJob(JobRepository jobRepository, Step step) {
        return new JobBuilder("importDinosaursJob", jobRepository)
                .start(step)
                .build();
    }

    // Configuration de l'étape
    @Bean
    public Step step(ItemReader<Dinosaur> reader,
                     ItemProcessor<Dinosaur, Dinosaur> processor,
                     ItemWriter<Dinosaur> writer, JobRepository jobRepository,
                     PlatformTransactionManager transactionManager) {
        return new StepBuilder("step", jobRepository)
                .<Dinosaur, Dinosaur>chunk(10,transactionManager) // Taille du chunk
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }

}
