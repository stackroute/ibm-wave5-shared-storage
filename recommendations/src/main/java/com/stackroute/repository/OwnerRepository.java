package com.stackroute.repository;


import com.stackroute.model.Owner;
import com.stackroute.model.StorageUnit;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface OwnerRepository extends Neo4jRepository<Owner,String> {

    @Query("CREATE (o:Owner) SET o.ownerMail={ownerMail}, o.storageUnit={storageUnit} RETURN o")

    Owner createOwner(String ownerMail, StorageUnit storageUnit);

    @Query("MATCH (u:Owner) WHERE u.ownerMail={ownerMail} RETURN u")
    public Owner getNode(@Param("ownerMail") String ownerMail);

    @Query("MATCH (n:Owner) RETURN n")
    public Collection<Owner> getAllOwners();
}
