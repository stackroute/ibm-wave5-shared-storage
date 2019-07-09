
package com.stackroute.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.beans.factory.annotation.Value;

public class Producer {

    @Value("${kafka.topic.json2}")
    private String jsonTopic;

    private static final Logger LOGGER =
            LoggerFactory.getLogger(Producer.class);


    @Autowired
    private KafkaTemplate<String, BookedStorageUnit> kafkaTemplate;

    public void send1(BookedStorageUnit bookedStorageUnit) {
        LOGGER.info("sending payload='{}'", bookedStorageUnit.toString());
        kafkaTemplate.send(jsonTopic, bookedStorageUnit);
    }

    @Value("${kafka.topic.json4}")
    private String jsonTopic4;

    @Autowired
    private KafkaTemplate<String, Tenant> kafkaTemplate1;

    public void send(Tenant tenant) {
        LOGGER.info("sending payload='{}'", tenant.toString());
        kafkaTemplate1.send(jsonTopic4, tenant);
    }

    @Value("${kafka.topic.json6}")
    private String jsonTopic6;

    @Autowired
    private KafkaTemplate<String, Recommendation> kafkaTemplate2;

    public void send3(Recommendation recommendation) {
        LOGGER.info("sending payload='{}'", recommendation.toString());
        kafkaTemplate2.send(jsonTopic6, recommendation);
    }
}