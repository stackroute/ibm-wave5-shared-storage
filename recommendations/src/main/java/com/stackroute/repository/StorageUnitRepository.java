package com.stackroute.repository;


import com.stackroute.model.Addresses;
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

    @Query("CREATE (s:StorageUnit) SET s.warehouseId={warehouseId}, s.warehouseName={warehouseName}, s.ownerMail={ownerMail}, s.imageUrl={imageUrl} ")
    StorageUnit createStorageUnit(long warehouseId, String warehouseName, String ownerMail, String imageUrl);

    @Query("MATCH (u:StorageUnit) WHERE u.warehouseName={warehouseName} RETURN u")
    public StorageUnit getNode(@Param("warehouseName") String warehouseName);

    @Query("MATCH (n:StorageUnit) RETURN n")
    public Collection<StorageUnit> getAllStorageUnit();


    @Query("MATCH (n:Partition)-[:HasA]-(s:StorageUnit) WHERE s.warehouseName=n.warehouseName RETURN n.warehouseName")
    public Collection<String> getAllPartition();


    @Query("MATCH (n:StorageUnit) WHERE n.warehouseId={warehouseId} DETACH DELETE n RETURN 'node deleted' ")
    public StorageUnit deleteNode(long warehouseId);

    @Query("MATCH (StorageUnit) DETACH DELETE StorageUnit")
    public StorageUnit deleteAllNodes();

    @Query("MATCH (c:Partition)<-[:HasA]-(m:StorageUnit)-[:LocatedIn]->(n:Area) WHERE c.sqft={sqft} RETURN m")
    public Collection<StorageUnit> getBySqft(long sqft);

    @Query("MATCH (c:Partition)<-[:HasA]-(m:StorageUnit)-[:LocatedIn]->(n:Area) WHERE n.area={area} and c.sqft={sqft} RETURN m")
    public Collection<StorageUnit> getByLocationAndSqft(String area, Long sqft);


}
