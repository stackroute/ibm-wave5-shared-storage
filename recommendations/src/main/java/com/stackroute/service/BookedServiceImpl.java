package com.stackroute.service;

import com.stackroute.model.User;
import com.stackroute.repository.BookedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
