package com.tastyfood.omf.OrderManagementService.service;

import com.tastyfood.omf.OrderManagementService.model.FoodItem;
import com.tastyfood.omf.OrderManagementService.model.Restaurant;
import com.tastyfood.omf.OrderManagementService.repository.FoodItemRepository;
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
    public List<FoodItem> findFoodItemByRestaurantID(Restaurant restaurant) {

       return foodItemRepository.findFoodItemByRestaurant(restaurant);
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
