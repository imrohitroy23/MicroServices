package com.example.userHotel.userHotel.Services.Impl;

import com.example.userHotel.userHotel.Exceptions.ResourceNotFound;
import com.example.userHotel.userHotel.Repositories.HotelRepository;
import com.example.userHotel.userHotel.Services.HotelService;
import com.example.userHotel.userHotel.model.Hotel;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelServiceImpl implements HotelService {
  @Autowired
  private HotelRepository hotelRepo;

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

  @Override
  public Hotel getHotle(String Id) {
    // TODO Auto-generated method stub
    return hotelRepo
      .findById(Id)
      .orElseThrow(() -> new ResourceNotFound("Doesn't exist"));
  }

  @Override
  public void delHotel(String Id) {
    hotelRepo.deleteById(Id);
  }

  @Override
  public Hotel savehotel(Hotel hotel) {
    // TODO Auto-generated method stub
    String hotelId=UUID.randomUUID().toString();
    hotel.setId(hotelId);
    return hotelRepo.save(hotel);
  }

  @Override
  public List<Hotel> getAll() {
    // TODO Auto-generated method stub
    return hotelRepo.findAll();
  }
}
