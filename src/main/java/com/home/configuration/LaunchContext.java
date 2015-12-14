package com.home.configuration;

import com.home.launcher.FileMessageToJobRequest;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.integration.launch.JobLaunchingGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.file.FileReadingMessageSource;
import org.springframework.integration.file.filters.AcceptOnceFileListFilter;
import org.springframework.integration.file.filters.CompositeFileListFilter;
import org.springframework.integration.file.filters.SimplePatternFileListFilter;
import org.springframework.integration.handler.LoggingHandler;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

import java.io.File;

@Configuration
public class LaunchContext {
    @Autowired
    private JobLauncher jobLauncher;

    @Bean
    public MessageChannel inboundFileChannel() { return new DirectChannel(); }
    @Bean
    public MessageChannel outboundJobRequestChannel() { return new DirectChannel(); }
    @Bean
    public MessageChannel jobLaunchReplyChannel() { return new DirectChannel(); }

    @Bean
    @InboundChannelAdapter(value = "inboundFileChannel", poller = @Poller(fixedRate = "1000"))
    public MessageSource<File> filePoller(@Value("${input.folder}") String folder) {
        FileReadingMessageSource source = new FileReadingMessageSource();
        source.setDirectory(new File(folder));
        CompositeFileListFilter ff = new CompositeFileListFilter();
        ff.addFilters(new SimplePatternFileListFilter("*csv"), new AcceptOnceFileListFilter());
        source.setFilter(ff);
        return source;
    }

    @Bean
    @Transformer(inputChannel = "inboundFileChannel", outputChannel = "outboundJobRequestChannel")
    public FileMessageToJobRequest fileMessageToJobRequest(Job job) {
        FileMessageToJobRequest fmtjr = new FileMessageToJobRequest();
        fmtjr.setJob(job);
        fmtjr.setFileParameterName("input.file.name");
        return fmtjr;
    }

    @Bean
    @Transformer(inputChannel = "outboundJobRequestChannel")
    public MessageHandler jobLaunchingGw() {
        JobLaunchingGateway jobLaunchingGateway = new JobLaunchingGateway(jobLauncher);
        jobLaunchingGateway.setOutputChannelName("jobLaunchReplyChannel");
        return jobLaunchingGateway;
    }

    @Bean
    @ServiceActivator(inputChannel = "jobLaunchReplyChannel")
    public MessageHandler logger() {
        LoggingHandler loggingHandler =  new LoggingHandler(LoggingHandler.Level.INFO.name());
        loggingHandler.setLoggerName("log");
        return loggingHandler;
    }
}
