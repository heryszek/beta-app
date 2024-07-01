package com.medicalSoftware.quality_managment_app.repository;

import com.medicalSoftware.quality_managment_app.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {}

