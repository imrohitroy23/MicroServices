package com.example.Rating.RatingSer.Services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Rating.RatingSer.Repositories.RatingRepo;
import com.example.Rating.RatingSer.Services.RatingService;
import com.example.Rating.RatingSer.model.Rating;


@Service
public class RatingServiceImpl implements RatingService {
  @Autowired
  private RatingRepo ratingRepo;

  @Override
  public Rating CreateRating(Rating rating) {
   
    return ratingRepo.save(rating);
  }

  @Override
  public List<Rating> getAll() {
    // TODO Auto-generated method stub
    return ratingRepo.findAll();
  }

  @Override
  public List<Rating> getRatingByUserId(String userId) {
    // TODO Auto-generated method stub
    return ratingRepo.findByUserId(userId);
  }

  @Override
  public List<Rating> getRatingByHotelId(String hotelId) {
    // TODO Auto-generated method stub
    return ratingRepo.findByHotelId(hotelId);
  }

  @Override
  public Rating updateRating(Rating rating) {
    // TODO Auto-generated method stub
    return ratingRepo.save(rating);
  }

  // @Override
  // public Hotel saveUser(Hotel user) {
  //     String randomUserId=UUID.randomUUID().toString();
  //     user.setUserId(randomUserId);
  //     // TODO Auto-generated method stub
  //     return userRepo.save(user);
  // }

  // @Override
  // public List<Hotel> getAll() {
  //     // TODO Auto-generated method stub
  //     return userRepo.findAll();
  // }

  // @Override
  // public Hotel getUser(String userId) {
  //     // TODO Auto-generated method stub
  //     return userRepo.findById(userId).orElseThrow(()->new ResourceNotFound("User with id not found"));
  // }

  // @Override
  // public void delUser(String userId) {
  //     // TODO Auto-generated method stub
  //     userRepo.deleteById(userId);

  // }

  }

