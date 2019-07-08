package com.stackroute.recommendations.service;

import com.stackroute.recommendations.domain.Partition;

import java.util.Collection;

public interface PartitionService {
    public Partition createPartition(long pid, long sqft, long cost);

    public Collection<Partition> getAllPartitions();

    public Partition delete(Long pid);

    public Partition update(long pid,long sqft,long cost);



}
