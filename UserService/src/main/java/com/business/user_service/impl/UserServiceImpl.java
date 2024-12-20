package com.business.user_service.impl;

import com.business.user_service.entities.User;
import com.business.user_service.exceptions.ResourceNotFoundException;
import com.business.user_service.repositories.UserRepository;
import com.business.user_service.services.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
        ArrayList   userRatings = restTemplate.getForObject("http://localhost:8083/rating/get/user/" + user.getUserId(), ArrayList.class);

        logger.info("getUserByID() --> Data fetched from RATING SERVICE: {} ", userRatings);

        user.setRatings(userRatings);

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
