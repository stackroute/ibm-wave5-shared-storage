package com.stackroute.recommendations.service;

import com.stackroute.recommendations.domain.Area;

public interface PartOfService
{
    Area createAreaRelationship(String area, String city);

}
