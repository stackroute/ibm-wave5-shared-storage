package com.stackroute.service;

import com.stackroute.model.Area;
import com.stackroute.model.Partition;
import com.stackroute.model.StorageUnit;

import java.util.Collection;
import java.util.List;

public interface LocatedInService {
    StorageUnit createAreaRelationship(long warehouseId, String area);

    public Partition createRelationshipArea(Long pid, String area);

    public Partition deleteRelationshipArea();

    public Collection<StorageUnit> createRecommendationSqft() throws Exception;

    public Collection<Area> createRecommendationLocation() throws Exception;

    public List<Area> LocationRelationship(String area) throws Exception;
}
