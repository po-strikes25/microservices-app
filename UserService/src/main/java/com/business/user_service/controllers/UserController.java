package com.business.user_service.controllers;

import com.business.user_service.entities.User;
import com.business.user_service.exceptions.ResourceNotFoundException;
import com.business.user_service.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
@RequiredArgsConstructor
public class UserController
{
    private final UserService userService;

    @PostMapping("/post")
    public ResponseEntity<User> postExpense(@RequestBody User user)
    {
        User    newUser    =   userService.createUser(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getUserByID(@PathVariable String id)
    {
        try
        {
            return ResponseEntity.ok(userService.getUserByID(id));
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
        return ResponseEntity.ok(userService.getAllUsers());
    }

}
