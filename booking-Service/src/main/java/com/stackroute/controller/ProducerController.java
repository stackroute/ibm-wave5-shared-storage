package com.stackroute.controller;

import com.stackroute.domain.Producer;
import com.stackroute.domain.History;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1")
public class ProducerController {

    @Autowired
    Producer producer;

    @PostMapping("/produce")
    public String helloKafkaProducer(@RequestBody History history) {

        System.out.println("Request Body displayed!"+ history);
        producer.send(history);

        return "Produced to Kafka!";

    }
}