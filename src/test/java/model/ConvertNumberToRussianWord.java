package model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static util.ConstantData.*;
import static org.junit.jupiter.api.Assertions.*;

class ConvertNumberToRussianWord {
    private static ConvertNumberToWord convertedOneHundred;
    private static ConvertNumberToWord convertedTen;
    private static ConvertNumberToWord convertOneHundredWithZerosAtBegin;
    private static ConvertNumberToWord convertOneMillionOne;
    private static ConvertNumberToWord convertNullReceived;
    private static ConvertNumberToWord convertTextReceived;
    private static ConvertNumberToWord convertOutOfExcelDirectory;

    @BeforeAll
    public static void createMemoryToClass() {
        convertedOneHundred = new ConvertNumberToWord(ONE_HUNDRED, LANGUAGE);
        convertedTen = new ConvertNumberToWord(TEN, LANGUAGE);
        convertOneHundredWithZerosAtBegin = new ConvertNumberToWord(ONE_HUNDRED_WITH_ZEROS_AT_BEGIN, LANGUAGE);
        convertOneMillionOne = new ConvertNumberToWord(ONE_MILLION_ONE, LANGUAGE);
    }

    @Test
    public void compareConvertedOneHundredAndOneHundredTheWord() {
        assertEquals(ONE_HUNDRED_WORD, convertedOneHundred.createFinalWord());
    }

    @Test
    public void compareConvertedTendAndOneHundredTheWord() {
        assertNotEquals(ONE_HUNDRED_WORD, convertedTen.createFinalWord());
    }

    @Test
    public void compareConvertedOneHundredWithZeroSignsAndOneHundredTheWord() {
        assertEquals(ONE_HUNDRED_WORD, convertOneHundredWithZerosAtBegin.createFinalWord());
    }

    @Test
    public void compareConvertedOneMillionOneAndOneMillionOneTheWord() {
        assertEquals(ONE_MILLION_ONE_WORD, convertOneMillionOne.createFinalWord());
    }

    @Test
    public void checkNullPointerExceptionWithNullValue() {
        convertNullReceived = new ConvertNumberToWord(NULL, LANGUAGE);
        assertThrows(StringIndexOutOfBoundsException.class, () -> {
            convertNullReceived.createFinalWord();
        });
    }

    @Test
    public void checkNumberFormatExceptionWithNotNumberValue() {
        convertTextReceived = new ConvertNumberToWord(NOT_NUMBER_VALUE, LANGUAGE);
        assertThrows(StringIndexOutOfBoundsException.class, () -> {
            convertTextReceived.createFinalWord();
        });
    }

    @Test
    public void checkArrayIndexOutOfBoundsExceptionWithNumberOutedOfBoundsExcel() {
        convertOutOfExcelDirectory = new ConvertNumberToWord(NUMBER_WHO_OUT_OF_EXCEL_DIRECTORY, LANGUAGE);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            convertOutOfExcelDirectory.createFinalWord();
        });
    }
}