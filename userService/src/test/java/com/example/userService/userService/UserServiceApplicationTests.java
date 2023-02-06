package com.example.userService.userService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.userService.userService.Services.External.RatingSer;
import com.example.userService.userService.model.Rating;

@SpringBootTest
class UserServiceApplicationTests {

	@Autowired
	private RatingSer ratingSer;


	@Test
	void contextLoads() {
	}
	@Test
	void saveRating(){
		Rating ratingg=Rating.builder().ratingId("").rating(12211).userId("").hotelId("").feedback("hello").build();
		Rating saveRating=ratingSer.createRating(ratingg);
		System.out.println("new rating added");
	}

}
