package com.stackroute.recommendations.repository;


import com.stackroute.recommendations.domain.Address;
import com.stackroute.recommendations.domain.Partition;
import com.stackroute.recommendations.domain.StorageUnit;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StorageUnitRepository extends Neo4jRepository <StorageUnit,Integer> {

    @Query("CREATE (s:StorageUnit) SET s.warehouseId={warehouseId}, s.warehouseName={warehouseName}, s.ownerMail={ownerMail}, s.address={address}")

    StorageUnit createStorageUnit(long warehouseId, String warehouseName, String ownerMail, Address address, List<Partition> partitions);
}
