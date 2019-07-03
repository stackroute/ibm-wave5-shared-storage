
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

    public void send(BookedStorageUnit bookedStorageUnit) {
        LOGGER.info("sending payload='{}'", bookedStorageUnit.toString());
        kafkaTemplate.send(jsonTopic, bookedStorageUnit);
    }
}