package com.example.userService.userService.Services.Impl;

import com.example.userService.userService.Exceptions.ResourceNotFound;
import com.example.userService.userService.Repositories.UserRepo;
import com.example.userService.userService.Services.UserService;
import com.example.userService.userService.model.Rating;
import com.example.userService.userService.model.User;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  private UserRepo userRepo;

  @Autowired
  private RestTemplate restTemplate;

  private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

  @Override
  public User saveUser(User user) {
    String randomUserId = UUID.randomUUID().toString();
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
    User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFound("User with id not found"));
    ArrayList<Rating> ratingOfUsers = restTemplate.getForObject("http://localhost:8083/ratings/users/"+user.getUserId() ,ArrayList.class);
    logger.info("{}", ratingOfUsers);
    user.setRatings(ratingOfUsers);
    return user;
  }

  @Override
  public void delUser(String userId) {
    // TODO Auto-generated method stub
    userRepo.deleteById(userId);
  }
}
