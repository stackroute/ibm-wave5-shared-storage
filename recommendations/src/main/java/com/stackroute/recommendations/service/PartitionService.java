package com.stackroute.recommendations.service;

import com.stackroute.recommendations.domain.Partition;

public interface PartitionService {
    public Partition createPartition(long pid, long area, long cost);
}
