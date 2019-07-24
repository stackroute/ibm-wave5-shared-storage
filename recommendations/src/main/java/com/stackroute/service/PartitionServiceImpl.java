package com.stackroute.service;

import com.stackroute.model.Partition;
import com.stackroute.repository.PartitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class PartitionServiceImpl implements PartitionService {

    PartitionRepository partitionRepository;

    @Autowired
    public PartitionServiceImpl(PartitionRepository partitionRepository) {
        this.partitionRepository = partitionRepository;
    }

    @Override
    public Partition createPartition(long pid, long sqft, long cost, String cityName) {

        return partitionRepository.createPartition(pid,sqft,cost,cityName);
    }

    @Override
    public Partition findByPid(long pid) {
        return partitionRepository.getNode(pid);
    }

    @Override
    public Collection<Partition> getAllPartitions() {
        return partitionRepository.getAllPartitions();
    }

    @Override
    public Partition delete(Long pid) {
        return partitionRepository.deleteNode(pid);
    }

    @Override
    public Partition update(long pid, long sqft, long cost) {
        return partitionRepository.updateNode(pid, sqft, cost);
    }


}
