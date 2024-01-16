package com.tastyfood.omf.OrderManagementService.controller;

import com.tastyfood.omf.OrderManagementService.model.*;
import com.tastyfood.omf.OrderManagementService.service.OrderServiceImpl;
import com.tastyfood.omf.OrderManagementService.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderManagementController {

    @Autowired
    OrderServiceImpl orderService;

    @Autowired
    PaymentService paymentService;

    @PostMapping(value = "/place-order/{paymentMode}")
    public boolean placeOrder(@RequestBody OrderDetail orderDetail, @PathVariable String paymentMode) {
        String[] items = orderDetail.getFoodItems().trim().split(",");
        Payment payment = orderDetail.getPayment();
        if (orderDetail.getFoodItems().trim().length() > 1 && items.length > 0) {
            boolean isPaymentSuccess = paymentService.processPayment(orderDetail, paymentMode, payment);
            if (!isPaymentSuccess)
                return false;
            orderService.addOrder(orderDetail);
            orderService.sendNotification(orderDetail.getOrderId());
            return true;
        } else
            return false;

    }

    @GetMapping(value = "/get-order-detail/{orderId}")
    public OrderDetail getOrderById(@PathVariable long orderId) {
        return orderService.getOrder(orderId);
    }

    @DeleteMapping(value = "/cancel-order/{orderId}")
    public boolean cancelOrder(@PathVariable long orderId) {
        return orderService.cancelOrder(orderId);

    }

    @PutMapping(value = "/update-order/{paymentMode}")
    public boolean updateOrder(@RequestBody OrderDetail orderDetail, @PathVariable String paymentMode){
        return orderService.updateOrder(orderDetail,paymentMode);
    }
//    @GetMapping(value = "/getRests")
//    public List<Restaurant> getAllRestaurants(){
//        return restaurantService.getRestaurants();
//    }
//
//    @GetMapping(value = "/getRestFoods/{restid}")
//    public List<FoodItem> getRestFoodItems(@PathVariable Long restid){
//        return foodItemService.findFoodItemByRestaurantID(restid);
//    }
//
//    @GetMapping("/getCuisineFood/{cuisine}")
//    public List<FoodItem> getFoodByCuisine(@PathVariable Cuisine cuisine){
//        return foodItemService.findFoodItemByCuisine(cuisine);
//    }


}
