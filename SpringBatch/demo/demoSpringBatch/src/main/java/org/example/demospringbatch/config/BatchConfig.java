package org.example.demospringbatch.config;


import org.example.demospringbatch.entity.Product;
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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class BatchConfig {

    public BatchConfig() {
    }

    //FlatFIleItemReader est un objet qui nous permet de venir lire les information presente dans un fichier

    @Bean
    public FlatFileItemReader<Product> reader() {
        return new FlatFileItemReaderBuilder<Product>()
                .name("productItemReader")
                //resource vien specifié ou se trouve la ressource a utiliser
                .resource(new ClassPathResource("products.csv"))
                .linesToSkip(1)
                .delimited()
                .names("id", "name", "price")
                .fieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
                    setTargetType(Product.class);
                }})
                .build();
    }


    // ItemPorcessor permet de venir ajouter un traitement sur les données que l'on a recuperer precedament dans notre reader
    @Bean
    public ItemProcessor<Product, Product> processor() {
        return product -> {
            product.setPrice(product.getPrice()  * 1.2); // Ajouter 20% de TVA
            return product;
        };
    }

    // l'itemWriter permet de venir enregistrer les informations dans un fichier ou une base de donnée en fin de step
    @Bean
    public JdbcBatchItemWriter<Product> writer(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Product>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO product (id, name, price) VALUES (:id, :name, :price)")
                .dataSource(dataSource)
                .build();
    }

    //Le job est l'object qui nous permet de definir les etape et l'ordre dans le quel elles vont etre executé
    @Bean
    public Job importJob(JobRepository jobRepository, Step step) {
        return new JobBuilder("importProductsJob",jobRepository)
                .start(step)
                .build();
    }

    //Le Step est une etape qui peut etre soit composer de reader/processor/writer ou d'un tasklet
    @Bean
    public Step step(ItemReader<Product> reader,
                     ItemProcessor<Product, Product> processor,
                     ItemWriter<Product> writer, JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("step",jobRepository)
                .<Product, Product>chunk(10)
                .transactionManager(transactionManager)
                .chunk(10)// Taille du chunk
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }

}
