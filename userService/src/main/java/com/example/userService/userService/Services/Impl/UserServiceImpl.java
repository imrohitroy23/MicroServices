package com.example.userService.userService.Services.Impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.userService.userService.Exceptions.ResourceNotFound;
import com.example.userService.userService.Repositories.UserRepo;
import com.example.userService.userService.Services.UserService;
import com.example.userService.userService.model.User;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepo userRepo;


    @Override
    public User saveUser(User user) {
        String randomUserId=UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        // TODO Auto-generated method stub
        return userRepo.save(user);
    }

    @Override
    public List<User> getAll() {
        // TODO Auto-generated method stub
        return userRepo.findAll();
    }

    @Override
    public User getUser(String userId) {
        // TODO Auto-generated method stub
        return userRepo.findById(userId).orElseThrow(()->new ResourceNotFound("User with id not found"));
    }

    @Override
    public void delUser(String userId) {
        // TODO Auto-generated method stub
        userRepo.deleteById(userId);
        
    }
    
}
