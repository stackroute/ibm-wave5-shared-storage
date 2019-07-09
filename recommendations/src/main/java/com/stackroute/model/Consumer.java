package com.stackroute.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Consumer {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(Consumer.class);

    @Autowired
    Recommendation recommendation;

    @Autowired
    Warehouse warehouse;

    @Autowired
    Recommendations recommendations;

    private CountDownLatch latch = new CountDownLatch(1);

    public CountDownLatch getLatch() {
        return latch;
    }

    @KafkaListener(topics = "${kafka.topic.json6}")
    public void receive(@Payload Recommendation recommendation) {

        System.out.println(recommendation.toString());
        LOGGER.info("received payload='{}'", recommendation.toString());

        latch.countDown();
    }

    @KafkaListener(topics = "${kafka.topic.json7}")
    public void receive1(@Payload Warehouse warehouse) {

        System.out.println(warehouse.toString());
        LOGGER.info("received payload='{}'", warehouse.toString());

        latch.countDown();
    }
    @KafkaListener(topics = "${kafka.topic.json8}")
    public void receive1(@Payload Recommendations recommendations) {

        System.out.println(recommendations.toString());
        LOGGER.info("received payload='{}'", recommendations.toString());

        latch.countDown();
    }

}