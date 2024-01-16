package com.tastyfood.omf.RestaurantSearchService.service.impl;

import com.tastyfood.omf.RestaurantSearchService.model.Cuisine;
import com.tastyfood.omf.RestaurantSearchService.model.FoodItem;
import com.tastyfood.omf.RestaurantSearchService.model.Restaurant;
import com.tastyfood.omf.RestaurantSearchService.repository.FoodItemRepository;
import com.tastyfood.omf.RestaurantSearchService.service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodItemServiceImpl implements FoodItemService {

    FoodItemRepository foodItemRepository;

    @Autowired
    FoodItemServiceImpl(FoodItemRepository foodItemRepository){
        this.foodItemRepository=foodItemRepository;
    }

    @Override
    public List<FoodItem> findFoodItemByRestaurantID(Long restaurantId) {
       return foodItemRepository.findFoodItemByRestaurant(Restaurant.builder().id(restaurantId).build());
    }

    @Override
    public List<FoodItem> findFoodItemByCuisine(Cuisine cuisine) {
        return foodItemRepository.findFoodItemByCuisine(cuisine);
    }

    @Override
    public FoodItem getFoodItemByID(long id){
       return foodItemRepository.findById(id).get();
    }

    @Override
    public FoodItem saveItem(FoodItem item) {
       return foodItemRepository.save(item);
    }
}
