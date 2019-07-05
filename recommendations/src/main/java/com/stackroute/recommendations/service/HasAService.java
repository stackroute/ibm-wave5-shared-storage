package com.stackroute.recommendations.service;

import com.stackroute.recommendations.domain.StorageUnit;



public interface HasAService
{
    StorageUnit createStorageUnitRelationship(long warehouseId, long pid);
}
