package com.example.task_manager.service;


import com.example.task_manager.models.Task;

import java.util.List;

public interface TaskService {

    void addTask(Task task);

    List<Task> getAllTasks();

    void removeTask(int id);

    Task getTaskById(int id);

    void updateTask(int id, Task task);
}
