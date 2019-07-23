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

import java.sql.SQLOutput;
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


    @KafkaListener(topics = "${kafka.topic.json}")
    public void receive(@Payload UserProfile userProfiles) {

        System.out.println(userProfiles.toString());
        LOGGER.info("received payload='{}'", userProfiles.toString());

        userProfile = userProfiles;

        userProfileService.saveUserProfile(userProfiles);

    }

    @KafkaListener(topics = "${kafka.topic.json3}")
    public void receive1(@Payload ListedStorageUnit listedStorageUnit) throws StorageUnitAlreadyExistsException {

        System.out.println(listedStorageUnit.toString());
        LOGGER.info("received payload='{}'", listedStorageUnit.toString());

        System.out.println(userProfileService.getUserProfileByEmailId(listedStorageUnit.getEmailId()));

        ListedStorageUnit list = new ListedStorageUnit();

        UserProfile eachMember = userProfileService.getUserProfileByEmailId(listedStorageUnit.getEmailId());

        list.setEmailId(listedStorageUnit.getEmailId());
        list.setId(listedStorageUnit.getId());
        list.setName(listedStorageUnit.getName());
        list.setAddress(listedStorageUnit.getAddress());
        list.setOccupiedPartition(listedStorageUnit.getOccupiedPartition());
        list.setTotalPartition(listedStorageUnit.getTotalPartition());
        list.setImageUrl(listedStorageUnit.getImageUrl());

        eachMember.getListedStorageUnit().add(list);

        userProfileService.saveUserProfile(eachMember);

    }

    @KafkaListener(topics = "${kafka.topic.json2}")
    public void receive2(@Payload BookedStorageUnit bookedStorageUnit) throws StorageUnitAlreadyExistsException {

        System.out.println(bookedStorageUnit.toString());
        LOGGER.info("received payload='{}'", bookedStorageUnit.toString());

        System.out.println(userProfileService.getUserProfileByEmailId(bookedStorageUnit.getEmailId()));

        UserProfile eachMemeber = userProfileService.getUserProfileByEmailId(bookedStorageUnit.getEmailId());

        BookedStorageUnit book = new BookedStorageUnit();
        book.setEmailId(bookedStorageUnit.getEmailId());
        book.setId(bookedStorageUnit.getId());
        book.setName(bookedStorageUnit.getName());
        book.setLocation(bookedStorageUnit.getLocation());
        book.setSqft(bookedStorageUnit.getSqft());
        book.setStartDate(bookedStorageUnit.getStartDate());
        book.setEndDate(bookedStorageUnit.getEndDate());
        

        eachMemeber.getBookedStorageUnit().add(book);

        userProfileService.saveUserProfile(eachMemeber);

    }
}