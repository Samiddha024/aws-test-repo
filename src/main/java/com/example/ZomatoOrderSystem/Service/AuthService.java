package com.example.ZomatoOrderSystem.Service;

import com.example.ZomatoOrderSystem.DTO.RegisterRequest;
import com.example.ZomatoOrderSystem.Entity.Customer;
import com.example.ZomatoOrderSystem.Entity.Role;
import com.example.ZomatoOrderSystem.Entity.User;
import com.example.ZomatoOrderSystem.Repository.CustomerRepository;
import com.example.ZomatoOrderSystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private CustomerRepository customerRepo;




    public String registerUser(RegisterRequest req){

        if(userRepo.findByEmail(req.getEmail()).isPresent()){
            return "Email already exists";
        }

        User user = new User();
        user.setName(req.getName());
        user.setEmail(req.getEmail());
        user.setPassword(req.getPassword());
        user.setRole(req.getRole());


        if(req.getRole() == Role.CUSTOMER){

            Customer customer = new Customer();
            customer.setEmail(req.getEmail());
            customer.setAddress(req.getAddress());
            customer.setPhoneNo(req.getPhoneNo());
            customerRepo.save(customer);

            user.setCustomer(customer);
        }

        userRepo.save(user);

        return "User registered successfully";
    }



    public String loginUser(User req){

        User user = userRepo.findByEmail(req.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if(!req.getPassword().matches(user.getPassword())){
            throw new RuntimeException("Invalid password");
        }

        return "Login Successful";
    }

}