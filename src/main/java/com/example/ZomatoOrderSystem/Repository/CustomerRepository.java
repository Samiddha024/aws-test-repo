package com.example.ZomatoOrderSystem.Repository;

import com.example.ZomatoOrderSystem.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
