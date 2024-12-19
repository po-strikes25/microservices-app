package com.business.rating_service.repositories;

import com.business.rating_service.entities.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepository extends MongoRepository<Rating, String>
{
    /* custom methods */
    List<Rating> findByUserId(String userId);
    List<Rating> findByHotelId(String hotelId);
}
