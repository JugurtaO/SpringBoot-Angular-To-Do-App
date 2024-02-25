package com.JavaWebLearning.FirstSpringBootCRUD.Services;

import com.JavaWebLearning.FirstSpringBootCRUD.Dto.updateTaskDTO;
import com.JavaWebLearning.FirstSpringBootCRUD.Models.Task;

import java.text.ParseException;
import java.util.List;

public interface TaskServicesInterface {

    public List<Task> getAllTasks();
    public Task getTaskById(int id);
    public List<Task> getTasksByAuthorId(int id);
    public void addTask(Task task);
    public void deleteTask(int id);
    public Task updateTask(int task_id,updateTaskDTO taskDTO) throws ParseException;
}
