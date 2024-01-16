package com.tastyfood.omf.RestaurantSearchService.controller;

import com.tastyfood.omf.RestaurantSearchService.model.Cuisine;
import com.tastyfood.omf.RestaurantSearchService.model.FoodItem;
import com.tastyfood.omf.RestaurantSearchService.model.Restaurant;
import com.tastyfood.omf.RestaurantSearchService.service.FoodItemService;
import com.tastyfood.omf.RestaurantSearchService.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;
    @Autowired
    FoodItemService foodItemService;

    @GetMapping("/restaurant-search/{input}")
    public List<Restaurant> searchRestaurant(@PathVariable String input) {
        List<Restaurant> restaurants = restaurantService.searchRestaurant(input);
        if (restaurants != null) {
            return restaurants;
        } else {
            return null;
        }

    }


    @GetMapping("/restaurant-by-location")
    public List<Restaurant> getRestaurantNearByUserLoc() {
        List<Restaurant> restaurants = restaurantService.getRestaurantNearByUserLoc();
        if (restaurants != null) {
            return restaurants;
        } else {
            return null;
        }

    }
    @GetMapping(value = "/getRests")
    public List<Restaurant> getAllRestaurants(){
        return restaurantService.getRestaurants();
    }

    @GetMapping(value = "/getRestFoods/{restid}")
    public List<FoodItem> getRestFoodItems(@PathVariable Long restid){
        return foodItemService.findFoodItemByRestaurantID(restid);
    }

    @GetMapping("/getCuisineFood/{cuisine}")
    public List<FoodItem> getFoodByCuisine(@PathVariable Cuisine cuisine){
        return foodItemService.findFoodItemByCuisine(cuisine);
    }


//    @PostMapping(value = "/place-order/{paymentMode}")
//    public Boolean processOrder(@RequestBody OrderDetail orderDetail, @PathVariable String paymentMode) {
//        System.out.println("Order details is as : "+orderDetail);
//        sendNotification(orderDetail.getOrderId());
//        return restTemplate.postForObject("http://ORDER-MANAGEMENT-SERVICE/order/place-order/"+ paymentMode,orderDetail,Boolean.class);
//    }
//
//
//    @PostMapping(value = "/update-order/{paymentMode}")
//    public Boolean updateOrder(@RequestBody OrderDetail orderDetail, @PathVariable String paymentMode) {
//        System.out.println("Updated Order details is as : "+orderDetail);
//        restTemplate.put("http://ORDER-MANAGEMENT-SERVICE/order/update-order/"+ paymentMode,orderDetail,Boolean.class);
//        return true;
//    }
//
//    @RequestMapping(value = "/cancel-order/{orderId}", method = RequestMethod.PUT)
//    public Boolean cancelOrder(@PathVariable long orderId) {
//        System.out.println("Order cancel id : "+orderId);
//        restTemplate.delete("http://ORDER-MANAGEMENT-SERVICE/order/cancel-order/"+ orderId);
//        return true;
//    }
//
//    private void sendNotification(long orderId) {
//        // fetch order details from the order mgmt service
//        // use notification service by email or push notifications
//    }
}
