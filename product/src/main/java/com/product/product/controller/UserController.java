package com.product.product.controller;

import com.product.product.entity.User;
import com.product.product.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @PostMapping
    public User register(@RequestBody User user){
       return  myUserDetailsService.createUser(user);

    }

}
