package com.medicalSoftware.quality_managment_app.controller;

import com.medicalSoftware.quality_managment_app.exceptions.ResourceNotFoundException;
import com.medicalSoftware.quality_managment_app.model.Task;
import com.medicalSoftware.quality_managment_app.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        Task task = taskService.findById(id)
                               .orElseThrow(() -> new ResourceNotFoundException("Task not found for this id :: " + id));
        return ResponseEntity.ok().body(task);
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.save(task);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task taskDetails) {
        Task task = taskService.findById(id)
                               .orElseThrow(() -> new ResourceNotFoundException("Task not found for this id :: " + id));

        task.setDescription(taskDetails.getDescription());
        task.setDueDate(taskDetails.getDueDate());
        task.setAssignedTo(taskDetails.getAssignedTo());

        final Task updatedTask = taskService.save(task);
        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteTask(@PathVariable Long id) {
        Task task = taskService.findById(id)
                               .orElseThrow(() -> new ResourceNotFoundException("Task not found for this id :: " + id));

        taskService.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}

