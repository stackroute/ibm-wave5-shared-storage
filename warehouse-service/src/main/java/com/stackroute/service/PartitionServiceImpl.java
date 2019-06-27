//package com.stackroute.service;
//
//import com.stackroute.exceptions.WarehouseAlreadyExistsException;
//import com.stackroute.model.Partition;
//import com.stackroute.model.Warehouse;
//import com.stackroute.repository.PartitionRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//
//@Service
//public class PartitionServiceImpl implements PartitionService {
//
//    PartitionRepository partitionRepository;
//    @Autowired
//    public PartitionServiceImpl(PartitionRepository partitionRepository){
//        this.partitionRepository= partitionRepository;
//    }
//
//    @Override
//    public Partition savePartition(Partition partition)  throws WarehouseAlreadyExistsException {
//
//      Partition savedPartition = partitionRepository.save(partition);
//
//        return savedPartition;
//    }
//
//
//}
