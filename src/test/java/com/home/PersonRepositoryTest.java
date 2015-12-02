package com.home;

import com.home.configuration.HSQLDBConfig;
import com.home.configuration.JpaRepositoryConfiguration;
import com.home.data.Person;
import com.home.data.PersonDao;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Slf4j
@ActiveProfiles("embedded")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextHierarchy({
        @ContextConfiguration(classes = HSQLDBConfig.class),
        @ContextConfiguration(classes = JpaRepositoryConfiguration.class)
})
public class PersonRepositoryTest {
    @Autowired
    private PersonDao personDao;

    @Before
    public void fillDb() {
        personDao.save(new Person("James", "Bond"));
        personDao.save(new Person("Will", "Smith"));
    }

    @Test
    public void finaAll() {
        personDao.findAll().forEach(pesron -> log.info(pesron.toString()));
    }
}
