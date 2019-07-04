package com.stackroute.model;

import com.stackroute.exceptions.StorageUnitAlreadyExistsException;
import com.stackroute.services.ActivityStreamService;
import com.stackroute.services.BookedService;
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

    @Autowired
    ListedService listedService;

    @Autowired
    ListedStorageUnit listedStorageUnit;

    @Autowired
    BookedService bookedService;


    private CountDownLatch latch = new CountDownLatch(1);

    public CountDownLatch getLatch() {
        return latch;
    }

    @KafkaListener(topics = "${kafka.topic.json}")
    public void receive(@Payload ActivityStream activityStream){

        System.out.println(activityStream.toString());
        LOGGER.info("received payload='{}'", activityStream.toString());

        activityStreamService.saveActivityStream(activityStream);

        System.out.println(activityStream.toString());

        latch.countDown();
    }

    @KafkaListener(topics = "${kafka.topic.json1}")
    public void receive1(@Payload ListedStorageUnit listedStorageUnit) throws StorageUnitAlreadyExistsException{

        System.out.println(listedStorageUnit.toString());
        LOGGER.info("received payload='{}'", listedStorageUnit.toString());

        listedService.saveListedStorageUnit(listedStorageUnit);

        System.out.println(listedStorageUnit.toString());

        latch.countDown();
    }

    @KafkaListener(topics = "${kafka.topic.json2}")
    public void receive2(@Payload BookedStorageUnit bookedStorageUnit) throws StorageUnitAlreadyExistsException{

        System.out.println(bookedStorageUnit.toString());
        LOGGER.info("received payload='{}'", bookedStorageUnit.toString());

        bookedService.saveBookedStorageUnit(bookedStorageUnit);

        System.out.println(bookedStorageUnit.toString());

        latch.countDown();
    }
}