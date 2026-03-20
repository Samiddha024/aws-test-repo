package com.example.ZomatoOrderSystem.Service;
import com.example.ZomatoOrderSystem.DTO.FetchOrderDTO;
import com.example.ZomatoOrderSystem.DTO.OrderDTO;
import com.example.ZomatoOrderSystem.DTO.UserDTO;
import com.example.ZomatoOrderSystem.Entity.Customer;
import com.example.ZomatoOrderSystem.Entity.MenuItem;
import com.example.ZomatoOrderSystem.Entity.Orders;
import com.example.ZomatoOrderSystem.Repository.CustomerRepository;
import com.example.ZomatoOrderSystem.Repository.MenuItemRepository;
import com.example.ZomatoOrderSystem.Repository.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    @Autowired
    CustomerRepository customerRepo;

    @Autowired
    MenuItemRepository menuItemRepo;

    @Autowired
    OrderRepository orderRepo;

    @Autowired
    ModelMapper modelMapper;

    public List<FetchOrderDTO> viewOrderList(Long id) {
        Customer customer = customerRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        List<FetchOrderDTO>list=customer.getOrdersList().stream().map((o)->{
            return modelMapper.map(o,FetchOrderDTO.class);
        }).toList();
        return list;
    }

    public String placeOrder(Long customerId, OrderDTO request){

        Customer customer = customerRepo.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));


        Map<Long,Integer> orderItems = request.getMenuItem();

        // Fetch all menu items
        List<MenuItem> items = menuItemRepo.findAllById(orderItems.keySet());

        double totalPrice = 0;

        for(MenuItem item : items){


            int quantity = orderItems.get(item.getMenu_id());
            if(item.getStock()<quantity)throw new RuntimeException("Insufficient Stock");
            totalPrice += item.getPrice() * quantity;
            item.setStock(item.getStock()-quantity);
            menuItemRepo.save(item);
        }

        Orders order = new Orders();
        order.setCustomer(customer);
        order.setMenuItems(items);
        order.setPrice(totalPrice);
        order.setDate(LocalDate.now());
        List<Orders>list=customer.getOrdersList();
        list.add(order);
        customerRepo.save(customer);
        orderRepo.save(order);

        return "Order placed successfully";
    }
}