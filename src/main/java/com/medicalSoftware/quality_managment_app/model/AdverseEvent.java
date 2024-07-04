package com.medicalSoftware.quality_managment_app.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
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
