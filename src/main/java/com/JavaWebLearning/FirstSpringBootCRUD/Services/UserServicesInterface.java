package com.JavaWebLearning.FirstSpringBootCRUD.Services;

import com.JavaWebLearning.FirstSpringBootCRUD.Dto.LoginRequestDTO;
import com.JavaWebLearning.FirstSpringBootCRUD.Dto.SignoutRequestDTO;
import com.JavaWebLearning.FirstSpringBootCRUD.Models.User;

import java.util.List;

public interface UserServicesInterface {
    public List<User> getAllUsers();
    public User getUserById(int id);
    public User signUp( User user);
    public User login(LoginRequestDTO loginRequest);
    public void signout ( SignoutRequestDTO signoutRequest);
}
