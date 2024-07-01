package com.medicalSoftware.quality_managment_app.service;

import com.medicalSoftware.quality_managment_app.model.Schedule;
import com.medicalSoftware.quality_managment_app.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;

    public List<Schedule> findAll() {
        return scheduleRepository.findAll();
    }

    public Schedule save(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }
}
