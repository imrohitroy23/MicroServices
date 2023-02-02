package com.example.userHotel.userHotel.Controller;

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

import com.example.userHotel.userHotel.Services.HotelService;
import com.example.userHotel.userHotel.model.Hotel;

@RestController
@RequestMapping("/hotels/")
public class HotelController {
  @Autowired
  private HotelService hotelService;

  @PostMapping
  public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
    Hotel hotel1 = hotelService.savehotel(hotel);
    return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);
  }

  @GetMapping("/{hotelid}")
  public ResponseEntity<Hotel> getSingle(@PathVariable String hotelid) {
    Hotel hotel = hotelService.getHotle(hotelid);
    return ResponseEntity.ok(hotel);
  }

  @DeleteMapping("/{hotelid}")
  public void deleteUser(@PathVariable String hotelid) {
    this.hotelService.delHotel(hotelid);
  }

  @GetMapping
  public ResponseEntity<List<Hotel>> getAllhotels() {
    List<Hotel> allhotel = hotelService.getAll();
    return ResponseEntity.ok(allhotel);
  }
}
