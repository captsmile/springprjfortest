package com.vitalii.springprjfortest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.*;

@Service
public class PersonService {

    @Autowired
    PersonDao personDao;

    protected final Log logger = LogFactory.getLog(getClass());


    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void findAll() throws InterruptedException {
        logger.info("Read Record first " + personDao.findAll());
        Thread.currentThread().sleep(2000);
        logger.info("Read Record second " + personDao.findAll());

    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void save(Person person) {
        Person save = personDao.save(person);
        logger.info("Record inserted " + person + " and wait 3s");
    }

}

