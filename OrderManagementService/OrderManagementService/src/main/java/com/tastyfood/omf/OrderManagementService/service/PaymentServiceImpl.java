package com.tastyfood.omf.OrderManagementService.service;

import com.tastyfood.omf.OrderManagementService.model.OrderDetail;
import com.tastyfood.omf.OrderManagementService.model.Payment;
import com.tastyfood.omf.OrderManagementService.model.PaymentMode;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService{
    @Override
    public boolean processPayment(OrderDetail orderDetail, String paymentMode, Payment payment) {
        if(paymentMode == null){
            return false;
        }
        PaymentMode paidMethod = PaymentMode.valueOf(paymentMode.toUpperCase());
        switch (paidMethod){
            case CARD:{
                // confirm from the bank APIs
                break;
            }
            case CASH:{
                // Confirm from the delivery partner
                break;
            }
            case UPI:{
                //confirm from the UPI vendor
                break;
            }
            default:{
                return true;
            }
        }
        payment.setPayStatus(true);
        orderDetail.setPayment(payment);
        return true;
    }
}
