package com.tastyfood.omf.RestaurantSearchService.controller;

import com.tastyfood.omf.RestaurantSearchService.model.OrderDetail;
import com.tastyfood.omf.RestaurantSearchService.model.Payment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RestaurantControllerTest {

    @Autowired
    RestaurantController restaurantController;

    static OrderDetail getOrderDetails() {
        Payment payment = Payment.builder().paymentMode("Upi")
                .date(new Date().getTime())
                .amountPaid(255d).build();


        OrderDetail orderDetail = OrderDetail.builder()
                .amountToBePaid(255)
                .payment(payment)
                .foodItems("10,22,12")
                .restId(18L)
                .userId(2).build();
        return orderDetail;
    }
    static OrderDetail orderDetail = getOrderDetails();

    @Test
    void getRestaurantNearByUserLoc() {
        restaurantController.getRestaurantNearByUserLoc();
    }

//    @Test
    void processOrder() {
        restaurantController.processOrder(orderDetail,"upi");
    }

//    @Test
    void updateOrder() {
        restaurantController.updateOrder(orderDetail,"Upi");
    }

    @Test
    void cancelOrder() {
        restaurantController.cancelOrder(1);
    }

    @Test
    void searchRestaurantTest(){ restaurantController.searchRestaurant("KFC");}
}