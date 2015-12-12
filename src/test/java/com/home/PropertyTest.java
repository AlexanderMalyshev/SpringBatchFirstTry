package com.home;


import com.home.configuration.PropertyConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PropertyConfiguration.class)
public class PropertyTest {
    @Value("${input.file.name}")
    String input;

    @Test
    public void test() {
        log.info("input file: " + input);
    }

}
