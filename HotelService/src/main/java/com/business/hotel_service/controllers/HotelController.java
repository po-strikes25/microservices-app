package com.business.hotel_service.controllers;

import com.business.hotel_service.entities.Hotel;
import com.business.hotel_service.exceptions.ResourceNotFoundException;
import com.business.hotel_service.services.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotel")
@CrossOrigin("*")
@RequiredArgsConstructor
public class HotelController
{
    private final HotelService hotelService;

    @PostMapping("/post")
    public ResponseEntity<Hotel> postExpense(@RequestBody Hotel hotel)
    {
        Hotel    newHotel    =   hotelService.createhotel(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(newHotel);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getHotelByID(@PathVariable String id)
    {
        try
        {
            return ResponseEntity.ok(hotelService.getHotelByID(id));
        }
        catch(ResourceNotFoundException exception)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
        catch(Exception exception)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllIncomes()
    {
        return ResponseEntity.ok(hotelService.getAllHotels());
    }

}
