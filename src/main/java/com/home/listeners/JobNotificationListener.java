package com.home.listeners;

import com.home.data.PersonDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class JobNotificationListener extends JobExecutionListenerSupport {
    @Autowired
    PersonDao personDao;

	@Override
	public void afterJob(JobExecution jobExecution) {
		if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
			log.info("-> JOB FINISHED! Time to verify the results");
            personDao.findAll().forEach(person -> log.info("Found <" + person + "> in the database."));
		}
	}

	@Override
	public void beforeJob(JobExecution jobExecution) {
		log.info("-> JOB STARTED!");
		super.beforeJob(jobExecution);
	}
}
