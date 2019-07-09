package com.stackroute.service;

import com.stackroute.model.Owner;
import com.stackroute.repository.OwnsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnsServiceImpl implements OwnsService
{
    OwnsRepository ownsRepository;

    @Autowired
    public OwnsServiceImpl(OwnsRepository ownsRepository) {
        this.ownsRepository = ownsRepository;
    }

    @Override
    public Owner createUserRelationship(String ownerMail, long warehouseId) {
        return ownsRepository.createRelationship(ownerMail,warehouseId) ;
    }

}


