package com.home;

import com.home.configuration.*;
import com.home.listeners.BatchNotificationListener;
import com.home.listeners.JobNotificationListener;
import com.home.listeners.StepNotificationListener;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Slf4j
@ActiveProfiles("embedded")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextHierarchy({
        @ContextConfiguration(classes = HSQLDBConfig.class),
        @ContextConfiguration(classes = JpaRepositoryConfiguration.class),
        @ContextConfiguration(classes = {BatchNotificationListener.class,
                                        StepNotificationListener.class,
                                        JobNotificationListener.class}),
        @ContextConfiguration(classes = InBatchJobConfig.class),
        @ContextConfiguration(classes = BatchConfiguration.class),
        @ContextConfiguration(classes = BatchTestUtil.class)
})
public class BatchFunctionalTests extends AbstractTransactionalJUnit4SpringContextTests {
    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

    @Test
    public void testJob() throws Exception {
        System.out.println("test");
        ExitStatus jobExecution = jobLauncherTestUtils.launchJob().getExitStatus();
        Assert.assertEquals("COMPLETED", jobExecution.getExitCode());
    }
}
