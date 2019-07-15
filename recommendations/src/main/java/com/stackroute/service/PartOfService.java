package com.stackroute.service;

import com.stackroute.model.Area;
import com.stackroute.model.StorageUnit;

import java.util.Collection;

public interface PartOfService
{
    Area createAreaRelationship(String area, String city);

    public Collection<StorageUnit> getStorageUnitWithCity(String city);

}
