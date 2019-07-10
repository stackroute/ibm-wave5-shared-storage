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

import java.util.ArrayList;
import java.util.List;
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

    private List<ListedStorageUnit> listedStorageArray = new ArrayList<>();
    private List<BookedStorageUnit> bookedStorageArray = new ArrayList<>();

    private CountDownLatch latch = new CountDownLatch(1);

    public CountDownLatch getLatch() {
        return latch;
    }

    @KafkaListener(topics = "${kafka.topic.json}")
    public void receive(@Payload ActivityStream activityStreams) {

        System.out.println(activityStreams.toString());
        LOGGER.info("received payload='{}'", activityStreams.toString());

        activityStream = activityStreams;
        activityStreamService.saveActivityStream(activityStreams);

        latch.countDown();
    }

    @KafkaListener(topics = "${kafka.topic.json3}")
    public void receive1(@Payload ListedStorageUnit listedStorageUnit) throws StorageUnitAlreadyExistsException {

        System.out.println(listedStorageUnit.toString());
        LOGGER.info("received payload='{}'", listedStorageUnit.toString());

        listedStorageArray.add(listedStorageUnit);

//        if(activityStream.getRole()== "OWNER" || activityStream.getRole() == "owner") {
        merge();
//        }
//        else
//        {
//            listedService.saveListedStorageUnit(listedStorageUnit);
//        }
        System.out.println(activityStream);
//        listedService.saveListedStorageUnit()
        activityStreamService.saveActivityStream(activityStream);

        latch.countDown();
    }

    @KafkaListener(topics = "${kafka.topic.json2}")
    public void receive2(@Payload BookedStorageUnit bookedStorageUnit) throws StorageUnitAlreadyExistsException{

        System.out.println(bookedStorageUnit.toString());
        LOGGER.info("received payload='{}'", bookedStorageUnit.toString());

        bookedStorageArray.add(bookedStorageUnit);

        merge1();
        System.out.println(activityStream);
        activityStreamService.saveActivityStream(activityStream);

//        bookedService.saveBookedStorageUnit(bookedStorageUnit);

        latch.countDown();
    }

    public void merge(){
        activityStream.setListedStorageUnit(listedStorageArray);
    }
    public void merge1(){
        activityStream.setBookedStorageUnit(bookedStorageArray);
    }
}