package com.medicalSoftware.quality_managment_app.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "adverseevent")
public class AdverseEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private LocalDateTime eventDate;
    private String severity;
    private String reportedBy;

    // Getters and Setters
}
