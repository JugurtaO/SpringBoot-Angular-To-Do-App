package com.JavaWebLearning.FirstSpringBootCRUD.Controllers;

import com.JavaWebLearning.FirstSpringBootCRUD.Exceptions.RessourceNotFound;
import com.JavaWebLearning.FirstSpringBootCRUD.Models.LoginRequest;
import com.JavaWebLearning.FirstSpringBootCRUD.Models.User;
import com.JavaWebLearning.FirstSpringBootCRUD.Repository.UserRepository;
import com.JavaWebLearning.FirstSpringBootCRUD.Services.UserServices;
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
   private final  UserServices userServices;

   public  UserControllers(UserServices userServices){this.userServices=userServices;}

    @GetMapping("/")
    public List<User> getAllUsers(){
            return userServices.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id){
        User user= userServices.getUserById(id);
       return ResponseEntity.ok(user);
    }
    @PostMapping ("/signup")
    public User signUp(@RequestBody User user){
        return userServices.signUp(user);

    }
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginRequest loginRequest){

        User user = userServices.login(loginRequest);
       return ResponseEntity.ok(user);


    }




}
