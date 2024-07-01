package com.medicalSoftware.quality_managment_app.service;

import com.medicalSoftware.quality_managment_app.model.AdverseEvent;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.util.List;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class ReportService {

    // Method to generate PDF report
    public byte[] generatePdfReport() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        // Create a PDF writer instance
        PdfWriter writer = new PdfWriter(byteArrayOutputStream);

        // Create a PDF document
        PdfDocument pdfDoc = new PdfDocument(writer);
        Document document = new Document(pdfDoc);

        // Add content to the PDF document
        document.add(new Paragraph("This is a sample PDF report."));

        // Close the document
        document.close();

        return byteArrayOutputStream.toByteArray();
    }

    // Method to generate Excel report
    public byte[] generateExcelReport() throws IOException {
        Workbook workbook = new XSSFWorkbook();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        // Create a sheet in the workbook
        Sheet sheet = workbook.createSheet("Report");

        // Create a row and put some cells in it
        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("Column 1");
        row.createCell(1).setCellValue("Column 2");

        // Populate the sheet with some data
        for (int i = 1; i <= 10; i++) {
            Row dataRow = sheet.createRow(i);
            dataRow.createCell(0).setCellValue("Data " + i);
            dataRow.createCell(1).setCellValue("More Data " + i);
        }

        // Write the workbook to the output stream
        workbook.write(byteArrayOutputStream);
        workbook.close();

        return byteArrayOutputStream.toByteArray();
    }
}

