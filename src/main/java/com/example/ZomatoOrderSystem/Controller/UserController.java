package com.example.ZomatoOrderSystem.Controller;

import com.example.ZomatoOrderSystem.DTO.OrderDTO;
import com.example.ZomatoOrderSystem.DTO.RegisterRequest;
import com.example.ZomatoOrderSystem.DTO.UserDTO;
import com.example.ZomatoOrderSystem.Entity.User;
import com.example.ZomatoOrderSystem.Service.AuthService;

import com.example.ZomatoOrderSystem.Service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private AuthService authService;

    @Autowired
    private RestaurantService restaurantService;

    @PostMapping("/login")
    public String login(@RequestBody User u){
        return authService.loginUser(u);
    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest r){
        return authService.registerUser(r);
    }




}
