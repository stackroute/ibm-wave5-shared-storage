package com.stackroute.service;

import com.stackroute.model.User;
import com.stackroute.model.User1;
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
    public User1 createUserRelationship(String userMail, String uuid) {
        return bookedRepository.createRelationship(userMail,uuid) ;
    }

        @Override
    public Collection<User1> getRelationship() {
        return bookedRepository .getRelationship();
    }

//    @Override
//    public Collection<User1> getRelationship() {
//        return bookedRepository.getRelationship();
//    }




}
