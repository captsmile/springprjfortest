package com.vitalii.springprjfortest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.CompletableFuture;

@Service
public class PersonService {

    @Autowired
    PersonDao personDao;

    protected final Log logger = LogFactory.getLog(getClass());


    @Async
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public CompletableFuture<Iterable<Person>> findAll() throws InterruptedException {
        Iterable<Person> all = personDao.findAll();
        logger.info("Read Record first " + all);
        Thread.currentThread().sleep(2000);
        all = personDao.findAll();
        logger.info("Read Record second " + all);
        return CompletableFuture.completedFuture(all);
    }

    @Async
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public CompletableFuture<Person> save(Person person) {
        Person save = personDao.save(person);
        logger.info("Record inserted " + person);
        return CompletableFuture.completedFuture(save);
    }

}

