package com.example.ZomatoOrderSystem.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menu_id;
    private Double price;
    private String dishName;

    @ManyToOne
    @JoinColumn(name="RestaurantId")
    private Restaurant restaurant;

    private int stock;



}
