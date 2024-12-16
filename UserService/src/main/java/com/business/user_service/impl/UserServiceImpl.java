package com.business.user_service.impl;

import com.business.user_service.entities.User;
import com.business.user_service.exceptions.ResourceNotFoundException;
import com.business.user_service.repositories.UserRepository;
import com.business.user_service.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService
{
    // he @Autowired the userRepository
    private final UserRepository userRepository;

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
        return userRepository
                .findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found !!!"));
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
