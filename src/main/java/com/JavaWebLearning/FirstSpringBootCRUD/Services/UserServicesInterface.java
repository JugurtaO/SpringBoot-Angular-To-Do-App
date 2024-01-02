package com.JavaWebLearning.FirstSpringBootCRUD.Services;

import com.JavaWebLearning.FirstSpringBootCRUD.Models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserServicesInterface {
    public List<User> getAllUsers();
    public ResponseEntity<User> getUserById(@PathVariable int id);
    public User signUp(@RequestBody User user);
    ResponseEntity<User> login(@RequestBody String email,@RequestBody String password);
}
