package com.example.ZomatoOrderSystem.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor

@Getter
@Setter
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String RestaurantId;

    private String RestaurantName;
    @Column(length = 100)
     private String address;

    @OneToMany(mappedBy = "restaurant")
    private List<MenuItem> menu;
}
