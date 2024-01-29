package com.JavaWebLearning.FirstSpringBootCRUD.Controllers;

import com.JavaWebLearning.FirstSpringBootCRUD.Models.Task;
import com.JavaWebLearning.FirstSpringBootCRUD.Services.TaskServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
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




}
