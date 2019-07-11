package com.stackroute.model;


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
    private KafkaTemplate<String, UserProfile> kafkaTemplate;

    public void send(UserProfile userProfile) {
        LOGGER.info("sending payload='{}'", userProfile.toString());
        kafkaTemplate.send(jsonTopic, userProfile);
    }

    @Value("${kafka.topic.json8}")
    private String jsonTopic8;

    private static final Logger LOGGER1 =
            LoggerFactory.getLogger(Producer.class);

    @Autowired
    private KafkaTemplate<String, Recommendations> kafkaTemplate1;

    public void send1(Recommendations recommendations) {
        LOGGER.info("sending payload='{}'", recommendations.toString());
        kafkaTemplate1.send(jsonTopic8, recommendations);
    }
}