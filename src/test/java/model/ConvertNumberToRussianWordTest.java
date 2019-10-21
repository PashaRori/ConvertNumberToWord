package model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static util.ConstantData.*;
import static org.junit.jupiter.api.Assertions.*;

class ConvertNumberToRussianWordTest {
    private static ConvertNumberToWord convertedOneHundred;
    private static ConvertNumberToWord convertedTen;
    private static ConvertNumberToWord convertOneHundredWithZerosAtBegin;
    private static ConvertNumberToWord convertOneMillionOne;
    private static ConvertNumberToWord convertNullReceived;
    private static ConvertNumberToWord convertTextReceived;
    private static ConvertNumberToWord convertOutOfExcelDirectory;

    @BeforeAll
    public static void createMemoryToClass() {
        convertedOneHundred = new ConvertNumberToWord(ONE_HUNDRED_NUMBER, LANGUAGE_RUSSIAN);
        convertedTen = new ConvertNumberToWord(TEN_NUMBER, LANGUAGE_RUSSIAN);
        convertOneHundredWithZerosAtBegin = new ConvertNumberToWord(ONE_HUNDRED_WITH_ZEROS_AT_BEGIN, LANGUAGE_RUSSIAN);
        convertOneMillionOne = new ConvertNumberToWord(ONE_MILLION_ONE_NUMBER, LANGUAGE_RUSSIAN);
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
        convertNullReceived = new ConvertNumberToWord(NULL, LANGUAGE_RUSSIAN);
        assertThrows(StringIndexOutOfBoundsException.class, () -> {
            convertNullReceived.createFinalWord();
        });
    }

    @Test
    public void checkNumberFormatExceptionWithNotNumberValue() {
        convertTextReceived = new ConvertNumberToWord(NOT_NUMBER_VALUE, LANGUAGE_RUSSIAN);
        assertThrows(StringIndexOutOfBoundsException.class, () -> {
            convertTextReceived.createFinalWord();
        });
    }

    @Test
    public void checkArrayIndexOutOfBoundsExceptionWithNumberOutedOfBoundsExcel() {
        convertOutOfExcelDirectory = new ConvertNumberToWord(NUMBER_WHO_OUT_OF_EXCEL_DIRECTORY, LANGUAGE_RUSSIAN);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            convertOutOfExcelDirectory.createFinalWord();
        });
    }
}