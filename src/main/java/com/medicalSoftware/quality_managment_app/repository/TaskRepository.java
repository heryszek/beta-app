package com.medicalSoftware.quality_managment_app.repository;

import com.medicalSoftware.quality_managment_app.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {}

