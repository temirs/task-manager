package com.example.task_manager.controller;

import com.example.task_manager.models.Task;
import com.example.task_manager.service.serviceImpl.TaskServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class TaskController {

    private final TaskServiceImpl taskService;

    @GetMapping(value = "/tasks")
    public ResponseEntity<List<Task>> getAllTasks(){
        return ResponseEntity.ok().body(taskService.getAllTasks());
    }

    @GetMapping(value = "task/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable int id) {
        return ResponseEntity.ok().body(taskService.getTaskById(id));
    }

    @PostMapping(value = "/add_task")
    public ResponseEntity<?> addTask(@RequestBody Task task){
        taskService.addTask(task);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping(value = "/{id}")
    public void deleteTask(@PathVariable int id) {
        taskService.removeTask(id);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable int id, @RequestBody Task task){
        taskService.updateTask(id, task);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
