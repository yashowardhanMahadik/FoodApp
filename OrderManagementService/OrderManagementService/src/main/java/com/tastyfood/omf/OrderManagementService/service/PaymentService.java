package com.tastyfood.omf.OrderManagementService.service;

import com.tastyfood.omf.OrderManagementService.model.OrderDetail;
import com.tastyfood.omf.OrderManagementService.model.Payment;

public interface PaymentService {boolean processPayment(OrderDetail orderDetail, String paymentMode, Payment payment);

}
