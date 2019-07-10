package com.stackroute.service;

import com.stackroute.model.Addresses;
import com.stackroute.model.Partition;
import com.stackroute.model.StorageUnit;
import com.stackroute.repository.StorageUnitRepository;
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
    public StorageUnit createStorage(long warehouseId, String warehouseName, String ownerMail, Addresses addresses, List<Partition> partitions) {

        return storageUnitRepository.createStorageUnit(warehouseId,warehouseName,ownerMail, addresses,partitions);

    }

    @Override
    public StorageUnit findByName(String warehouseName) {
        return storageUnitRepository.getNode(warehouseName);
    }

    @Override
    public Collection<StorageUnit> getAllStorageUnit() {
        return storageUnitRepository.getAllStorageUnit();
    }

    @Override
    public StorageUnit delete(long warehouseId) {
        return storageUnitRepository.deleteNode(warehouseId);
    }


    @Override
    public StorageUnit deleteAll() {
        return storageUnitRepository.deleteAllNodes();
    }

    @Override
    public Collection<String> getAllPartition() {
        return storageUnitRepository.getAllPartition();
    }
}
