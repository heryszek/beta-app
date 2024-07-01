package com.medicalSoftware.quality_managment_app.repository;

import com.medicalSoftware.quality_managment_app.model.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyRepository extends JpaRepository<Survey, Long> {}

