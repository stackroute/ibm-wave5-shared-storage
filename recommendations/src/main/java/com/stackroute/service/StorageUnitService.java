package com.stackroute.service;

import com.stackroute.model.Partition;
import com.stackroute.model.StorageUnit;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;


@Service
public interface StorageUnitService {
    public StorageUnit createStorage(long warehouseId, String warehouseName, String ownerMail, String imageUrl) ;

    public StorageUnit findByName(String warehouseName);

    public Collection<StorageUnit> getAllStorageUnit();

    public StorageUnit delete(long warehouseId);

    public StorageUnit deleteAll();

    public Collection<String> getAllPartition();

//    public Collection<StorageUnit> getStorageUnitCity(String city);

    public Collection<StorageUnit> getStorageUnitSqft(long sqft);

    public Collection<StorageUnit> getStorageUnitLocationsqft(String area, Long sqft);

}
