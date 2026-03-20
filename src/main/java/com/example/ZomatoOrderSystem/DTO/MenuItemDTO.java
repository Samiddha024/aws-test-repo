package com.example.ZomatoOrderSystem.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MenuItemDTO {

    private String dishName;
    private Double price;
    private int stock;
}
