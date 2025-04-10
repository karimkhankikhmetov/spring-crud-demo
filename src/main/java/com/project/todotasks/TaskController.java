package com.project.todotasks;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @PostMapping
    public ResponseEntity<String> createTask(@RequestBody Task newTaskRequest, UriComponentsBuilder ucb) {
        Task savedTask = taskRepository.save(newTaskRequest);
        URI locationOfNewTask = ucb
                .path("/tasks/{id}")
                .buildAndExpand(savedTask.getId())  // assuming getId() is the method in Task class
                .toUri();
        return ResponseEntity.created(locationOfNewTask).build();
    }
}
