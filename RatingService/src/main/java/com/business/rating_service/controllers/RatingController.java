package com.business.rating_service.controllers;

import com.business.rating_service.entities.Rating;
import com.business.rating_service.exceptions.ResourceNotFoundException;
import com.business.rating_service.services.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rating")
@CrossOrigin("*")
@RequiredArgsConstructor
public class RatingController
{
    private final RatingService ratingService;

    @PostMapping("/post")
    public ResponseEntity<Rating> postExpense(@RequestBody Rating rating)
    {
        Rating    newRating    =   ratingService.createRating(rating);

        return ResponseEntity.status(HttpStatus.CREATED).body(newRating);
    }

    @GetMapping("/get/user/{id}")
    public ResponseEntity<?> getRatingsByUserID(@PathVariable String id)
    {
        try
        {
            return ResponseEntity.ok(ratingService.getRatingsByUserID(id));
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

    @GetMapping("/get/hotel/{id}")
    public ResponseEntity<?> getRatingsByHotelID(@PathVariable String id)
    {
        try
        {
            return ResponseEntity.ok(ratingService.getRatingsByHotelID(id));
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
        return ResponseEntity.ok(ratingService.getAllRatings());
    }

}
