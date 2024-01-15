package com.tastyfood.omf.RestaurantSearchService.controller;

import com.tastyfood.omf.RestaurantSearchService.model.OrderDetail;
import com.tastyfood.omf.RestaurantSearchService.model.Restaurant;
import com.tastyfood.omf.RestaurantSearchService.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @Autowired
    RestTemplate restTemplate;

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

    @PostMapping(value = "/place-order/{paymentMode}")
    public Boolean processOrder(@RequestBody OrderDetail orderDetail, @PathVariable String paymentMode) {
        System.out.println("Order details is as : "+orderDetail);
        sendNotification(orderDetail.getOrderId());
        return restTemplate.postForObject("http://ORDER-MANAGEMENT-SERVICE/order/place-order/"+ paymentMode,orderDetail,Boolean.class);
    }


    @PostMapping(value = "/update-order/{paymentMode}")
    public Boolean updateOrder(@RequestBody OrderDetail orderDetail, @PathVariable String paymentMode) {
        System.out.println("Updated Order details is as : "+orderDetail);
        restTemplate.put("http://ORDER-MANAGEMENT-SERVICE/order/update-order/"+ paymentMode,orderDetail,Boolean.class);
        return true;
    }

    @RequestMapping(value = "/cancel-order/{orderId}", method = RequestMethod.PUT)
    public Boolean cancelOrder(@PathVariable long orderId) {
        System.out.println("Order cancel id : "+orderId);
        restTemplate.delete("http://ORDER-MANAGEMENT-SERVICE/order/cancel-order/"+ orderId);
        return true;
    }

    private void sendNotification(long orderId) {
        // fetch order details from the order mgmt service
        // use notification service by email or push notifications
    }
}
