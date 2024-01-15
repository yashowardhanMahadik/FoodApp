package com.tastyfood.omf.OrderManagementService.model;

import lombok.*;

import jakarta.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long paymentID;

    @Column(name = "payment_mode")
    String paymentMode;

    double amountPaid;
    long date;
    boolean payStatus;


}
