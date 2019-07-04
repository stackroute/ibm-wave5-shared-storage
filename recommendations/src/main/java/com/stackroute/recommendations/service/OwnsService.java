package com.stackroute.recommendations.service;

import com.stackroute.recommendations.domain.Owner;

public interface OwnsService
{
    Owner createUserRelationship(String ownerMail, long warehouseId);
}
