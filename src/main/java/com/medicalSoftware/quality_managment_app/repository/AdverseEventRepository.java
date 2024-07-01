package com.medicalSoftware.quality_managment_app.repository;

import com.medicalSoftware.quality_managment_app.model.AdverseEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdverseEventRepository extends JpaRepository<AdverseEvent, Long> {}
