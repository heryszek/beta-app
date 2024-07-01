package com.medicalSoftware.quality_managment_app.service;

import com.medicalSoftware.quality_managment_app.model.Survey;
import com.medicalSoftware.quality_managment_app.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveyService {
    @Autowired
    private SurveyRepository surveyRepository;

    public List<Survey> findAll() {
        return surveyRepository.findAll();
    }

    public Survey save(Survey survey) {
        return surveyRepository.save(survey);
    }
}
