package com.tastyfood.omf.OrderManagementService.model;

import lombok.*;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class FoodItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long foodId;

    @Column(name = "food_name")
    String foodName;

    double price;
    int supply =50;

    Cuisine cuisine;

    @ManyToOne
    @JoinColumn(name = "restaurant_id",
            referencedColumnName = "id")
    Restaurant restaurant;

    @Override
    public String toString() {
        return "FoodItem{" +
                "foodId=" + foodId +
                ", foodName='" + foodName + '\'' +
                ", price=" + price +
                ", cuisine=" + cuisine +
                ", remaining supply=" + supply +
                ", restaurant=" + restaurant.toString() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodItem foodItem = (FoodItem) o;
        return foodId == foodItem.foodId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(foodId);
    }
}
