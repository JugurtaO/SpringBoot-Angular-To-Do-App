package com.JavaWebLearning.FirstSpringBootCRUD.Controllers;

import com.JavaWebLearning.FirstSpringBootCRUD.Dto.updateTaskDTO;
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
    @CrossOrigin
    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable int id){
        return taskServices.getTaskById(id);
    }

    @CrossOrigin
    @PostMapping("/{id}/delete")
    public ResponseEntity<String>deleteTask(@PathVariable int id ){
        taskServices.deleteTask(id);
        return ResponseEntity.ok("Task deleted successfully !");

    }

    @CrossOrigin
    @PostMapping("/{id}/update")
    public ResponseEntity<String> updateTask(@PathVariable int id,@RequestBody updateTaskDTO taskDTO){
        taskServices.updateTask(id,taskDTO);
        System.out.println(">>>> new Text:"+taskDTO.getNewText());
        return ResponseEntity.ok("Task updated successfully !");

    }


}
