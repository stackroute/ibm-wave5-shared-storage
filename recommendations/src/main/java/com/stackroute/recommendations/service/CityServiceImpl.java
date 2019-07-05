package com.stackroute.recommendations.service;

import com.stackroute.recommendations.domain.Area;
import com.stackroute.recommendations.domain.City;
import com.stackroute.recommendations.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CityServiceImpl implements CityService
{
    CityRepository cityRepository;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public Area createCity(String city) {
        return cityRepository.createCity(city);
    }

    @Override
    public Collection<City> getAllCity() {
        return cityRepository.getAllCity();
    }
}
