package com.tastyfood.omf.RestaurantSearchService.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Itenerary {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "food_name")
    String foodName;

    double price;

    @OneToOne()
    @JoinColumn(name = "cuisine_id",referencedColumnName = "id")
    Cuisine cuisine;

    @ManyToOne
    @JoinColumn(name = "restaurant_id",referencedColumnName = "id")
    Restaurant restaurant;

    int stock=50;

    public Itenerary(String foodName, double price, Cuisine cuisine, Restaurant restaurant, int stock) {
        this.foodName = foodName;
        this.price = price;
        this.cuisine = cuisine;
        this.restaurant = restaurant;
        this.stock = stock;
    }
    @Override
    public String toString() {
        return "IteneraryService{" +
                "foodId=" + id +
                ", foodName='" + foodName + '\'' +
                ", price=" + price +
                ", cuisine=" + cuisine +
                ", restaurant=" + restaurant.toString() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Itenerary itenerary = (Itenerary) o;
        return id == itenerary.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
