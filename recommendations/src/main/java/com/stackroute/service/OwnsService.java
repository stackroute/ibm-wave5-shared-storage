package com.stackroute.service;

import com.stackroute.model.Owner;

public interface OwnsService
{
    Owner createOwnerRelationship(String ownerMail, long warehouseId);
}
