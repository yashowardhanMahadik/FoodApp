package com.tastyfood.omf.RestaurantSearchService.repository;

import com.tastyfood.omf.RestaurantSearchService.model.Cuisine;
import com.tastyfood.omf.RestaurantSearchService.model.FoodItem;
import com.tastyfood.omf.RestaurantSearchService.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodItemRepository extends JpaRepository<FoodItem,Long> {

    List<FoodItem> findFoodItemByRestaurant(Restaurant restaurant);

    List<FoodItem> findFoodItemByCuisine(Cuisine cuisine);
}
