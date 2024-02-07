package com.JavaWebLearning.FirstSpringBootCRUD.Controllers;

import com.JavaWebLearning.FirstSpringBootCRUD.Models.Task;
import com.JavaWebLearning.FirstSpringBootCRUD.Services.TaskServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/tasks")
public class TaskControllers {
    @Autowired
    private final TaskServices taskServices;

    public  TaskControllers(TaskServices taskServices){this.taskServices=taskServices;}


    @GetMapping({"","/"})
    public List<Task> getAllTasks(){
        return taskServices.getAllTasks();
    }
    @PostMapping("/add")
    public ResponseEntity<String> addTask(@RequestBody Task task){
        taskServices.addTask(task);
        return ResponseEntity.ok("Task created successfully.");
    }

    @GetMapping("/{id}")
    public Task getTaskById(int id){
        return taskServices.getTaskById(id);
    }

    @CrossOrigin
    @PostMapping("/{id}/delete")
    public ResponseEntity<String>deleteTask(@PathVariable int id ){
        taskServices.deleteTask(id);
        return ResponseEntity.ok("Task deleted successfully !");

    }



}
