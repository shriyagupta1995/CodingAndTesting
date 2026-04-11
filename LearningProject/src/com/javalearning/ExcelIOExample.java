package com.javalearning;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelIOExample {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\HP\\Downloads\\demo.xlsx";

        try {
            // Step 1: Read existing Excel file
            FileInputStream fis = new FileInputStream(filePath);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0); // first sheet

            System.out.println("Reading data from Excel:");
            for (Row row : sheet) {
                for (Cell cell : row) {
                    System.out.print(cell.toString() + "\t");
                }
                System.out.println();
            }
            fis.close();

            // Step 2: Write new data to the same file
            Row newRow = sheet.createRow(sheet.getLastRowNum() + 1);
            newRow.createCell(0).setCellValue("New Entry");
            newRow.createCell(1).setCellValue(2026);

            FileOutputStream fos = new FileOutputStream(filePath);
            workbook.write(fos);
            fos.close();
            workbook.close();

            System.out.println("Data written to Excel successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

