package com.salapp.springangulardemo.controller;

import com.salapp.springangulardemo.model.User;
import com.salapp.springangulardemo.repository.UserRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200" )
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/users")
    public void saveUser(@RequestBody User user){
        System.out.println(user.getName());
        this.userRepository.save(user);
    }

    @GetMapping("/users")
    public List<User> getAllUser() {
        return (List<User>) this.userRepository.findAll();
    }
}
