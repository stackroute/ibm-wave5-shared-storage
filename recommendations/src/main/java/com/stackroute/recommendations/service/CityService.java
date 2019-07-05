package com.stackroute.recommendations.service;

import com.stackroute.recommendations.domain.Area;
import com.stackroute.recommendations.domain.City;

import java.util.Collection;

public interface CityService {

    Area createCity(String city);

    public Collection<City> getAllCity();
}
