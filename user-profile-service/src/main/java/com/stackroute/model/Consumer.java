package com.stackroute.model;

import com.stackroute.exceptions.StorageUnitAlreadyExistsException;
import com.stackroute.repository.ListedRepository;
import com.stackroute.services.ActivityStreamImpl;
import com.stackroute.services.ActivityStreamService;
import com.stackroute.services.ListedService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;

import java.util.concurrent.CountDownLatch;

public class Consumer {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(Consumer.class);

    @Autowired
    ActivityStreamService activityStreamService;

    @Autowired
    ActivityStream activityStream;

//    private CountDownLatch latch = new CountDownLatch(1);
//
//    public CountDownLatch getLatch() {
//        return latch;
//    }

    @KafkaListener(topics = "${kafka.topic.json}")
    public void receive(@Payload ActivityStream activityStream){

        System.out.println(activityStream.toString());
        LOGGER.info("received payload='{}'", activityStream.toString());
//        System.out.println("Hi!");

//        ListedStorageUnit listedStorageUnit = new ListedStorageUnit();
//
//        a.setEmailId(activityStream.getOwner_mailid());
//////        a.setTotalPartition(activityStream.getTotal_sqft());
//        a.setOccupiedPartition(activityStream.getOccupied_partitions());
//        a.setLocation(activityStream.getLocation());
////
//        activityStream.getPartitions().forEach(e -> {
//            System.out.println(e.toString());
//            a.setId(e.getId());
//
//            try {
//                listedService.saveListedStorageUnit(e);
//            } catch (StorageUnitAlreadyExistsException ex) {
//                ex.printStackTrace();
//            }
//        });

//        activityStream.setEmailId(activityStream.getEmailId());
//        System.out.println("EmailId"+ activityStream.getEmailId());
//        listedStorageUnit.setRole(activityStream.getRole());
//        System.out.println("Role"+listedStorageUnit.getRole());
//        listedStorageUnit.setEmailId(activityStream.getEmailId());
//        System.out.println("EmailId"+listedStorageUnit.getEmailId());



        activityStreamService.saveActivityStream(activityStream);


        System.out.println(activityStream.toString());

//        latch.countDown();

    }
    }
