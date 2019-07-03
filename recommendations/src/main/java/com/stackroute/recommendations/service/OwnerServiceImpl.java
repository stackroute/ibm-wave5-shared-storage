package com.stackroute.recommendations.service;

import com.stackroute.recommendations.domain.Owner;
import com.stackroute.recommendations.domain.StorageUnit;
import com.stackroute.recommendations.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OwnerServiceImpl implements OwnerService {


    OwnerRepository ownerRepository ;


    @Autowired
    public OwnerServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Owner createOwner(String ownerMail, StorageUnit storageUnit) {
        return ownerRepository.createOwner(ownerMail,storageUnit);
    }
}
