package model;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

import static util.FinalData.*;
import static org.testng.Assert.assertEquals;

public class ConvertNumberToWordDDT {
    private static final Logger LOGGER = Logger.getLogger(ConvertNumberToWordDDT.class);

    @DataProvider
    public Object[][] getValuesFromRussianExcel() {
        Workbook workbook = getLibrary("ExcelDDTTestOnRussian.xls");
        return getValuesFromEnglishExcel(workbook);
    }

    @DataProvider
    public Object[][] getValuesFromEnglishExcel() {
        Workbook workbook = getLibrary("ExcelDDTTestOnEnglish.xls");
        return getValuesFromEnglishExcel(workbook);
    }

    @Test(dataProvider = "getValuesFromRussianExcel")
    public void compareNumberConvertedToWordsAndWordsOnRussian(String numberConvertedToWords, String referenceWords) {
        ConvertNumberToWord convertNumberToWord = new ConvertNumberToWord(numberConvertedToWords, "Rus");
        String convertedValueOfNumberToWords = convertNumberToWord.createFinalWord();
        assertEquals(referenceWords, convertedValueOfNumberToWords);
    }

    @Test(dataProvider = "getValuesFromEnglishExcel")
    public void compareNumberConvertedToWordsAndWordsOnEnglish(String numberConvertedToWords, String referenceWords) {
        ConvertNumberToWord convertNumberToWord = new ConvertNumberToWord(numberConvertedToWords, "Eng");
        String convertedValueOfNumberToWords = convertNumberToWord.createFinalWord();
        assertEquals(referenceWords, convertedValueOfNumberToWords);
    }


    private Workbook getLibrary(String fileName){
        ClassLoader classLoader = ConvertNumberToWordDDT.class.getClassLoader();
        FileInputStream fileInputStream = null;
        Workbook workbook = null;

        try {
            fileInputStream = new FileInputStream(Objects.requireNonNull(classLoader.getResource(fileName)).getFile());
            try {
                workbook = new HSSFWorkbook(fileInputStream);
            } catch (IOException e) {
                PropertyConfigurator.configure(classLoader.getResource(LOG4J_FILE));
                LOGGER.error(ERROR_INPUT_STREAM);
            }
        } catch (FileNotFoundException e) {
            PropertyConfigurator.configure(classLoader.getResource(LOG4J_FILE));
            LOGGER.error(FILE_NOT_FOUND);
        }
        try {
            if (fileInputStream != null) fileInputStream.close();
        } catch (Exception e) {
            PropertyConfigurator.configure(classLoader.getResource(LOG4J_FILE));
            LOGGER.error(ERROR_CLOSE_STREAM);
        }
        return workbook;
    }

    private Object[][] getValuesFromEnglishExcel(Workbook getWorkBook) {
        Object[][] arrayWithValuesFromExcel = new Object[getWorkBook.getSheetAt(0).getLastRowNum() + 1][2];
        for (int i = 0; i < getWorkBook.getSheetAt(0).getLastRowNum() + 1; i++) {
            arrayWithValuesFromExcel[i][0] = String.valueOf((long) getWorkBook.getSheetAt(0).getRow(i).getCell(0).getNumericCellValue());
            arrayWithValuesFromExcel[i][1] = String.valueOf(getWorkBook.getSheetAt(0).getRow(i).getCell(1));
        }
        return arrayWithValuesFromExcel;
    }
}