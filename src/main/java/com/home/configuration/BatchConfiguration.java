package com.home.configuration;

import com.home.data.Person;
import com.home.processors.PersonItemProcessor;
import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
@ImportResource("classpath:batch.xml")
public class BatchConfiguration {
//    @Autowired
//    DataSource dataSource;

    // tag::readerwriterprocessor[]
//    @Bean
//    public ItemReader<Person> reader() {
//        FlatFileItemReader<Person> reader = new FlatFileItemReader<Person>();
//        reader.setResource(new ClassPathResource("sample-data.csv"));
//        reader.setLineMapper(new DefaultLineMapper<Person>() {{
//            setLineTokenizer(new DelimitedLineTokenizer() {{
//                setNames(new String[] { "firstName", "lastName" });
//            }});
//            setFieldSetMapper(new BeanWrapperFieldSetMapper<Person>() {{
//                setTargetType(Person.class);
//            }});
//        }});
//        return reader;
//    }

//    @Bean
//    public ItemProcessor<Person, Person> processor() {
//        return new PersonItemProcessor();
//    }

//    @Bean
//    public ItemWriter<Person> writer() {
//        JdbcBatchItemWriter<Person> writer = new JdbcBatchItemWriter<Person>();
//        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Person>());
//        writer.setSql("INSERT INTO people (first_name, last_name) VALUES (:firstName, :lastName)");
//        writer.setDataSource(dataSource);
//        return writer;
//    }
    // end::readerwriterprocessor[]

    // tag::jobstep[]
//    @Bean
//    public Job importUserJob(JobBuilderFactory jobs, Step s1, JobExecutionListener listener) {
//        return jobs.get("importUserJob")
//                .incrementer(new RunIdIncrementer())
//                .listener(listener)
//                .flow(s1)
//                .end()
//                .build();
//    }
//
//    @Bean
//    public Step step1(StepBuilderFactory stepBuilderFactory, ItemReader<Person> reader,
//                      ItemWriter<Person> writer, ItemProcessor<Person, Person> processor,
//                      ChunkListener chunkListener, StepExecutionListener stepExecutionListener) {
//        return stepBuilderFactory.get("step1")
//                .<Person, Person> chunk(3)
//                .reader(reader)
//                .processor(processor)
//                .writer(writer)
//                .listener(chunkListener)
//                .listener(stepExecutionListener)
//                .build();
//    }
    // end::jobstep[]

//    @Bean
//    public JdbcTemplate jdbcTemplate() {
//        return new JdbcTemplate(dataSource);
//    }
}
