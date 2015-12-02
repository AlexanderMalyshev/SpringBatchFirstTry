package com.home.configuration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BatchTestUtil {
    @Bean
    public JobLauncherTestUtils getJobLauncherTestUtils(JobLauncher jobLauncher,
                                                        Job job, JobRepository jobRepository) {
        JobLauncherTestUtils jobLauncherTestUtils = new JobLauncherTestUtils();
        jobLauncherTestUtils.setJobLauncher(jobLauncher);
        jobLauncherTestUtils.setJob(job);
        jobLauncherTestUtils.setJobRepository(jobRepository);
        return jobLauncherTestUtils;
    }
}
