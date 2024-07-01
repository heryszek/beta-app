package com.medicalSoftware.quality_managment_app.service;

import com.medicalSoftware.quality_managment_app.model.Task;
import com.medicalSoftware.quality_managment_app.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task save(Task task) {
        return taskRepository.save(task);
    }
}
