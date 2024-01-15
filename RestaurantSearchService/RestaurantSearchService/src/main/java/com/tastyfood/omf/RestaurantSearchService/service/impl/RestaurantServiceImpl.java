package com.tastyfood.omf.RestaurantSearchService.service.impl;

import com.tastyfood.omf.RestaurantSearchService.model.Restaurant;
import com.tastyfood.omf.RestaurantSearchService.repository.CuisineRepository;
import com.tastyfood.omf.RestaurantSearchService.repository.RestaurantRepository;
import com.tastyfood.omf.RestaurantSearchService.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    private final CuisineRepository cuisineRepository;


    @Autowired
    RestaurantServiceImpl(RestaurantRepository repository, CuisineRepository cuisineRepository) {
        this.restaurantRepository = repository;
        this.cuisineRepository = cuisineRepository;
    }

    @Override
    public List<Restaurant> getAllRestaurants() {

        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant findRestaurantById(long id) {

        return restaurantRepository.findById(id).get();
    }

    @Override
    public List<Restaurant> getRestaurantByName(String name) {
        List<Restaurant> mList = restaurantRepository.findByNameContains(name);
        return mList;
    }

    @Override
    public List<Restaurant> searchRestaurant(String input) {


        List<Restaurant> mList = restaurantRepository.findByNameContainingIgnoreCaseOrLocationContainingIgnoreCase(input, input);
        List<Restaurant> mRestaurantListByCuisineName = getRestaurantByCuisineName(input);
        return Stream.concat(mList.stream(), mRestaurantListByCuisineName.stream()).distinct().collect(Collectors.toList());
    }

    @Override
    public List<Restaurant> getRestaurantByCuisineName(String input) {
        List<Restaurant> restaurantList = new ArrayList<>();
        cuisineRepository.findByNameContainingIgnoreCase(input).forEach(cuisine -> restaurantList.add(cuisine.getRestaurant())
        );

        return restaurantList.stream().distinct().collect(Collectors.toList());
    }

    @Override
    public List<Restaurant> getRestaurantNearByUserLoc() {

        return restaurantRepository.findByDistanceLessThanEqual(0.4);
    }


}
