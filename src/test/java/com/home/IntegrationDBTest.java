package com.home;

import com.home.configuration.IntegrationTestConfiguration;
import com.home.data.Person;
import com.home.data.PersonDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={IntegrationTestConfiguration.class})
public class IntegrationDBTest {
    @Autowired
    PersonDao personDao;

    @Before
    public void populateDb() {
        personDao.save(new Person("John", "Smith"));
        personDao.save(new Person("James", "Bond"));
    }

    @Test
    public void getPersons() {
        personDao.findAll().forEach(System.out::println);
    }

}
