package com.stackroute.recommendations.service;

import com.stackroute.recommendations.domain.Area;
import com.stackroute.recommendations.domain.Partition;
import com.stackroute.recommendations.domain.StorageUnit;

import java.util.Collection;
import java.util.Collections;

public interface LocatedInService {
    StorageUnit createAreaRelationship(long warehouseId, String area);

//    public Partition createRelationshipCost(String cost, String area);

    public Partition createRelationshipArea(Long pid, String area);

    public Partition deleteRelationshipArea();

    public Collection<StorageUnit> createRecommendationSqft() throws Exception;

    public Collection<Area> createRecommendationLocation() throws Exception;
}
