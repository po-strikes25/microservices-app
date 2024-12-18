package com.business.user_service.services;

import com.business.user_service.entities.User;

import java.util.List;

public interface UserService
{
    User createUser(User user);
    List<User> getAllUsers();
    User getUserByID(String userId);
    User updateUser(User user);
    void deleteUserByID(Long userId);
    void deleteAllUsers();
}
