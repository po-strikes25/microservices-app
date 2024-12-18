package com.business.hotel_service.impl;

import com.business.hotel_service.entities.Hotel;
import com.business.hotel_service.exceptions.ResourceNotFoundException;
import com.business.hotel_service.repositories.HotelRepository;
import com.business.hotel_service.services.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService
{
    private final HotelRepository hotelRepository;

    @Override
    public Hotel createhotel(Hotel hotel)
    {
        String hotelId = UUID.randomUUID().toString();
        hotel.setHotelId(hotelId);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels()
    {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotelByID(String hotelId)
    {
        return hotelRepository
                .findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found!"));
    }

    @Override
    public Hotel updateHotel(Hotel hotel)
    {
        return null;
    }

    @Override
    public void deleteHotelByID(Long hotelId)
    {

    }

    @Override
    public void deleteAllHotels()
    {

    }
}
