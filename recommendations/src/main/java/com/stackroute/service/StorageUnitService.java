package com.stackroute.service;

import com.stackroute.model.Addresses;
import com.stackroute.model.Partition;
import com.stackroute.model.StorageUnit;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;


@Service
public interface StorageUnitService {
    public StorageUnit createStorage(int warehouseId, String warehouseName, String ownerMail, List<Partition> partitions) ;

    public Collection<StorageUnit> getAllStorageUnit();

//    public StorageUnit delete(long warehouseId);
//    public StorageUnit deleteAll();
}
