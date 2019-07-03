package com.stackroute.recommendations.service;

import com.stackroute.recommendations.domain.Owner;
import com.stackroute.recommendations.domain.StorageUnit;

public interface OwnerService {
    Owner createOwner(String ownerMail, StorageUnit storageUnit);
}
