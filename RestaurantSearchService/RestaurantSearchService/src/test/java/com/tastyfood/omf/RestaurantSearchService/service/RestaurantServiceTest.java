package com.tastyfood.omf.RestaurantSearchService.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RestaurantServiceTest {

    @Autowired
    RestaurantService restaurantService;

    @Test
    void getAllRestaurants() {
        restaurantService.getAllRestaurants();
    }

    @Test
    void findRestaurantById() {
        restaurantService.findRestaurantById(1);
    }

    @Test
    void getRestaurantByName() {
        restaurantService.getRestaurantByName("KFC");
    }

    @Test
    void searchRestaurant() {
        restaurantService.searchRestaurant("a");
    }

    @Test
    void getRestaurantByCuisineName() {
        restaurantService.getRestaurantByCuisineName("Indian");
    }

    @Test
    void getRestaurantNearByUserLoc() {
        restaurantService.getRestaurantNearByUserLoc();
    }
}