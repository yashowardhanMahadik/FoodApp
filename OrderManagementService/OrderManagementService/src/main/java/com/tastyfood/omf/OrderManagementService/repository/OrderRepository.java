package com.tastyfood.omf.OrderManagementService.repository;

import com.tastyfood.omf.OrderManagementService.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderDetail, Long> {

    OrderDetail findByOrderIdAndUserId(Long orderId,Long userID);
    OrderDetail findByOrderId(Long orderId);
}
