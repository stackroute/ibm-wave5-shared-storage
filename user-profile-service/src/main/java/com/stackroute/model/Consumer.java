package com.stackroute.model;

import com.stackroute.exceptions.StorageUnitAlreadyExistsException;
import com.stackroute.services.UserProfileService;
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
    UserProfileService userProfileService;

    @Autowired
    UserProfile userProfile;

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
    public void receive(@Payload UserProfile userProfiles) {

        System.out.println(userProfiles.toString());
        LOGGER.info("received payload='{}'", userProfiles.toString());

        userProfile = userProfiles;

        userProfileService.saveUserProfile(userProfiles);

        latch.countDown();
    }

    @KafkaListener(topics = "${kafka.topic.json3}")
    public void receive1(@Payload ListedStorageUnit listedStorageUnit) throws StorageUnitAlreadyExistsException {

        System.out.println(listedStorageUnit.toString());
        LOGGER.info("received payload='{}'", listedStorageUnit.toString());

        listedStorageArray.add(listedStorageUnit);

        merge();

        System.out.println(userProfile);
//        listedService.saveListedStorageUnit()
        userProfileService.saveUserProfile(userProfile);

        latch.countDown();
    }

    @KafkaListener(topics = "${kafka.topic.json2}")
    public void receive2(@Payload BookedStorageUnit bookedStorageUnit) throws StorageUnitAlreadyExistsException{

        System.out.println(bookedStorageUnit.toString());
        LOGGER.info("received payload='{}'", bookedStorageUnit.toString());

        bookedStorageArray.add(bookedStorageUnit);

        merge1();
        System.out.println(userProfile);
        userProfileService.saveUserProfile(userProfile);

//        bookedService.saveBookedStorageUnit(bookedStorageUnit);

        latch.countDown();
    }

    public void merge(){
        userProfile.setListedStorageUnit(listedStorageArray);
    }
    public void merge1(){
        userProfile.setBookedStorageUnit(bookedStorageArray);
    }
}