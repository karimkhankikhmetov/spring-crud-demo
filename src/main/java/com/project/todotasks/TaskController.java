package com.project.todotasks.controller;

import com.project.todotasks.model.Task;
import com.project.todotasks.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping
    public Task createTask(@RequestBody Task task, UriComponentsBuilder ucb) {
        Task task1 = task;
        Task savedTask = TaskRepository.save();
        URI locationOfNewTask = ucb
                .path("tasks/{id}")
                .buildAndExpand(savedCashCard.id())
                .toUri();
        return ResponseEntity.created("locationOfNewTask").build();
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task taskDetails) {
        return taskService.updateTask(id, taskDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}
