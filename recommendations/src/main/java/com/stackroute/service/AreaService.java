package com.stackroute.service;

import com.stackroute.model.Area;

import java.util.Collection;
import java.util.List;

public interface AreaService
{
    Area createArea(String area);

    public Collection<Area> getAllArea();

    List<Area> getRecommendedLocation(String area);
}
