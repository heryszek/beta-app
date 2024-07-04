package com.medicalSoftware.quality_managment_app.service;

import com.medicalSoftware.quality_managment_app.model.AdverseEvent;
import com.medicalSoftware.quality_managment_app.repository.AdverseEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public void deleteById(Long id) {
        adverseEventRepository.deleteById(id);
    }
    public Optional<AdverseEvent> findById(Long id) {
        return adverseEventRepository.findById(id);
    }

}