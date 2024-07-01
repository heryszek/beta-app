package com.medicalSoftware.quality_managment_app.service;

import com.medicalSoftware.quality_managment_app.model.AdverseEvent;
import com.medicalSoftware.quality_managment_app.repository.AdverseEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdverseEventService {
    @Autowired
    private AdverseEventRepository adverseEventRepository;

    public List<AdverseEvent> findAll() {
        return adverseEventRepository.findAll();
    }

    public AdverseEvent save(AdverseEvent adverseEvent) {
        return adverseEventRepository.save(adverseEvent);
    }
}