package com.JavaWebLearning.FirstSpringBootCRUD.Controllers;

import com.JavaWebLearning.FirstSpringBootCRUD.Exceptions.RessourceNotFound;
import com.JavaWebLearning.FirstSpringBootCRUD.Models.User;
import com.JavaWebLearning.FirstSpringBootCRUD.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserControllers {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public List<User> getAllUsers(){
            return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id){

        User user= userRepository.findById(id)
                .orElseThrow(() -> new RessourceNotFound("No user was found with given id :"+id));
        return ResponseEntity.ok(user);
    }
    @PostMapping ("/signup")
    public User signUp(@RequestBody User user){
        return userRepository.save(user);

    }
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody String email,@RequestBody String password){

        User foundUser=userRepository.findUserByEmailAndPassword(email,password).orElseThrow(() -> new RessourceNotFound("Please signup to proceed !"));


        return ResponseEntity.ok(foundUser);


    }




}
