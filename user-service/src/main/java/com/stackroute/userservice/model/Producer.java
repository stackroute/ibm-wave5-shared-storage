package com.stackroute.userservice.model;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.beans.factory.annotation.Value;

public class Producer {

    @Value("${kafka.topic.json}")
    private String jsonTopic;

    private static final Logger LOGGER =
            LoggerFactory.getLogger(Producer.class);

    @Autowired
    private KafkaTemplate<String, ActivityStream> kafkaTemplate;

    public void send(ActivityStream activityStream) {
        LOGGER.info("sending payload='{}'", activityStream.toString());
        kafkaTemplate.send(jsonTopic, activityStream);
    }
}