package com.tastyfood.omf.RestaurantSearchService.service;

import com.tastyfood.omf.RestaurantSearchService.model.Cuisine;
import com.tastyfood.omf.RestaurantSearchService.model.FoodItem;

import java.util.List;

public interface FoodItemService {

    List<FoodItem> findFoodItemByRestaurantID(Long restaurantId);

    List<FoodItem> findFoodItemByCuisine(Cuisine cuisine);

    FoodItem getFoodItemByID(long id);

    FoodItem saveItem(FoodItem item);
}
