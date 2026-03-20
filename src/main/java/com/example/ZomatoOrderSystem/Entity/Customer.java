package com.example.ZomatoOrderSystem.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    private String email;
    private String phoneNo;
    private String address;

    @OneToOne(mappedBy = "customer")
    private User user;

    @OneToMany(mappedBy = "customer")
    List<Orders> ordersList;


}