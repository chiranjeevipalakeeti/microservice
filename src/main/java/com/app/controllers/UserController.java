package com.app.controllers;

import com.app.entities.User;
import com.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;
@PostMapping("/createuser")
public ResponseEntity<User>  createUser(@RequestBody User user)
{
User user1=userService.createUser(user);
return ResponseEntity.status(HttpStatus.CREATED).body(user1);
}

@GetMapping("/{userId}")
public ResponseEntity<User> getUser(@PathVariable String userId)
{
    User user=userService.getUser(userId);
    return ResponseEntity.status(HttpStatus.OK).body(user);
}

@GetMapping("/allusers")
public ResponseEntity<List<User>> getAllUser()
{
    List<User> users= userService.getAllUser();
    return ResponseEntity.status(HttpStatus.OK).body(users);
}

}
