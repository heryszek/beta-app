package com.medicalSoftware.quality_managment_app.controller;

import com.medicalSoftware.quality_managment_app.model.Survey;
import com.medicalSoftware.quality_managment_app.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/surveys")
public class SurveyController {
    @Autowired
    private SurveyService surveyService;

    @GetMapping
    public List<Survey> getAllSurveys() {
        return surveyService.findAll();
    }

    @PostMapping
    public Survey createSurvey(@RequestBody Survey survey) {
        return surveyService.save(survey);
    }
}
