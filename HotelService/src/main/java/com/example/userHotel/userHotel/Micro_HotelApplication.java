package com.example.userHotel.userHotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Micro_HotelApplication {

	public static void main(String[] args) {
		SpringApplication.run(Micro_HotelApplication.class, args);
	}

}
