package com.stackroute.service;

import com.stackroute.model.Area;
import com.stackroute.model.City;

import java.util.Collection;

public interface CityService {

    Area createCity(String city);

    public Collection<City> getAllCity();
}
