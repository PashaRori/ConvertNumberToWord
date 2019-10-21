package model;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Workbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.ExcelOpen;

import static org.testng.Assert.assertEquals;

public class ConvertNumberToWordDDTest {

    @DataProvider
    public Object[][] getValuesFromRussianExcel() {
        Workbook workbook = ExcelOpen.openFile("ExcelDDTTestOnRussian.xls");
        return getValuesFromExcel(workbook);
    }

    @DataProvider
    public Object[][] getValuesFromEnglishExcel() {
        Workbook workbook = ExcelOpen.openFile("ExcelDDTTestOnEnglish.xls");
        return getValuesFromExcel(workbook);
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

    private Object[][] getValuesFromExcel(Workbook workbook) {
        Object[][] arrayWithValuesFromExcel = new Object[workbook.getSheetAt(0).getLastRowNum() + 1][2];
        for (int i = 0; i < workbook.getSheetAt(0).getLastRowNum() + 1; i++) {
            arrayWithValuesFromExcel[i][0] = String.valueOf((long) workbook.getSheetAt(0).getRow(i).getCell(0).getNumericCellValue());
            arrayWithValuesFromExcel[i][1] = String.valueOf(workbook.getSheetAt(0).getRow(i).getCell(1));
        }
        return arrayWithValuesFromExcel;
    }
}