package com.example.ZomatoOrderSystem.Repository;

import com.example.ZomatoOrderSystem.Entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemRepository extends JpaRepository<MenuItem,Long> {
}
