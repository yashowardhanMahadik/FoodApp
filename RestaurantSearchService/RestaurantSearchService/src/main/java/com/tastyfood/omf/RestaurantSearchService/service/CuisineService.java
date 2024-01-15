package com.tastyfood.omf.RestaurantSearchService.service;

import com.tastyfood.omf.RestaurantSearchService.model.Cuisine;

import java.util.List;

public interface CuisineService {

    public List<Cuisine> getCuisineByName(String name);

    public List<Cuisine> getDistinctCuisineByName(String name);
}
