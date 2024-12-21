package com.business.rating_service.services.impl;

import com.business.rating_service.entities.Rating;
import com.business.rating_service.repositories.RatingRepository;
import com.business.rating_service.services.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService
{
    private final RatingRepository ratingRepository;

    @Override
    public Rating createRating(Rating rating)
    {
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAllRatings()
    {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getRatingsByUserID(String userId)
    {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingsByHotelID(String hotelId)
    {
        return ratingRepository.findByHotelId(hotelId);
    }
}
