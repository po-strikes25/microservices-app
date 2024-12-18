package com.business.hotel_service.repositories;


import com.business.hotel_service.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, String>
{
}
