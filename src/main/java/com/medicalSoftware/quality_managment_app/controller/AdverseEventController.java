package com.medicalSoftware.quality_managment_app.controller;

import com.medicalSoftware.quality_managment_app.exceptions.ResourceNotFoundException;
import com.medicalSoftware.quality_managment_app.model.AdverseEvent;
import com.medicalSoftware.quality_managment_app.service.AdverseEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    @GetMapping("/{id}")
    public ResponseEntity<AdverseEvent> getAdverseEventById(@PathVariable Long id) {
        AdverseEvent adverseEvent = adverseEventService.findById(id)
                                                       .orElseThrow(() -> new ResourceNotFoundException("AdverseEvent not found for this id :: " + id));
        return ResponseEntity.ok().body(adverseEvent);
    }

    @PostMapping
    public AdverseEvent createAdverseEvent(@RequestBody AdverseEvent adverseEvent) {
        return adverseEventService.save(adverseEvent);
    }
    @DeleteMapping("/{id}")
    public void deleteAdverseEvent(@PathVariable Long id) {
        adverseEventService.deleteById(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<AdverseEvent> updateAdverseEvent(@PathVariable Long id, @RequestBody AdverseEvent adverseEventDetails) {
        AdverseEvent adverseEvent = adverseEventService.findById(id)
                                                       .orElseThrow(() -> new ResourceNotFoundException("AdverseEvent not found for this id :: " + id));

        adverseEvent.setDescription(adverseEventDetails.getDescription());
        adverseEvent.setEventDate(adverseEventDetails.getEventDate());
        adverseEvent.setSeverity(adverseEventDetails.getSeverity());
        adverseEvent.setReportedBy(adverseEventDetails.getReportedBy());

        final AdverseEvent updatedAdverseEvent = adverseEventService.save(adverseEvent);
        return ResponseEntity.ok(updatedAdverseEvent);
    }

}
