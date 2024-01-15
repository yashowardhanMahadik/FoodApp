package com.tastyfood.omf.RestaurantSearchService.service;

import com.tastyfood.omf.RestaurantSearchService.model.Restaurant;

import java.util.List;

public interface RestaurantService {
     List<Restaurant> getAllRestaurants();

     Restaurant findRestaurantById(long id);

     List<Restaurant> getRestaurantByName(String name);

     List<Restaurant> searchRestaurant(String input);

     List<Restaurant> getRestaurantByCuisineName(String input);

    List<Restaurant> getRestaurantNearByUserLoc();
}
