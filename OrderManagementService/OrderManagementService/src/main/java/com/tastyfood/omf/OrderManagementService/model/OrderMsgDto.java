package com.tastyfood.omf.OrderManagementService.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderMsgDto {
    double amount;
    String msg;
}
