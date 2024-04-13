package com.app.service;

import com.app.entities.User;

import java.util.List;

public interface UserService {

    User createUser(User user);
    List<User> getAllUser();

    User getUser(String userId);

    User updateUser(String userId,User user);


}
