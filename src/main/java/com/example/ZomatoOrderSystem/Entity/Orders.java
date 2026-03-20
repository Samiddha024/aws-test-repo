package com.example.ZomatoOrderSystem.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Orders {

    @Id
    private String orderId;

    @ManyToOne
    @JoinColumn(name="customerId")
    private Customer customer;

    private double price;

    @ManyToMany
    @JoinTable(
            name = "order_items",
            joinColumns = @JoinColumn(name = "orderId"),
            inverseJoinColumns = @JoinColumn(name = "menu_id")
    )
    private List<MenuItem> menuItems;


    @Column(columnDefinition = "DATETIME")
    private LocalDate date;


    @PrePersist
    public void generateOrderId(){
        if(orderId==null) orderId="ORD"+System.currentTimeMillis();
    }
}
