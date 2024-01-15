package com.tastyfood.omf.RestaurantSearchService.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
@Builder
public class OrderMemo {

    private HashMap<String,Double> orderList;

    private String total;

}
