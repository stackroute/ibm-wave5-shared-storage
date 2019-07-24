package com.stackroute.service;

import com.stackroute.model.StorageUnit;

import java.util.Collection;


public interface HasAService
{

    public Collection<StorageUnit> getRelationship();

    StorageUnit createStorageUnitRelationship(long warehouseId, long pid);

    public Collection<StorageUnit> recommendationSqft() throws Exception;
}
