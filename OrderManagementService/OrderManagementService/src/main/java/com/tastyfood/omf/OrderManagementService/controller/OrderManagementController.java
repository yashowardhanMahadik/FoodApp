package com.tastyfood.omf.OrderManagementService.controller;

import com.tastyfood.omf.OrderManagementService.model.Payment;
import com.tastyfood.omf.OrderManagementService.model.OrderDetail;
import com.tastyfood.omf.OrderManagementService.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Random;

@RestController
@RequestMapping("/order")
public class OrderManagementController {

    @Autowired
    OrderServiceImpl orderService;



    @PostMapping(value = "/place-order/{paymentMode}")
    public boolean placeOrder(@RequestBody OrderDetail orderDetail, @PathVariable String paymentMode) {
        String[] items = orderDetail.getFoodItems().trim().split(",");
        if (orderDetail.getFoodItems().trim().length() > 1 && items.length > 0) {
            boolean isPaymentSuccess = processPayment(orderDetail, paymentMode);
            if (!isPaymentSuccess)
                return false;
            orderService.addOrder(orderDetail);
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


    private boolean processPayment(OrderDetail orderDetail, String paymentMode) {
        String[] paymentModes = {"Cash", "Upi", "Credit Card", "Debit Card"};
        Random random = new Random();
        int num = random.nextInt(10);
        if (num < 9 || paymentMode.equals(paymentModes[0])) {
            Payment payment = Payment.builder().paymentMode(paymentMode)
                    .amountPaid(orderDetail.getAmountToBePaid())
                    .date(new Date().getTime()).build();
            orderDetail.setPayment(payment);
            return true;
        }

        return false;
    }

    public static OrderDetail getDemoOrderDetail(){

        Payment payment = Payment.builder().paymentMode("upi")
                .date(new Date().getTime())
                .amountPaid(255).build();


        OrderDetail orderDetail= OrderDetail.builder()
                .amountToBePaid(255)
                .payment(payment)
                .foodItems("1,2")
                .restId(1)
                .userId(2).build();

        return orderDetail;
    }
}
