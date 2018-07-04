package com.vitalii.springprjfortest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;

@Component
public class TestTransaction implements CommandLineRunner {


    @Autowired
    PersonService personService;

    protected final Log logger = LogFactory.getLog(getClass());

    @Override
    public void run(String... args) throws Exception {
        Person mary = new Person("Maria");
        personService.findAll();
        CompletableFuture<Person> save = personService.save(mary);
        Person x = save.get();
        x.setId(10);
        personService.save(x);
        Thread.sleep(4000);
        personService.findAll();
    }

}


