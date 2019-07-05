package com.stackroute.model;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.beans.factory.annotation.Value;

public class Producer {

    @Value("${kafka.topic.json1}")
    private String jsonTopic;

    private static final Logger LOGGER =
            LoggerFactory.getLogger(Producer.class);

    @Autowired
    private KafkaTemplate<String, ListedStorageUnit> kafkaTemplate;

    public void send(ListedStorageUnit listedStorageUnit) {
        LOGGER.info("sending payload='{}'", listedStorageUnit.toString());
        kafkaTemplate.send(jsonTopic, listedStorageUnit);
    }
}