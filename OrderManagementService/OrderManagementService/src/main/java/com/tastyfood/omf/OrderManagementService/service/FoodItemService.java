package com.tastyfood.omf.OrderManagementService.service;

import com.tastyfood.omf.OrderManagementService.model.FoodItem;
import com.tastyfood.omf.OrderManagementService.model.Restaurant;

import java.util.List;

public interface FoodItemService {

    List<FoodItem> findFoodItemByRestaurantID(Restaurant restaurant);

    FoodItem getFoodItemByID(long id);

    FoodItem saveItem(FoodItem item);
}
