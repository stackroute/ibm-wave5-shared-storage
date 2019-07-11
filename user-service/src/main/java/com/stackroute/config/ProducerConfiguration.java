package com.stackroute.config;

import com.stackroute.model.UserProfile;
import com.stackroute.model.Producer;
import com.stackroute.model.Recommendations;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ProducerConfiguration {

    @Value("${kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Bean
    public Map<String, Object> producerConfigs(){
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "0.0.0.0:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        return props;
    }

    @Bean
    public ProducerFactory<String, UserProfile> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    @Bean
    public UserProfile sender1(){
        return  new UserProfile();
    }

    @Bean
    public KafkaTemplate<String, UserProfile> kafkaTemplate() {
        return new KafkaTemplate<String, UserProfile>(producerFactory());
    }

    @Bean
    public Producer sender() {
        return new Producer();
    }



    @Bean
    public ProducerFactory<String, Recommendations> producerFactory1() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    @Bean
    public Recommendations sender2(){
        return  new Recommendations();
    }

    @Bean
    public KafkaTemplate<String, Recommendations> kafkaTemplate1() {
        return new KafkaTemplate<String, Recommendations>(producerFactory1());
    }



}