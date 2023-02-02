package com.example.Rating.RatingSer.Services;

import java.util.List;

import com.example.Rating.RatingSer.model.Rating;

public interface RatingService {
  public Rating CreateRating(Rating rating);
  public List<Rating> getAll();
  public List<Rating> getRatingByUserId(String userId);
  public List<Rating> getRatingByHotelId(String hotelId);
  

}
