package com.tastyfood.omf.OrderManagementService.service;

import com.tastyfood.omf.OrderManagementService.model.Cuisine;
import com.tastyfood.omf.OrderManagementService.model.FoodItem;

import java.util.List;

public interface FoodItemService {

    List<FoodItem> findFoodItemByRestaurantID(Long restaurantId);

    List<FoodItem> findFoodItemByCuisine(Cuisine cuisine);

    FoodItem getFoodItemByID(long id);

    FoodItem saveItem(FoodItem item);
}
