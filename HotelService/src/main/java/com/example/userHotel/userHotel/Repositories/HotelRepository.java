package com.example.userHotel.userHotel.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.userHotel.userHotel.model.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,String>
{
    
}
