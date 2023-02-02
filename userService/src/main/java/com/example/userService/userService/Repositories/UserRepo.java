package com.example.userService.userService.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.userService.userService.model.User;

@Repository
public interface UserRepo extends JpaRepository<User,String>
{
    
}
