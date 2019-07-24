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
    UserService userService;

    @Autowired
    PartitionService partitionService;

    @Autowired
    StorageUnitService storageUnitService;

    @Autowired
    AreaService areaService;

    @Autowired
    CityService cityService;

    @Autowired
    HasAService hasAService;

    @Autowired
    BookedService bookedService;

    @Autowired
    PartOfService partOfService;

    @Autowired
    LocatedInService locatedInService;

    @Autowired
    OwnsService ownsService;

    @Autowired
    OwnerService ownerService;

    Partition partition;

    private CountDownLatch latch = new CountDownLatch(1);

    public CountDownLatch getLatch() {
        return latch;
    }


    // Booking service consumed

    @KafkaListener(topics = "${kafka.topic.json6}")
    public void receive(@Payload Recommendation recommendation) {

        System.out.println(recommendation.toString());


        userService.createUser(recommendation.getUserMail(), recommendation);
        partitionService.createPartition(recommendation.getPid(), recommendation.getSqft(), recommendation.getCost(),recommendation.getLocation());

        bookedService.createUserRelationship(recommendation.getUserMail(), recommendation.getPid());

        LOGGER.info("received payload='{}'", recommendation.toString());

        latch.countDown();
    }

    // Warehouse consumed

    @KafkaListener(topics = "${kafka.topic.json7}")
    public void receive1(@Payload Warehouse warehouse) {

        System.out.println(warehouse.toString());

        List<Partitions> list = new ArrayList<>();
        list = warehouse.getPartitions();
        Partitions partitions=new Partitions();
        Partition partition = new Partition();

        List<Partition> list1 = new ArrayList<>();

        partition.setCityName(warehouse.getAddress().getCity());

        for (int i = 0; i < list.size(); i++) {

            partitions = list.get(i);
            partition.setCost(partitions.getCost());
            partition.setSqft(partitions.getSqft());
            partition.setPid(partitions.getPid());

            list1.add(partition);
        }

        StorageUnit s1 = new StorageUnit();

        s1.setOwnerMail(warehouse.getOwnerMail());
        s1.setWarehouseId(warehouse.getId());
        s1.setWarehouseName(warehouse.getWarehouseName());

        storageUnitService.createStorage(warehouse.getId(), warehouse.getWarehouseName(), warehouse.getOwnerMail(), warehouse.getImageUrl());

        for(int j = 0; j < list1.size(); j++) {

            partitionService.createPartition(warehouse.getPartitions().get(j).getPid(), warehouse.getPartitions().get(j).getSqft(), warehouse.getPartitions().get(j).getCost(), warehouse.getAddress().getArea());

            hasAService.createStorageUnitRelationship(warehouse.getId(), warehouse.getPartitions().get(j).getPid());

        }

        ownerService.createOwner(warehouse.getOwnerMail(), s1);

        areaService.createArea(warehouse.getAddress().getArea());

        cityService.createCity(warehouse.getAddress().getCity());

        partOfService.createAreaRelationship(warehouse.getAddress().getArea(), warehouse.getAddress().getCity());

        locatedInService.createAreaRelationship(warehouse.getId(), warehouse.getAddress().getArea());

        ownsService.createOwnerRelationship(warehouse.getOwnerMail(), warehouse.getId());

        LOGGER.info("received payload='{}'", warehouse.toString());

        latch.countDown();
    }

}