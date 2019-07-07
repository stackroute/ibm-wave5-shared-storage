package com.stackroute.recommendations.service;

import com.stackroute.recommendations.domain.Partition;
import com.stackroute.recommendations.domain.StorageUnit;
import com.stackroute.recommendations.domain.User;
import com.stackroute.recommendations.repository.BookedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;


@Service
public class BookedServiceImpl implements BookedService {

    BookedRepository bookedRepository;

    @Autowired
    public BookedServiceImpl(BookedRepository bookedRepository) {
        this.bookedRepository = bookedRepository;
    }

    @Override
    public User createUserRelationship(String userMail, long pid) {
        return bookedRepository.createRelationship(userMail,pid) ;
    }

    @Override
    public Collection<User> getRelationship() {
        return bookedRepository.getRelationship();
    }




}
