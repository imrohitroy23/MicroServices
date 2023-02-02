package com.example.Rating.RatingSer.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Rating.RatingSer.Services.RatingService;
import com.example.Rating.RatingSer.model.Rating;

@RestController
@RequestMapping("/ratings/")
public class RatingController {
  @Autowired
  private RatingService ratingService;

  @PostMapping
  public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
    
    return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.CreateRating(rating));
  }

  @GetMapping("/users/{userId}")
  public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId) {

    return ResponseEntity.ok(ratingService.getRatingByUserId(userId));
  }
  @GetMapping("/hotels/{hotelId}")
  public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId) {

    return ResponseEntity.ok(ratingService.getRatingByHotelId(hotelId));
  }

  // @DeleteMapping("/{hotelid}")
  // public void deleteUser(@PathVariable String hotelid) {
  //   this.hotelService.delHotel(hotelid);
  // }

  @GetMapping
  public ResponseEntity<List<Rating>> getAllRating() {
   
    return ResponseEntity.ok(ratingService.getAll());
  }
}
