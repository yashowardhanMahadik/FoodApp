package com.tastyfood.omf.OrderManagementService.controller;

import com.tastyfood.omf.OrderManagementService.model.OrderDetail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.tastyfood.omf.OrderManagementService.controller.OrderManagementController.getDemoOrderDetail;

@SpringBootTest
class OrderManagementControllerTest {

    @Autowired
    OrderManagementController orderManagementController;

    static OrderDetail orderDetail = getDemoOrderDetail();
//    @BeforeAll
//    static void setup(){
//        orderDetail = getDemoOrderDetail();
//    }

    @Test
    void placeOrder() {
        orderManagementController.placeOrder(orderDetail,"upi");
        System.out.println("Test1");
    }

    @Test
    void getOrderById() {
        orderManagementController.getOrderById(1);
    }

    @Test
    void cancelOrder() {
        System.out.println("Test cancel order");
        orderManagementController.cancelOrder(1);
    }


}