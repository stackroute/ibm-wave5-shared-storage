package com.stackroute.recommendations.service;

import com.stackroute.recommendations.domain.Area;
import com.stackroute.recommendations.repository.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class AreaServiceImpl implements AreaService
{
    AreaRepository areaRepository;

    @Autowired
    public AreaServiceImpl(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }


    @Override
    public Area createArea(String area) {
        return areaRepository.createArea(area);
    }

    @Override
    public Collection<Area> getAllArea() {
        return areaRepository.getAllArea();
    }

    @Override
    public List<Area> getRecommendedLocation(String area) {
        return areaRepository.AreaRelationship(area);
    }

}
