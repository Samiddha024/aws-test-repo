package com.example.ZomatoOrderSystem.Controller;

import com.example.ZomatoOrderSystem.DTO.FetchOrderDTO;
import com.example.ZomatoOrderSystem.DTO.OrderDTO;
import com.example.ZomatoOrderSystem.DTO.UserDTO;
import com.example.ZomatoOrderSystem.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {


    @Autowired
    private OrderService orderService;
    @PostMapping("/{id}")
    public String placeOrder(@PathVariable Long id, @RequestBody OrderDTO orderDTO){
       return orderService.placeOrder(id,orderDTO);

    }

    @GetMapping("/viewOrders/{id}")
    public List<FetchOrderDTO> viewOrderList(@PathVariable Long id){
        return orderService.viewOrderList(id);
    }

}
