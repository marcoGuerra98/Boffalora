package com.example.Boffalora.utils;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExcelUtils {

    public static List<String[]> readDataFromExcel(String filePath) throws IOException, InvalidFormatException {

        //leggi file excel
        Workbook workbook = new XSSFWorkbook(new File(filePath));
        Sheet sheet = workbook.getSheetAt(0);

        // Crea una lista per memorizzare i dati
        List<String[]> data = new ArrayList<>();


        // Iteriamo sulle righe (a partire dalla seconda per evitare l'intestazione)
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                String[] rowData = new String[(int) row.getLastCellNum()];
                for (int j = 0; j < rowData.length; j++) {
                    Cell cell = row.getCell(j);
                    if (cell != null) {
                        switch (cell.getCellType()) {
                            case STRING -> rowData[j] = cell.getStringCellValue();
                            case NUMERIC -> rowData[j] = String.valueOf(cell.getNumericCellValue());
                        }
                        /* codice fondamentale per ricevere dato di tipo Data*/
                        if (cell.getCellType() == CellType.NUMERIC) {
                            if (DateUtil.isCellDateFormatted(cell)) {
                                Date date = cell.getDateCellValue();

                                // Formatta la data in un formato leggibile
                                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                                String formattedDate = dateFormat.format(date);
                                rowData[j] = formattedDate;
                            }
                        }
                    }
                }
                data.add(rowData);
            }
        }
        workbook.close();
        return data;
    }


    public static void writeDataToExcel(String filePath, List<String[]> data) throws IOException, InvalidFormatException {
        // Controlla se il file esiste
        File file = new File(filePath);
        Workbook workbook;

        if (file.exists()) {
            try (FileInputStream fileIn = new FileInputStream(file)) {
                workbook = new XSSFWorkbook(fileIn);
            }
        } else {
            workbook = new XSSFWorkbook();
        }

        // Ottieni il primo foglio (o crealo se non esiste)
        Sheet sheet = workbook.getSheetAt(0);
        if (sheet == null) {
            sheet = workbook.createSheet();
        }

        // Trova l'ultima riga esistente e inizia a scrivere da lì
        int lastRow = sheet.getLastRowNum();

        try {
            // Scrivi i nuovi dati
            for (String[] rowData : data) {
                Row row = sheet.createRow(++lastRow);
                for (int j = 0; j < rowData.length; j++) {
                    row.createCell(j).setCellValue(rowData[j]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
            workbook.write(outputStream);
        }
        workbook.close();
    }

    public static int lastRowFile(String filePath) throws IOException, InvalidFormatException {

        File file = new File(filePath);
        Workbook workbook = null;
        if (file.exists()) {
            // Apre il workbook esistente
            workbook = new XSSFWorkbook(file);
        }

        Sheet sheet = workbook.getSheetAt(0);
        return sheet.getLastRowNum();
    }
}

