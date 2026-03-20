package com.example.ZomatoOrderSystem.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FetchOrderDTO {

    private String orderId;
    private List<MenuItemDTO> menuItemDTO;
    private Double price;
}
