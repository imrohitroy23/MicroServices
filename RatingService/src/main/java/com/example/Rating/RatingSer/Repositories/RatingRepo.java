package com.example.Rating.RatingSer.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Rating.RatingSer.model.Rating;



@Repository
public interface RatingRepo extends JpaRepository<Rating,String>
{
    List<Rating> findByUserId(String userId);
    List<Rating> findByHotelId(String hotelId);
}
