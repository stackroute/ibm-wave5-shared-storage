package com.stackroute.recommendations.service;

import com.stackroute.recommendations.domain.Address;
import com.stackroute.recommendations.domain.Partition;
import com.stackroute.recommendations.domain.StorageUnit;
import com.stackroute.recommendations.repository.StorageUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class StorageUnitServiceImpl implements StorageUnitService {

    StorageUnitRepository storageUnitRepository;

    @Autowired
    public StorageUnitServiceImpl(StorageUnitRepository storageUnitRepository) {
        this.storageUnitRepository = storageUnitRepository;
    }

    @Override
    public StorageUnit createStorage(long warehouseId, String warehouseName, String ownerMail, Address address, List<Partition> partitions) {

        return storageUnitRepository.createStorageUnit(warehouseId,warehouseName,ownerMail,address,partitions);

    }

    @Override
    public Collection<StorageUnit> getAllStorageUnit() {
        return storageUnitRepository.getAllStorageUnit();
    }

//    @Override
//    public StorageUnit delete(long warehouseId) {
//        return storageUnitRepository.deleteNode(warehouseId);
//    }
//
//    @Override
//    public StorageUnit deleteAll() {
//        return storageUnitRepository.deleteAllNodes();
//    }
}
