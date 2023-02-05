package com.example.userService.userService.Services.Impl;

import com.example.userService.userService.Exceptions.ResourceNotFound;
import com.example.userService.userService.Repositories.UserRepo;
import com.example.userService.userService.Services.UserService;
import com.example.userService.userService.Services.External.HotelServices;
import com.example.userService.userService.model.Hotel;
import com.example.userService.userService.model.Rating;
import com.example.userService.userService.model.User;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  private UserRepo userRepo;

  @Autowired
  private HotelServices hotelServices;
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
    User user = userRepo
      .findById(userId)
      .orElseThrow(() -> new ResourceNotFound("User with id not found"));
    Rating[] ratingOfUsers = restTemplate.getForObject(
      "http://RATING-SERVICE/ratings/users/" + user.getUserId(),
      Rating[].class
    );
    logger.info("{}", ratingOfUsers);
    List<Rating> ratings = Arrays.stream(ratingOfUsers).toList();
    List<Rating> ratingList = ratings
      .stream()
      .map(
        rating -> {
          // ResponseEntity<Hotel> forEntity = restTemplate.getForEntity(
          //   "http://HOTEL-SERVICE/hotels/" + rating.getHotelId(),
          //   Hotel.class);
          Hotel hotel = hotelServices.getHotel(rating.getHotelId());
          // logger.info("response status code: {}", forEntity.getStatusCode());
          rating.setHotel((hotel));
          return rating;
        }
      )
      .collect(Collectors.toList());
    user.setRatings(ratingList);
    return user;
  }

  @Override
  public void delUser(String userId) {
    // TODO Auto-generated method stub
    userRepo.deleteById(userId);
  }
}
