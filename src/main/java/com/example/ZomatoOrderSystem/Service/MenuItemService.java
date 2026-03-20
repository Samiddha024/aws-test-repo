package com.example.ZomatoOrderSystem.Service;

import com.example.ZomatoOrderSystem.Entity.MenuItem;
import com.example.ZomatoOrderSystem.Entity.Restaurant;
import com.example.ZomatoOrderSystem.Repository.MenuItemRepository;
import com.example.ZomatoOrderSystem.Repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemService {

    @Autowired
    private MenuItemRepository menuItemRepository;
    @Autowired
    private RestaurantRepository restaurantRepository;

    public String addItem(String id,MenuItem item){
        Restaurant r = restaurantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));
        List <MenuItem> menuList = r.getMenu();
        menuList.add(item);
        r.setMenu(menuList);
        item.setRestaurant(r);
        restaurantRepository.save(r);
        menuItemRepository.save(item);
        return "Menu Item Addedd successfully";
    }



}
