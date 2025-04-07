package com.example.task_manager.service.serviceImpl;

import com.example.task_manager.models.Task;
import com.example.task_manager.repositories.TaskRepository;
import com.example.task_manager.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    final TaskRepository taskRepository;

    @Override
    public void addTask(Task task) {
        taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public void removeTask(int id) {
        taskRepository.deleteById(id);
    }

    @Override
    public Task getTaskById(int id) {
        return taskRepository.findById(id).orElseThrow();
    }

    @Override
    public void updateTask(int id, Task updatedTask) {
        taskRepository.findById(id).orElseThrow().setDescription(updatedTask.getDescription());
        taskRepository.findById(id).orElseThrow().setTaskStatus(updatedTask.getTaskStatus());
        taskRepository.findById(id).orElseThrow().setTitle(updatedTask.getTitle());
    }
}
