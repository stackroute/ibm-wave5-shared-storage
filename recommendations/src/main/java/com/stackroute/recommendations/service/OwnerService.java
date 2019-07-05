package com.stackroute.recommendations.service;

import com.stackroute.recommendations.domain.Owner;
import com.stackroute.recommendations.domain.StorageUnit;

import java.util.Collection;

public interface OwnerService {
    Owner createOwner(String ownerMail, StorageUnit storageUnit);

    public Collection<Owner> getAllOwners();
}
