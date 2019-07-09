package com.stackroute.config;

import com.stackroute.model.BookedStorageUnit;
import com.stackroute.model.Producer;
import com.stackroute.model.Recommendation;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
        // props.put()

        return props;
    }

    @Bean
    public ProducerFactory<String, BookedStorageUnit> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    @Bean
    public KafkaTemplate<String, BookedStorageUnit> kafkaTemplate() {
        return new KafkaTemplate<String, BookedStorageUnit>(producerFactory());
    }

    @Primary
    @Bean
    public Producer sender1() {
        return new Producer();
    }

    @Bean
    public BookedStorageUnit send2() {
        return new BookedStorageUnit();
    }


    @Bean
    public ProducerFactory<String, Recommendation> producerFactory2() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    @Bean
    public KafkaTemplate<String, Recommendation> kafkaTemplate2() {
        return new KafkaTemplate<String, Recommendation>(producerFactory2());
    }

    @Bean
    public Recommendation send3() {
       return new Recommendation();
    }


}