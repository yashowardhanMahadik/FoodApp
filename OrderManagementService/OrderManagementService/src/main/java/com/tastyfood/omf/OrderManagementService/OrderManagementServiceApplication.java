package com.tastyfood.omf.OrderManagementService;

import com.tastyfood.omf.OrderManagementService.model.Cuisine;
import com.tastyfood.omf.OrderManagementService.model.FoodItem;
import com.tastyfood.omf.OrderManagementService.model.Restaurant;
import com.tastyfood.omf.OrderManagementService.repository.FoodItemRepository;
import com.tastyfood.omf.OrderManagementService.repository.RestaurantRepository;
import com.tastyfood.omf.OrderManagementService.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class OrderManagementServiceApplication implements CommandLineRunner {

	@Autowired
	OrderServiceImpl orderService;
	@Autowired
	RestaurantRepository restaurantRepository;
	@Autowired
	FoodItemRepository foodItemRepository;

	public static void main(String[] args) {
		SpringApplication.run(OrderManagementServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Restaurant restaurant1 = new Restaurant("Udapi", "mumbai", 0.25, 100);
		restaurantRepository.save(restaurant1);


		List<FoodItem> iteneraryList = new ArrayList<>();
		iteneraryList.add(FoodItem.builder().foodName("Pav Bhaji").restaurant(restaurant1).cuisine(Cuisine.AMERICAN)
				.price(100d).supply(50).build());
		iteneraryList.add(FoodItem.builder().foodName("Chicken Mughalai").restaurant(restaurant1).cuisine(Cuisine.CONTINENTAL
				).price(400d).supply(50).build());
		foodItemRepository.saveAll(iteneraryList);
//		FoodItem food = new FoodItem(1,"ab",35,50,Cuisine.AMERICAN,restaurant1);
//		foodItemRepository.save(food);
		iteneraryList.clear();

		restaurant1 = new Restaurant("Hotel sRk ", "gujarat", 0.4, 150d);
		restaurantRepository.save(restaurant1);
		iteneraryList.add(FoodItem.builder().foodName("daal Khichdi").restaurant(restaurant1).cuisine(Cuisine.INDIAN
				).price(150d).supply(50).build());
		iteneraryList.add(FoodItem.builder().foodName("roti sabji").restaurant(restaurant1).cuisine(Cuisine.AMERICAN
				).price(100d).supply(50).build());
		foodItemRepository.saveAll(iteneraryList);
		iteneraryList.clear();

		restaurant1 = new Restaurant("Udupi", "Karnataka", 0.6, 100d);
		restaurantRepository.save(restaurant1);

		iteneraryList.add(FoodItem.builder().foodName("Dhokla").price(40d).restaurant(restaurant1).cuisine(Cuisine.INDIAN
				).supply(50).build());
		iteneraryList.add(FoodItem.builder().foodName("Masala Dosa").restaurant(restaurant1).cuisine(Cuisine.INDIAN
				).price(70d).supply(50).build());
		iteneraryList.add(FoodItem.builder().foodName("Idly").restaurant(restaurant1).cuisine(Cuisine.INDIAN
				).price(50d).supply(50).build());
		foodItemRepository.saveAll(iteneraryList);
		iteneraryList.clear();

		restaurant1 = new Restaurant("gujarat Snacks", "Delhi", 3, 200d);
		restaurantRepository.save(restaurant1);

		restaurant1 = new Restaurant("Gujarat Snacks", "Bihar", 4, 200d);
		restaurantRepository.save(restaurant1);



	}
}