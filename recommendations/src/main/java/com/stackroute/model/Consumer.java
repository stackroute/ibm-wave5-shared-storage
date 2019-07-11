package com.stackroute.model;

import com.stackroute.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Consumer {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(Consumer.class);

    @Autowired
    Recommendation recommendation;

    @Autowired
    Warehouse warehouse;

    @Autowired
    Recommendations recommendations;

    @Autowired
    UserService userService;

    @Autowired
    PartitionService partitionService;

    @Autowired
    StorageUnitService storageUnitService;

    @Autowired
    AddressesService addressesService;

    @Autowired
    AreaService areaService;

    @Autowired
    CityService cityService;

    Partition partition;

    private CountDownLatch latch = new CountDownLatch(1);

    public CountDownLatch getLatch() {
        return latch;
    }

    @KafkaListener(topics = "${kafka.topic.json6}")
    public void receive(@Payload Recommendation recommendation) {

        System.out.println(recommendation.toString());
        partitionService.createPartition(recommendation.getPid(), recommendation.getSqft(), recommendation.getCost());
        LOGGER.info("received payload='{}'", recommendation.toString());

        latch.countDown();
    }

    @KafkaListener(topics = "${kafka.topic.json7}")
    public void receive1(@Payload Warehouse warehouse) {

        System.out.println(warehouse.toString());

        List<Partitions> list = new ArrayList<>();
        list = warehouse.getPartitions();
        Partitions partitions=new Partitions();
        Partition partition = new Partition();

        List<Partition> list1 = new ArrayList<>();


        for (int i = 0; i < list.size(); i++) {

//                    list1.get(i).setPid(list.get(i).getPid());
//                    list1.get(i).setSqft(list.get(i).getSqft());
//                    list1.get(i).setCost(list.get(i).getCost());

                partitions = list.get(i);
                partition.setCost(partitions.getCost());
                partition.setSqft(partitions.getSqft());
                partition.setPid(partitions.getPid());
                list1.add(partition);

        }

        storageUnitService.createStorage(warehouse.getId(), warehouse.getWarehouseName(), warehouse.getOwnerMail(), list1);

        addressesService.createAddresses(warehouse.getAddress().getArea(),warehouse.getAddress().getCity(), warehouse.getAddress().getState(), warehouse.getAddress().getCountry());

        areaService.createArea(warehouse.getAddress().getArea());

        cityService.createCity(warehouse.getAddress().getCity());

        LOGGER.info("received payload='{}'", warehouse.toString());

        latch.countDown();
    }

    @KafkaListener(topics = "${kafka.topic.json8}")
    public void receive1(@Payload Recommendations recommendations) {

        System.out.println(recommendations.toString());

        userService.createUser(recommendations.getEmailId(), recommendations);
        LOGGER.info("received payload='{}'", recommendations.toString());

        latch.countDown();
    }

}