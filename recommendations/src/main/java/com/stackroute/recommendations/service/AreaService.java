package com.stackroute.recommendations.service;

import com.stackroute.recommendations.domain.Area;

import java.util.Collection;
import java.util.List;

public interface AreaService
{
    Area createArea(String area);

    public Collection<Area> getAllArea();

    List<Area> getRecommendedLocation(String area);
}
