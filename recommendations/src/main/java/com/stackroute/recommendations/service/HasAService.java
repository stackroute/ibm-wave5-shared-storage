package com.stackroute.recommendations.service;

import com.stackroute.recommendations.domain.StorageUnit;

import java.util.Collection;


public interface HasAService
{
    StorageUnit createStorageUnitRelationship(long warehouseId, long pid);

    public Collection<StorageUnit> recommendationCost() throws Exception;
}
