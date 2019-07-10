package com.stackroute.service;

import com.stackroute.model.Owner;
import com.stackroute.model.StorageUnit;
import com.stackroute.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;


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

    @Override
    public Collection<Owner> getAllOwners() {
        return ownerRepository.getAllOwners();
    }
}
