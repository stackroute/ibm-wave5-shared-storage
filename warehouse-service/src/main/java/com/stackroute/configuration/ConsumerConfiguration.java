package com.stackroute.configuration;

import com.stackroute.model.Consumer;
import com.stackroute.model.Tenant;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class ConsumerConfiguration {

    private static String BOOTSTRAP_SERVERS_CONFIG;
    private static String KEY_DESERIALIZER_CLASS_CONFIG ;
    private static String VALUE_DESERIALIZER_CLASS_CONFIG;
    private static String GROUP_ID_CONFIG;

    @Value("${kafka.bootstrap-servers}")
    private String bootstrapServers;


    @Bean
    public Map<String, Object> consumerConfigs() {
        Map<String, Object> props = new HashMap<>();
        // list of host:port pairs used for establishing the initial connections to the Kafka cluster
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                "0.0.0.0:9092");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                JsonDeserializer.class);
        // allows a pool of processes to divide the work of consuming and processing records
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "Json");

        return props;
    }
    @Bean
    public ConsumerFactory<String, Tenant> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfigs(), new StringDeserializer(),new JsonDeserializer<>(Tenant.class));
    }
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Tenant> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Tenant> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());

        return factory;
    }
    @Bean
    public Consumer receiver() {
        return new Consumer();
    }

    @Bean
    public Tenant receive1(){
        return  new Tenant();

    }
}

