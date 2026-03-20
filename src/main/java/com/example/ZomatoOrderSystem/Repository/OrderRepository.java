package com.example.ZomatoOrderSystem.Repository;

import com.example.ZomatoOrderSystem.Entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders,Long> {
}
