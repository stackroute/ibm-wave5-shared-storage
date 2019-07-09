package com.stackroute.repository;


import com.stackroute.model.Address;
import com.stackroute.model.Partition;
import com.stackroute.model.StorageUnit;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface StorageUnitRepository extends Neo4jRepository <StorageUnit,Integer> {

    @Query("CREATE (s:StorageUnit) SET s.warehouseId={warehouseId}, s.warehouseName={warehouseName}, s.ownerMail={ownerMail}, s.address={address}")
    StorageUnit createStorageUnit(long warehouseId, String warehouseName, String ownerMail, Address address, List<Partition> partitions);

    @Query("MATCH (u:StorageUnit) WHERE u.warehouseId={warehouseId} RETURN u")
    public StorageUnit getNode(@Param("warehouseId") String warehouseName);

    @Query("MATCH (n:StorageUnit) RETURN n")
    public Collection<StorageUnit> getAllStorageUnit();


//    @Query("MATCH (n:StorageUnit) WHERE n.warehouseId={warehouseId} DETACH DELETE n RETURN 'node deleted' ")
//    public StorageUnit deleteNode(long warehouseId);
//
//    @Query("MATCH (StorageUnit) DETACH DELETE StorageUnit")
//    public StorageUnit deleteAllNodes();


}
