package com.stackroute.service;

import com.stackroute.model.Area;
import com.stackroute.model.StorageUnit;
import com.stackroute.repository.PartOfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PartOfServiceImpl implements PartOfService
{
    PartOfRepository partOfRepository;

    @Autowired
    public PartOfServiceImpl(PartOfRepository partOfRepository) {
        this.partOfRepository = partOfRepository;
    }

    @Override
    public Area createAreaRelationship(String area, String city) {
        return partOfRepository.createRelationship(area,city);
    }

    @Override
    public Collection<StorageUnit> getStorageUnitWithCity(String city)
    {
        System.out.println("########");
        return partOfRepository.getStorageUnitCity(city);
    }


}
