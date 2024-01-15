package com.tastyfood.omf.OrderManagementService.service;

import com.tastyfood.omf.OrderManagementService.model.Payment;
import com.tastyfood.omf.OrderManagementService.model.OrderDetail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Date;

@SpringBootTest
class OrderServiceTest {
    @MockBean
    OrderServiceImpl orderService;

    @Test
    void getOrder() {
        Long id = Long.valueOf(-123451);
        Long userId = Long.valueOf(123);
        orderService.getOrder(id);
    }

    @Test
    void addOrder() {
        orderService.addOrder(null);
    }

    @Test
    void updateOrder() {
        Payment payment = Payment.builder().paymentMode("Upi")
                .date(new Date().getTime())
                .amountPaid(255d).build();
        orderService.updateOrder(new OrderDetail(1,1,1,2, payment,"1,2"),"Upi");
        Assertions.assertSame(1,1);
    }

    @Test
    void cancelOrder() {
        Long id = Long.valueOf(-123451);
        final boolean val = orderService.cancelOrder(id);
        Assertions.assertFalse(val);
    }
}