package com.example.ZomatoOrderSystem.Controller;

import com.example.ZomatoOrderSystem.Entity.MenuItem;
import com.example.ZomatoOrderSystem.Service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/menu")
public class MenuItemController {


    @Autowired
    private MenuItemService menuItemService;


    @PostMapping("/add/{id}")
    public String addItem(@PathVariable String id, @RequestBody MenuItem m){
        return menuItemService.addItem(id,m);
    }
}
