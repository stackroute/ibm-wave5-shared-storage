package com.stackroute;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class StorageApplication {
    public static void main(String[] args)
    {
    SpringApplication.run(StorageApplication.class, args);
    }

}