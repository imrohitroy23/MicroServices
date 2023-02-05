package com.example.userService.userService.Services.External;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.userService.userService.model.Hotel;

@FeignClient(name="HOTEL-SERVICE")
public interface HotelServices 
{
    @GetMapping("/hotels/{hotelId}")
    public Hotel getHotel(@PathVariable String hotelId);
}
