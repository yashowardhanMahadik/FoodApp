package com.tastyfood.omf.RestaurantSearchService;

import com.tastyfood.omf.RestaurantSearchService.model.Cuisine;
import com.tastyfood.omf.RestaurantSearchService.model.FoodItem;
import com.tastyfood.omf.RestaurantSearchService.model.Restaurant;
import com.tastyfood.omf.RestaurantSearchService.repository.FoodItemRepository;
import com.tastyfood.omf.RestaurantSearchService.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class RestaurantSearchServiceApplication implements CommandLineRunner {

	@Autowired
	RestaurantRepository restaurantRepository;
	@Autowired
	FoodItemRepository foodItemRepository;


	public static void main(String[] args) {
		SpringApplication.run(RestaurantSearchServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Restaurant restaurant1 = new Restaurant("Zaayka", "Mumbai", 0.25, 100);
		restaurantRepository.save(restaurant1);


		List<FoodItem> iteneraryList = new ArrayList<>();
		iteneraryList.add(FoodItem.builder().foodName("Pav Bhaji").restaurant(restaurant1).cuisine(Cuisine.AMERICAN)
				.price(100d).supply(50).build());
		iteneraryList.add(FoodItem.builder().foodName("Chicken Mughalai").restaurant(restaurant1).cuisine(Cuisine.CONTINENTAL
		).price(400d).supply(50).build());
		foodItemRepository.saveAll(iteneraryList);
		iteneraryList.clear();

		restaurant1 = new Restaurant("Truffles", "Bengaluru", 0.4, 150d);
		restaurantRepository.save(restaurant1);
		iteneraryList.add(FoodItem.builder().foodName("Chicken Rooster Burger").restaurant(restaurant1).cuisine(Cuisine.INDIAN
		).price(150d).supply(50).build());
		iteneraryList.add(FoodItem.builder().foodName("Pasta").restaurant(restaurant1).cuisine(Cuisine.AMERICAN
		).price(100d).supply(50).build());
		foodItemRepository.saveAll(iteneraryList);
		iteneraryList.clear();

		restaurant1 = new Restaurant("Udupi", "Bengaluru", 0.6, 100d);
		restaurantRepository.save(restaurant1);

		iteneraryList.add(FoodItem.builder().foodName("Dhokla").price(40d).restaurant(restaurant1).cuisine(Cuisine.INDIAN
		).supply(50).build());
		iteneraryList.add(FoodItem.builder().foodName("Masala Dosa").restaurant(restaurant1).cuisine(Cuisine.INDIAN
		).price(70d).supply(50).build());
		iteneraryList.add(FoodItem.builder().foodName("Idly").restaurant(restaurant1).cuisine(Cuisine.INDIAN
		).price(50d).supply(50).build());
		foodItemRepository.saveAll(iteneraryList);
		iteneraryList.clear();

		restaurant1 = new Restaurant("Natraj Chole", "Delhi", 3, 200d);
		restaurantRepository.save(restaurant1);

		restaurant1 = new Restaurant("Litti House", "Bihar", 4, 200d);
		restaurantRepository.save(restaurant1);
		restaurant1 = new Restaurant("Sky Garden", "Bengaluru", 4, 200d);
		restaurantRepository.save(restaurant1);
		restaurant1 = new Restaurant("Kapoors Cafe", "Mumbai", 4, 200d);
		restaurantRepository.save(restaurant1);

	}

}