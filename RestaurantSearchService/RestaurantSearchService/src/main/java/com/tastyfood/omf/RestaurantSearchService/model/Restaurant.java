package com.tastyfood.omf.RestaurantSearchService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Restaurant {
    String name;
    String location;
    double distance;
    double budget;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Restaurant(String name, String location, double distance, double budget) {
        this.name = name;
        this.location = location;
        this.distance = distance;
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", distance_km=" + distance +
                ", budget=" + budget +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant that = (Restaurant) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
