package com.stackroute.recommendations.service;

import com.stackroute.recommendations.domain.Partition;

import java.util.Collection;

public interface PartitionService {
    public Partition createPartition(long pid, long area, long cost);

    public Collection<Partition> getAllPartitions();
}
