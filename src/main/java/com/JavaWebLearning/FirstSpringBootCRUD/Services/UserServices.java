package com.JavaWebLearning.FirstSpringBootCRUD.Services;

import com.JavaWebLearning.FirstSpringBootCRUD.Exceptions.BadCredentials;
import com.JavaWebLearning.FirstSpringBootCRUD.Exceptions.RessourceNotFound;
import com.JavaWebLearning.FirstSpringBootCRUD.Models.LoginRequest;
import com.JavaWebLearning.FirstSpringBootCRUD.Models.User;
import com.JavaWebLearning.FirstSpringBootCRUD.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices implements UserServicesInterface{
    @Autowired
    private final UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
    public UserServices (UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();    }

    @Override
    public User getUserById(int id) {
        User user= userRepository.findById(id)
                .orElseThrow(() -> new RessourceNotFound("No user was found with given id :"+id));


        return user;
    }

    @Override
    public User signUp(User user) {
        String HashedPassword= passwordEncoder.encode(user.getPassword());
        user.setPassword(HashedPassword);
        return userRepository.save(user);
    }

    @Override
    public User login(LoginRequest loginRequest) {
        User foundUser=userRepository.findUserByEmail(loginRequest.getEmail()).orElseThrow(() -> new RessourceNotFound("Please signup to proceed !"));
        if(!passwordEncoder.matches(loginRequest.getPassword(),foundUser.getPassword()))
            throw new BadCredentials("Email or password incorrect!");



        return foundUser;
    }
}
