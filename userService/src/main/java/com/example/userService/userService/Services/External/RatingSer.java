package com.example.userService.userService.Services.External;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.userService.userService.model.Rating;

@FeignClient(name="RATING-SERVICE")
public interface RatingSer {
    

    @PostMapping("/ratings/")
    public Rating createRating(Rating rating);


}
