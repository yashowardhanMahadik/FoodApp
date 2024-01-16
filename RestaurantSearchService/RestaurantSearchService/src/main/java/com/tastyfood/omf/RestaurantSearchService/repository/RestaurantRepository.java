package com.tastyfood.omf.RestaurantSearchService.repository;

import com.tastyfood.omf.RestaurantSearchService.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    List<Restaurant> findByNameContainsIgnoreCase(String name);

    // Case Sensitive
    List<Restaurant> findAllByNameContainsOrLocationContains(String name, String location);

    // Case In Sensitive
    List<Restaurant> findByNameContainingIgnoreCaseOrLocationContainingIgnoreCase(String name, String location);
    List<Restaurant> findByDistanceLessThanEqual(double distance);

}
