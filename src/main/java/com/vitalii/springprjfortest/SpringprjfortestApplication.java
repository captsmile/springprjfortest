package com.vitalii.springprjfortest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Executor;

@SpringBootApplication
@EnableAsync
public class SpringprjfortestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringprjfortestApplication.class, args);
    }

    @Bean
    public Executor taskExecutor() {
        return new SimpleAsyncTaskExecutor();
    }

}