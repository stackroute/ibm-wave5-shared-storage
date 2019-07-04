package com.stackroute.recommendations.service;

import com.stackroute.recommendations.domain.StorageUnit;
import com.stackroute.recommendations.repository.HasARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HasAServiceImpl implements HasAService
{
    HasARepository hasARepository;

    @Autowired
    public HasAServiceImpl(HasARepository hasARepository) {
        this.hasARepository = hasARepository;
    }

    @Override
    public StorageUnit createStorageUnitRelationship(long warehouseId, long pid) {
        return hasARepository.createRelationship(warehouseId,pid);
    }
}
