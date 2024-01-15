package com.tastyfood.omf.OrderManagementService.service;

import com.tastyfood.omf.OrderManagementService.model.Restaurant;
import com.tastyfood.omf.OrderManagementService.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestautantServiceImpl implements RestaurantService{
    @Autowired
    RestaurantRepository restaurantRepository;

    @Override
    public List<Restaurant> getRestaurants() {
        return restaurantRepository.findAll();
    }

    public Optional<Restaurant> getRestFromId(Long id) {

        Optional<Restaurant> restaurant = restaurantRepository.findById(id);
        return restaurant;
    }
}
