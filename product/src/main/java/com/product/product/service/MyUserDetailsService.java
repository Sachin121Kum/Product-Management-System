package com.product.product.service;

import com.product.product.entity.User;
import com.product.product.respository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MyUserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user){
        userRepository.save(user);
    }



}
