package com.JavaWebLearning.FirstSpringBootCRUD.Controllers;

import com.JavaWebLearning.FirstSpringBootCRUD.Dto.LoginRequestDTO;
import com.JavaWebLearning.FirstSpringBootCRUD.Dto.SignoutRequestDTO;
import com.JavaWebLearning.FirstSpringBootCRUD.Dto.updateTaskDTO;
import com.JavaWebLearning.FirstSpringBootCRUD.Models.Task;
import com.JavaWebLearning.FirstSpringBootCRUD.Models.User;
import com.JavaWebLearning.FirstSpringBootCRUD.Services.TaskServices;
import com.JavaWebLearning.FirstSpringBootCRUD.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserControllers {
    @Autowired
   private final  UserServices userServices;
    @Autowired
    private final  TaskServices taskServices;


    public  UserControllers(UserServices userServices, TaskServices taskServices){
        this.userServices=userServices;
        this.taskServices=taskServices;
    }

    @GetMapping("/")
    public List<User> getAllUsers(){
            return userServices.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id){
        User user= userServices.getUserById(id);
       return ResponseEntity.ok(user);
    }
    @GetMapping("/{id}/tasks")
    public List<Task> getUserTasks(@PathVariable int id){
    return taskServices.getTasksByAuthorId(id);
    }
    @GetMapping("/{id}/tasks/{taskId}")
    public Task getTaskById(@PathVariable int taskId){
        return taskServices.getTaskById(taskId);
    }

    @PostMapping ("/signup")
    public User signUp(@RequestBody User user){
        return userServices.signUp(user);

    }
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginRequestDTO loginRequest){

        User user = userServices.login(loginRequest);
       return ResponseEntity.ok(user);


    }

    @PostMapping("/signout")
    public ResponseEntity<String> signout(@RequestBody SignoutRequestDTO signoutRequest){
            userServices.signout(signoutRequest);




            return ResponseEntity.ok("User successfully signed out !");


    }
    @PostMapping("/{id}/tasks/add")
    public ResponseEntity<String> addTask(@RequestBody Task task){
        taskServices.addTask(task);
        return ResponseEntity.ok("Task created successfully.");
    }
    @PostMapping("/{id}/tasks/{taskId}/delete")
    public ResponseEntity<String>deleteTask(@PathVariable int taskId ){
        taskServices.deleteTask(taskId);
        return ResponseEntity.ok("Task deleted successfully !");

    }

    @PostMapping("/{id}/tasks/{task_id}/update")
    public ResponseEntity<Task> updateTask(@PathVariable int task_id,@RequestBody updateTaskDTO taskDTO){
        return ResponseEntity.ok(taskServices.updateTask(task_id,taskDTO));

    }






}
