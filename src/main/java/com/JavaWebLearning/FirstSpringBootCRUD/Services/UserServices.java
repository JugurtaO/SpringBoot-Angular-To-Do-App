package com.JavaWebLearning.FirstSpringBootCRUD.Services;

import com.JavaWebLearning.FirstSpringBootCRUD.Dto.LoginRequestDTO;
import com.JavaWebLearning.FirstSpringBootCRUD.Dto.SignoutRequestDTO;
import com.JavaWebLearning.FirstSpringBootCRUD.Exceptions.BadCredentials;
import com.JavaWebLearning.FirstSpringBootCRUD.Exceptions.RessourceNotFound;
import com.JavaWebLearning.FirstSpringBootCRUD.Models.User;
import com.JavaWebLearning.FirstSpringBootCRUD.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

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




    public User login(LoginRequestDTO loginRequest) {
        User foundUser=userRepository.findUserByEmail(loginRequest.getEmail()).orElseThrow(() -> new RessourceNotFound("Please signup to proceed !"));
        if(!passwordEncoder.matches(loginRequest.getPassword(),foundUser.getPassword()))
            throw new BadCredentials("Email or password incorrect!");



        return foundUser;
    }

    public void signout (SignoutRequestDTO signoutRequest){
        //Search the user that matches given email, if user exists we check the validity of the given password. In both email and password verifications we throw an exception in case of erroned credentials
        User foundUser=userRepository.findUserByEmail(signoutRequest.getEmail()).orElseThrow(() -> new RessourceNotFound("No existing user with given credentials !"));
        if(!passwordEncoder.matches(signoutRequest.getPassword(),foundUser.getPassword()))
            throw new BadCredentials("Email or password incorrect!");

        userRepository.delete(foundUser);

    }
}
