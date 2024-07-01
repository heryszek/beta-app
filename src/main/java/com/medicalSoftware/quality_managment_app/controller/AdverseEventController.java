package com.medicalSoftware.quality_managment_app.controller;

import com.medicalSoftware.quality_managment_app.model.AdverseEvent;
import com.medicalSoftware.quality_managment_app.service.AdverseEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/adverse-events")
public class AdverseEventController {
    @Autowired
    private AdverseEventService adverseEventService;

    @GetMapping
    public List<AdverseEvent> getAllAdverseEvents() {
        return adverseEventService.findAll();
    }

    @PostMapping
    public AdverseEvent createAdverseEvent(@RequestBody AdverseEvent adverseEvent) {
        return adverseEventService.save(adverseEvent);
    }
}
