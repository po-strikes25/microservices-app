package com.business.hotel_service.services;


import com.business.hotel_service.entities.Hotel;

import java.util.List;

public interface HotelService
{
    Hotel createhotel(Hotel hotel);
    List<Hotel> getAllHotels();
    Hotel getHotelByID(String hotelId);
    Hotel updateHotel(Hotel hotel);
    void deleteHotelByID(Long hotelId);
    void deleteAllHotels();
}
