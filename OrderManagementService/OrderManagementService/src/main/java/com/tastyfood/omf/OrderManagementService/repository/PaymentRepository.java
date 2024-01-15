package com.tastyfood.omf.OrderManagementService.repository;

import com.tastyfood.omf.OrderManagementService.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Long> {

}
