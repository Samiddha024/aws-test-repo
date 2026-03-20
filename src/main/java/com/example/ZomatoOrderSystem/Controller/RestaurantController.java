package com.example.ZomatoOrderSystem.Controller;

import com.example.ZomatoOrderSystem.DTO.MenuItemDTO;
import com.example.ZomatoOrderSystem.DTO.RestaurantDTO;
import com.example.ZomatoOrderSystem.Entity.MenuItem;
import com.example.ZomatoOrderSystem.Entity.Restaurant;
import com.example.ZomatoOrderSystem.Service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/view")
    public List<RestaurantDTO> getAll(){
        return restaurantService.viewRestaurants();
    }

    @PostMapping("/add/{id}")
    public String addRestaurant(@PathVariable Long id,@RequestBody Restaurant r){
        return restaurantService.addRestaurant(r,id);
    }

    @GetMapping("/viewMenu/{id}")
    public List<MenuItemDTO> getMenu(@PathVariable String id){
        return  restaurantService.viewItemsByRestaurant(id);
    }
}
