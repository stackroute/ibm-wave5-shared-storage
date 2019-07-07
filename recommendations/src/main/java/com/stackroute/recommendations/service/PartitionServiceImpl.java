package com.stackroute.recommendations.service;

import com.stackroute.recommendations.domain.Partition;
import com.stackroute.recommendations.repository.PartitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;


@Service
public class PartitionServiceImpl implements PartitionService {

    PartitionRepository partitionRepository;

    @Autowired
    public PartitionServiceImpl(PartitionRepository partitionRepository) {
        this.partitionRepository = partitionRepository;
    }

    @Override
    public Partition createPartition(long pid, long sqft, long cost) {

        return partitionRepository.createPartition(pid,sqft,cost);
    }

    @Override
    public Collection<Partition> getAllPartitions() {
        return partitionRepository.getAllPartitions();
    }

    @Override
    public Partition delete(Long pid) {
        return partitionRepository.deleteNode(pid);
    }


}
