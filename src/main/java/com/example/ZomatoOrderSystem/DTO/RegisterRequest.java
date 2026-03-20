package com.example.ZomatoOrderSystem.DTO;

import com.example.ZomatoOrderSystem.Entity.Role;
import com.example.ZomatoOrderSystem.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String email;
    private Role role;
    private String password;
    private String name;

    private String phoneNo;
    private String address;

}
