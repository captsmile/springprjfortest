package com.vitalii.springprjfortest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;

@Component
public class TestTransaction implements CommandLineRunner {


    @Autowired
    PersonService personService;

    protected final Log logger = LogFactory.getLog(getClass());

    @Override
    public void run(String... args) throws Exception {
        Person mary = new Person("Mary");

        new Thread(() -> {
            try {
                personService.findAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        Thread.currentThread().sleep(150);

        new Thread(() -> {
                personService.save(mary);
        }).start();

    }

}


