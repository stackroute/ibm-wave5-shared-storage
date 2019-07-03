package com.stackroute.recommendations.repository;


import com.stackroute.recommendations.domain.Owner;
import com.stackroute.recommendations.domain.StorageUnit;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends Neo4jRepository<Owner,String> {

    @Query("CREATE (o:Owner) SET o.ownerMail={ownerMail}, o.storageUnit={storageUnit} RETURN o")

    Owner createOwner(String ownerMail, StorageUnit storageUnit);
}
