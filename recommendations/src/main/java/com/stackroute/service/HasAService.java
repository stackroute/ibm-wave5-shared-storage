package com.stackroute.service;

import com.stackroute.model.StorageUnit;

import java.util.Collection;


public interface HasAService
{
    StorageUnit createStorageUnitRelationship(long warehouseId, long pid);

    public Collection<StorageUnit> recommendationCost() throws Exception;
}
