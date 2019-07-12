package com.stackroute.service;

import com.stackroute.model.Area;
import com.stackroute.model.Partition;
import com.stackroute.model.StorageUnit;
import com.stackroute.repository.LocatedInRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class LocatedInServiceImpl implements LocatedInService
{
    LocatedInRepository locatedInRepository;

    @Autowired
    public LocatedInServiceImpl(LocatedInRepository locatedInRepository) {
        this.locatedInRepository = locatedInRepository;
    }


    @Override
    public StorageUnit createAreaRelationship(long warehouseId, String area) {
        return locatedInRepository.createRelationship(warehouseId,area);

    }

    @Override
    public Partition createRelationshipArea(Long pid, String area) {
        return locatedInRepository.createRelationshipArea(pid,area);
    }

    @Override
    public Partition deleteRelationshipArea() {
        return locatedInRepository.deleteRelationshipArea();
    }

    @Override
    public Collection<StorageUnit> createRecommendationLocation() throws Exception {
        return locatedInRepository.createRecommendationLocation();
    }



}


