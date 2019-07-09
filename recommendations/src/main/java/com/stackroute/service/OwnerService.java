package com.stackroute.service;

import com.stackroute.model.Owner;
import com.stackroute.model.StorageUnit;

import java.util.Collection;

public interface OwnerService {
    Owner createOwner(String ownerMail, StorageUnit storageUnit);

    public Collection<Owner> getAllOwners();
}
