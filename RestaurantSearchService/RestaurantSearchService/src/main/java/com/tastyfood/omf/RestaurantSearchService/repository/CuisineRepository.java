package com.tastyfood.omf.RestaurantSearchService.repository;

import com.tastyfood.omf.RestaurantSearchService.model.Cuisine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CuisineRepository extends JpaRepository<Cuisine, Long> {

    List<Cuisine> findDistinctByNameContainingIgnoreCase(String name);

    List<Cuisine> findByNameContainingIgnoreCase(String name);

    List<Cuisine> findDistinctByName(String name);
}
