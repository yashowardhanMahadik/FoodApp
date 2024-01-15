package com.tastyfood.omf.OrderManagementService.service;

import com.tastyfood.omf.OrderManagementService.model.Restaurant;

import java.util.List;
import java.util.Optional;

public interface RestaurantService {

    public List<Restaurant> getRestaurants();
    public Optional<Restaurant> getRestFromId(Long id);
}
