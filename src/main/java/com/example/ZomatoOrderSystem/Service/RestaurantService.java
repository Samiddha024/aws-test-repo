package com.example.ZomatoOrderSystem.Service;

import com.example.ZomatoOrderSystem.DTO.MenuItemDTO;
import com.example.ZomatoOrderSystem.DTO.OrderDTO;
import com.example.ZomatoOrderSystem.DTO.RestaurantDTO;
import com.example.ZomatoOrderSystem.Entity.MenuItem;
import com.example.ZomatoOrderSystem.Entity.Restaurant;
import com.example.ZomatoOrderSystem.Entity.Role;
import com.example.ZomatoOrderSystem.Entity.User;
import com.example.ZomatoOrderSystem.Repository.RestaurantRepository;
import com.example.ZomatoOrderSystem.Repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;
    public String addRestaurant(Restaurant r, Long userId){

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if(user.getRole() != Role.RESTAURANT_OWNER){
            throw new RuntimeException("Only Restaurant Owners can add restaurants");
        }

        restaurantRepository.save(r);

        return "Restaurant Added";
    }

    public List<RestaurantDTO> viewRestaurants(){
        return restaurantRepository.findAll().stream().map((a)->
        {
            return modelMapper.map(a, RestaurantDTO.class);
        }).toList()
                ;
    }

    public List<MenuItemDTO> viewItemsByRestaurant(String id){
        Restaurant r= restaurantRepository.findById(id).orElseThrow();
        List<MenuItem>list1=r.getMenu();
        List<MenuItemDTO>list=new ArrayList<>();
        for(MenuItem m:list1){
            list.add(modelMapper.map(m,MenuItemDTO.class));
        }
        return list;
    }


}
