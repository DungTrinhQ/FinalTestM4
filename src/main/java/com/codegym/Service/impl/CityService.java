package com.codegym.Service.impl;

import com.codegym.Model.City;

import com.codegym.Repository.ICityRepository;
import com.codegym.Service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CityService implements ICityService {
    @Autowired
    ICityRepository cityRepository;
    @Override
    public List<City> getAllCity() {
        return (List<City>) cityRepository.findAll();
    }

    @Override
    public City addCity(City city) {
        return cityRepository.save(city);
    }

    @Override
    public City findCityById(Long id) {
        return cityRepository.findOne(id);
    }

    @Override
    public City updateCity(City city) {
        return cityRepository.save(city);
    }

    @Override
    public void removeCity(City city) {
        cityRepository.delete(city);
    }


}
