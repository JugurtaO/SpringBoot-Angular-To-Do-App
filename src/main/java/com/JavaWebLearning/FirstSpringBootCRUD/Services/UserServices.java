package com.JavaWebLearning.FirstSpringBootCRUD.Services;

import com.JavaWebLearning.FirstSpringBootCRUD.Dto.LoginRequestDTO;
import com.JavaWebLearning.FirstSpringBootCRUD.Dto.SignoutRequestDTO;
import com.JavaWebLearning.FirstSpringBootCRUD.Exceptions.BadCredentials;
import com.JavaWebLearning.FirstSpringBootCRUD.Exceptions.RessourceNotFound;
import com.JavaWebLearning.FirstSpringBootCRUD.Exceptions.UserAlreadyExists;
import com.JavaWebLearning.FirstSpringBootCRUD.Models.User;
import com.JavaWebLearning.FirstSpringBootCRUD.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        User foundUser= userRepository.findById(id)
                .orElseThrow(() -> new RessourceNotFound("No user was found with given id :"+id));


        return foundUser;
    }

    @Override
    public User signUp(User user) {
        Optional<User> foundUser=userRepository.findUserByEmail(user.getEmail());
        if(foundUser.isPresent()){
            throw  new UserAlreadyExists("User already exists, please login!");
        }else{
            //hash user password
            String HashedPassword= passwordEncoder.encode(user.getPassword());
            user.setPassword(HashedPassword);
        }


        return userRepository.save(user);
    }




    public User login(LoginRequestDTO loginRequest) {
        User foundUser=userRepository.findUserByEmail(loginRequest.getEmail()).orElseThrow(() -> new RessourceNotFound("Please signup to proceed !"));
        if(!passwordEncoder.matches(loginRequest.getPassword(),foundUser.getPassword()))
            throw new BadCredentials("Email or password incorrect!");



        return foundUser;
    }

    public void signout (SignoutRequestDTO signoutRequest){
        //Search the user that matches given email, if user exists we check the validity of the given password.
        // In both email and password verification we throw an exception in case of erroned credentials
        User foundUser=userRepository.findUserByEmail(signoutRequest.getEmail()).orElseThrow(() -> new RessourceNotFound("No existing user with given credentials, please signup!"));
        if(!passwordEncoder.matches(signoutRequest.getPassword(),foundUser.getPassword())) {
            throw new BadCredentials("Email or password incorrect!");
        }
        userRepository.delete(foundUser);

    }
}
