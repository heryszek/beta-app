package com.medicalSoftware.quality_managment_app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String patientEmail;
    private String feedback;
    private int rating;
    private LocalDateTime submittedAt;

    // Getters and Setters
}
