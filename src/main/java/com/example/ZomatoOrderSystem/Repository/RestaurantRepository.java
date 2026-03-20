package com.example.ZomatoOrderSystem.Repository;

import com.example.ZomatoOrderSystem.Entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant,String> {
}
