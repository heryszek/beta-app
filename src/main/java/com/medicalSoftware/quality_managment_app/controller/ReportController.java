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
import java.io.IOException;
import java.util.List;

@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/report/pdf")
    public ResponseEntity<byte[]> getPdfReport() throws IOException {
        byte[] pdfReport = reportService.generatePdfReport();
        return ResponseEntity.ok()
                             .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=report.pdf")
                             .contentType(MediaType.APPLICATION_PDF)
                             .body(pdfReport);
    }

    @GetMapping("/report/excel")
    public ResponseEntity<byte[]> getExcelReport() throws IOException {
        byte[] excelReport = reportService.generateExcelReport();
        return ResponseEntity.ok()
                             .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=report.xlsx")
                             .contentType(MediaType.APPLICATION_OCTET_STREAM)
                             .body(excelReport);
    }
}

