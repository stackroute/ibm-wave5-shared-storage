package com.stackroute.recommendations.service;

import com.stackroute.recommendations.domain.Address;
import com.stackroute.recommendations.domain.Partition;
import com.stackroute.recommendations.domain.StorageUnit;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface StorageUnitService {
    public StorageUnit createStorage(long warehouseId, String warehouseName, String ownerMail, Address address, List<Partition> partitions) ;
}
