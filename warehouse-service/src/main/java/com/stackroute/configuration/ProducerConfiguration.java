package com.stackroute.configuration;

import com.stackroute.model.ListedStorageUnit;
import com.stackroute.model.Producer;
import com.stackroute.model.Warehouse;
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
    public ProducerFactory<String, ListedStorageUnit> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    @Bean
    public ListedStorageUnit sender1(){
        return  new ListedStorageUnit();
    }

    @Bean
    public KafkaTemplate<String, ListedStorageUnit> kafkaTemplate() {
        return new KafkaTemplate<String, ListedStorageUnit>(producerFactory());
    }

    @Bean
    public Producer sender() {
        return new Producer();
    }

    @Bean
    public ProducerFactory<String, Warehouse> producerFactory1() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    @Bean
    public Warehouse sender2(){
        return  new Warehouse();
    }

    @Bean
    public KafkaTemplate<String, Warehouse> kafkaTemplate1() {
        return new KafkaTemplate<String, Warehouse>(producerFactory1());
    }

}