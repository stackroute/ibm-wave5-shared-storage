package com.stackroute.services;

import com.stackroute.exceptions.StorageUnitAlreadyExistsException;
import com.stackroute.exceptions.StorageUnitNotFound;
import com.stackroute.model.ActivityStream;
import com.stackroute.model.ListedStorageUnit;
//import com.stackroute.model.Partition;

import java.util.List;

public interface ListedService
{
    public List<ListedStorageUnit> getAllListedStorageUnit();
    public ListedStorageUnit saveListedStorageUnit(ListedStorageUnit listedStorageUnit) throws StorageUnitAlreadyExistsException;
    public boolean deleteListedStorageUnit(int id) throws StorageUnitNotFound;
    public ListedStorageUnit updateStorageUnit(ListedStorageUnit listedStorageUnit) throws StorageUnitNotFound;
}
