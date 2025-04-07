package com.example.task_manager;

import com.example.task_manager.repositories.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskManagerApplication implements CommandLineRunner {

	private final TaskRepository taskRepository;

	public TaskManagerApplication(TaskRepository taskRepository){
		this.taskRepository = taskRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(TaskManagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		taskRepository.findAll().forEach(task -> {
			System.out.println(task.toString());
		});
	}
}
