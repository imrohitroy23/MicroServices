package com.example.userHotel.userHotel.Services;

import java.util.List;

import com.example.userHotel.userHotel.model.Hotel;

public interface HotelService {
  public Hotel savehotel(Hotel hotel);
  public List<Hotel> getAll();
  public Hotel getHotle(String Id);
  public void delHotel(String Id);

}
