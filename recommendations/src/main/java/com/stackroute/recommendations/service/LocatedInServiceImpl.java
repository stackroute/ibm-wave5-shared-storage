package com.stackroute.recommendations.service;

import com.stackroute.recommendations.domain.StorageUnit;
import com.stackroute.recommendations.repository.LocatedInRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
