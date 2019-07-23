package com.stackroute.service;

import com.stackroute.model.Partition;

import java.util.Collection;

public interface PartitionService {
    public Partition createPartition(long pid, long sqft, long cost, String cityName);

    public Partition findByPid(long pid);

    public Collection<Partition> getAllPartitions();

    public Partition delete(Long pid);

    public Partition update(long pid,long sqft,long cost);



}
