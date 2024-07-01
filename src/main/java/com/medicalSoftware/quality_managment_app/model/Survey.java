package com.medicalSoftware.quality_managment_app.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "survey")
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
