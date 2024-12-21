package com.business.user_service.services.impl;

import com.business.user_service.entities.Hotel;
import com.business.user_service.entities.Rating;
import com.business.user_service.entities.User;
import com.business.user_service.exceptions.ResourceNotFoundException;
import com.business.user_service.repositories.UserRepository;
import com.business.user_service.services.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService
{
    // he @Autowired the userRepository
    private final   UserRepository  userRepository;
    private final   RestTemplate    restTemplate;
    private         Logger          logger          = LoggerFactory.getLogger(UserServiceImpl.class);

    // saveOrUpdate() is an efficient function!
    @Override
    public User createUser(User user)
    {
        String userId =UUID.randomUUID().toString();
        user.setUserId(userId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers()
    {
        return userRepository.findAll();
    }

    @Override
    public User getUserByID(String userId)
    {
        /* fetch user from DB */
        User user   =   userRepository
                        .findById(userId)
                        .orElseThrow(() -> new ResourceNotFoundException("User not found !!!"));

        /*  fetch rating from RATING-SERVICE
            http://localhost:8083/rating/get/user/84b40015-0bc8-452f-80c4-a6af4c017dc1  */
        Rating[]   userRatings = restTemplate.getForObject("http://localhost:8083/rating/get/user/" + user.getUserId(), Rating[].class);
        logger.info("getUserByID() --> Data fetched from RATING SERVICE: {} ", userRatings);

        List<Rating> hotelRatings = Arrays.stream(userRatings).map((rating) ->
        {
            ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://localhost:8082/hotel/get/" + rating.getHotelId(), Hotel.class);
            Hotel hotel = forEntity.getBody();
            logger.info("response status code : {}", forEntity.getStatusCode());
            logger.info("getUserByID() --> Data fetched from HOTEL SERVICE: {} ", hotel);
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());

        user.setRatings(hotelRatings);
        return user;
    }

    @Override
    public User updateUser(User user)
    {
        return null;
    }

    @Override
    public void deleteUserByID(Long userId)
    {
    }

    @Override
    public void deleteAllUsers()
    {
    }
}
