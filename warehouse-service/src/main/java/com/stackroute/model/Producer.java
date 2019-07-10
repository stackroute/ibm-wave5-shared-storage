package com.stackroute.model;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.beans.factory.annotation.Value;

public class Producer {

    @Value("${kafka.topic.json3}")
    private String jsonTopic;

    private static final Logger LOGGER =
            LoggerFactory.getLogger(Producer.class);

    @Autowired
    private KafkaTemplate<String, ListedStorageUnit> kafkaTemplate;

    public void send(ListedStorageUnit listedStorageUnit) {
        LOGGER.info("sending payload='{}'", listedStorageUnit.toString());
        kafkaTemplate.send(jsonTopic, listedStorageUnit);
    }

    @Value("${kafka.topic.json7}")
    private String jsonTopic7;

    @Autowired
    private KafkaTemplate<String, Warehouse> kafkaTemplate1;

    public void send1(Warehouse warehouse) {
        LOGGER.info("sending payload='{}'", warehouse.toString());
        kafkaTemplate1.send(jsonTopic7, warehouse);
    }
}