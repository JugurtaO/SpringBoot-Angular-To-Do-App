package com.JavaWebLearning.FirstSpringBootCRUD.Services;

import com.JavaWebLearning.FirstSpringBootCRUD.Models.LoginRequest;
import com.JavaWebLearning.FirstSpringBootCRUD.Models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserServicesInterface {
    public List<User> getAllUsers();
    public User getUserById(@PathVariable int id);
    public User signUp(@RequestBody User user);
    public User login(@RequestBody LoginRequest loginRequest);
}
