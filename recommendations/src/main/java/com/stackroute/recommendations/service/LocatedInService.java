package com.stackroute.recommendations.service;

import com.stackroute.recommendations.domain.StorageUnit;

public interface LocatedInService {
    StorageUnit createAreaRelationship(long warehouseId, String area);
}
