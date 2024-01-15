package com.tastyfood.omf.OrderManagementService.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long orderId;

    long restId;

    long userId;

    double amountToBePaid;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paymentID",
            referencedColumnName = "paymentID")
    Payment payment;

    String foodItems;
}
