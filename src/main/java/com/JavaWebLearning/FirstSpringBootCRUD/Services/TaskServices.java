package com.JavaWebLearning.FirstSpringBootCRUD.Services;

import com.JavaWebLearning.FirstSpringBootCRUD.Dto.updateTaskDTO;
import com.JavaWebLearning.FirstSpringBootCRUD.Exceptions.RessourceNotFound;
import com.JavaWebLearning.FirstSpringBootCRUD.Models.Task;
import com.JavaWebLearning.FirstSpringBootCRUD.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServices implements TaskServicesInterface{
    @Autowired
    private TaskRepository taskRepository;
    public TaskServices (TaskRepository taskRepository){this.taskRepository=taskRepository;}
    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(int id) {
        Optional<Task> foundTask=taskRepository.findById(id);
        if(foundTask.isEmpty()){
            throw new RessourceNotFound("No task was found with given id :"+ id);

        }

        return foundTask.get();




    }

    @Override
    public List<Task> getTasksByAuthorId(int id) {
        Optional<Task[]> foundTasks=taskRepository.findTasksByAuthorId(id);
        if(foundTasks.isEmpty()){
            throw new RessourceNotFound("No task was found !");
        }
        return List.of(foundTasks.get());
    }

    @Override
    public void addTask(Task task){
        taskRepository.save(task);
    }
    @Override
    public void deleteTask(int id) {
        Task requestedTask=getTaskById(id);
        taskRepository.deleteById(id);
    }

    @Override
    public Task updateTask(int task_id,updateTaskDTO taskDTO) throws ParseException {

        Task requestedTask = getTaskById(task_id);
        requestedTask.setText(taskDTO.getNewText());
        System.out.println(">>>>>>>:"+taskDTO.getNewDueDate());
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm");

        requestedTask.setDueDate(simpleDateFormat.parse(taskDTO.getNewDueDate()));
        System.out.println(">>>>>>> AFTER SET:"+taskDTO.getNewDueDate());


        taskRepository.save(requestedTask);
        return requestedTask;
    }
}
