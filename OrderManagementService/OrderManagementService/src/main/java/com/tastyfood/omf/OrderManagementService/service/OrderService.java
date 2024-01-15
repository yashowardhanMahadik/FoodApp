package com.tastyfood.omf.OrderManagementService.service;

import com.tastyfood.omf.OrderManagementService.model.OrderDetail;

public interface OrderService {
//    OrderDetail getOrder(Long orderId, Long userId);
    OrderDetail getOrder(Long orderId);
     void addOrder(OrderDetail orderDetail);
     Boolean updateOrder(OrderDetail orderDetail, String paymentMode);
    boolean cancelOrder(Long orderId);
}
