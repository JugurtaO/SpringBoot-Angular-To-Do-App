package com.JavaWebLearning.FirstSpringBootCRUD.Services;

import com.JavaWebLearning.FirstSpringBootCRUD.Dto.LoginRequestDTO;
import com.JavaWebLearning.FirstSpringBootCRUD.Models.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserServicesInterface {
    public List<User> getAllUsers();
    public User getUserById(@PathVariable int id);
    public User signUp(@RequestBody User user);
    public User login(@RequestBody LoginRequestDTO loginRequest);
}
