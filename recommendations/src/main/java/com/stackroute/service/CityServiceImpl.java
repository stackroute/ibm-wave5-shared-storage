package com.stackroute.service;

import com.stackroute.model.Area;
import com.stackroute.model.City;
import com.stackroute.repository.CityRepository;
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
