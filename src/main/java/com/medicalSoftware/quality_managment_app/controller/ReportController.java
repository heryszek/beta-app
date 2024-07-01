package com.medicalSoftware.quality_managment_app.controller;

import com.medicalSoftware.quality_managment_app.model.AdverseEvent;
import com.medicalSoftware.quality_managment_app.service.AdverseEventService;
import com.medicalSoftware.quality_managment_app.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportController {
    @Autowired
    private ReportService reportService;
    @Autowired
    private AdverseEventService adverseEventService;

    @GetMapping("/pdf")
    public ResponseEntity<InputStreamResource> downloadPdfReport() {
        List<AdverseEvent> adverseEvents = adverseEventService.findAll();
        ByteArrayInputStream bis = reportService.generatePdfReport(adverseEvents);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=adverse-events-report.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

    @GetMapping("/excel")
    public ResponseEntity<InputStreamResource> downloadExcelReport() {
        List<AdverseEvent> adverseEvents = adverseEventService.findAll();
        ByteArrayInputStream bis = reportService.generateExcelReport(adverseEvents);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=adverse-events-report.xlsx");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                .body(new InputStreamResource(bis));
    }
}
