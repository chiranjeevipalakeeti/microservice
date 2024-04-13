package com.app.impl;

import com.app.entities.Hotel;
import com.app.entities.Rating;
import com.app.entities.User;
import com.app.exceptions.ResourceNotFoundException;
import com.app.external.service.Hotelservice;
import com.app.repositories.UserRepository;
import com.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private Hotelservice hotelservice;
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {

        User user=userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user with given id is not present"));
Rating[] ratingsofUser= restTemplate.getForObject("http://RATINGSERVICE/api/rating/user/"+userId, Rating[].class);
List<Rating> ratings= Arrays.stream(ratingsofUser).toList();
    List<Rating> ratingList=   ratings.stream().map(rating->{

//http://localhost:8082/api/hotel/H1
//        Hotel forEntity1=restTemplate.getForObject("http://localhost:8082/api/hotel/H1", Hotel.class);
       // ResponseEntity<Hotel> forEntity= restTemplate.getForEntity("http://HOTELSERVICE/api/hotel/H1", Hotel.class);
Hotel hotel=hotelservice.getHotel(rating.getHotelId());
rating.setHotel(hotel);
         return rating;
        }).collect(Collectors.toList());

user.setRatings(ratingList);
        return user;
    }

    @Override
    public User updateUser(String userId, User user) {
        return null;
    }
}
