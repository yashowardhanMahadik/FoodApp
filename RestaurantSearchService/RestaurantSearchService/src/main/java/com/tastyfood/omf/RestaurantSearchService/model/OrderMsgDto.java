package com.tastyfood.omf.RestaurantSearchService.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderMsgDto {
    double amount;
    String msg;
}
