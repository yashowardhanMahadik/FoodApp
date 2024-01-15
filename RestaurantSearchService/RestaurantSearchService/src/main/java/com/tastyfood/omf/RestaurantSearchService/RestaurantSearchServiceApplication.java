package com.tastyfood.omf.RestaurantSearchService;

import com.tastyfood.omf.RestaurantSearchService.model.*;
import com.tastyfood.omf.RestaurantSearchService.repository.CuisineRepository;
import com.tastyfood.omf.RestaurantSearchService.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class RestaurantSearchServiceApplication implements CommandLineRunner {

	@Autowired
	CuisineRepository cuisineRepository;

	@Autowired
	RestaurantRepository restaurantRepository;


	public static void main(String[] args) {
		SpringApplication.run(RestaurantSearchServiceApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Override
	public void run(String... args) throws Exception {

		Restaurant restaurant1 = new Restaurant("KFC", "Bengaluru", 0.25, 100d);
		restaurantRepository.save(restaurant1);

		List<Cuisine> cuisineList = new ArrayList<>();

		cuisineList.add(Cuisine.builder().restaurant(restaurant1).name("Indian").build());
		cuisineList.add(Cuisine.builder().restaurant(restaurant1).name("American").build());
		cuisineList.add(Cuisine.builder().restaurant(restaurant1).name("Italian").build());
		cuisineList.add(Cuisine.builder().restaurant(restaurant1).name("Chinese").build());
		cuisineRepository.saveAll(cuisineList);
		cuisineList.clear();

		restaurant1 = new Restaurant("gujarat Snacks", "Delhi", 3, 200d);
		restaurantRepository.save(restaurant1);

		restaurant1 = new Restaurant("Gujarat Snacks", "Bihar", 4, 200d);
		restaurantRepository.save(restaurant1);


	}

	public static OrderDetail getDemoOrderDetail(){


		Payment payment = Payment.builder().paymentMode("Upi")
				.date(new Date().getTime())
				.amountPaid(255d).build();

		OrderDetail orderDetail= OrderDetail.builder()
				.amountToBePaid(255)
				.payment(payment)
				.foodItems("10,22,12")
				.restId(11)
				.userId(2).build();
		return orderDetail;
	}
}