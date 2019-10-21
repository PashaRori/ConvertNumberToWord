package model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static util.ConstantData.*;

class ConvertNumberToRussianWordTest {
    private static ConvertNumberToWord convertedOneHundred;
    private static ConvertNumberToWord convertedTen;
    private static ConvertNumberToWord convertOneHundredWithZerosAtBegin;
    private static ConvertNumberToWord convertOneMillionOne;
    private static ConvertNumberToWord convertNullReceived;
    private static ConvertNumberToWord convertTextReceived;
    private static ConvertNumberToWord convertOutOfExcelDirectory;
    private static ConvertNumberToWord convertedOneThousand;
    private static ConvertNumberToWord convertedTwoThousand;
    private static ConvertNumberToWord convertedThreeThousand;
    private static ConvertNumberToWord convertedSixThousand;
    private static ConvertNumberToWord convertedThirteenThousand;

    @BeforeAll
    public static void createMemoryToClass() {
        convertedOneHundred = new ConvertNumberToWord(ONE_HUNDRED_NUMBER, LANGUAGE_RUSSIAN);
        convertedTen = new ConvertNumberToWord(TEN_NUMBER, LANGUAGE_RUSSIAN);
        convertOneHundredWithZerosAtBegin = new ConvertNumberToWord(ONE_HUNDRED_WITH_ZEROS_AT_BEGIN, LANGUAGE_RUSSIAN);
        convertOneMillionOne = new ConvertNumberToWord(ONE_MILLION_ONE_NUMBER, LANGUAGE_RUSSIAN);
        convertedOneThousand = new ConvertNumberToWord(ONE_THOUSAND_NUMBER, LANGUAGE_RUSSIAN);
        convertedTwoThousand = new ConvertNumberToWord(TWO_THOUSAND_NUMBER, LANGUAGE_RUSSIAN);
        convertedThreeThousand = new ConvertNumberToWord(THREE_THOUSAND_NUMBER, LANGUAGE_RUSSIAN);
        convertedSixThousand = new ConvertNumberToWord(SIX_THOUSAND_NUMBER, LANGUAGE_RUSSIAN);
        convertedThirteenThousand = new ConvertNumberToWord(THIRTEEN_THOUSAND_NUMBER, LANGUAGE_RUSSIAN);
    }

    @Test
    public void compareConvertedOneHundredAndOneHundredTheWord() {
        assertEquals(ONE_HUNDRED_RUSSIAN_WORD, convertedOneHundred.createFinalWord());
    }

    @Test
    public void compareConvertedTendAndOneHundredTheWord() {
        assertNotEquals(ONE_HUNDRED_RUSSIAN_WORD, convertedTen.createFinalWord());
    }

    @Test
    public void compareConvertedOneHundredWithZeroSignsAndOneHundredTheWord() {
        assertEquals(ONE_HUNDRED_RUSSIAN_WORD, convertOneHundredWithZerosAtBegin.createFinalWord());
    }

    @Test
    public void compareConvertedOneMillionOneAndOneMillionOneTheWord() {
        assertEquals(ONE_MILLION_ONE_RUSSIAN_WORD, convertOneMillionOne.createFinalWord());
    }

    @Test
    public void compareConvertedOneThousandAndOneThousandTheWord() {
        assertEquals(ONE_THOUSAND_RUSSIAN_WORD, convertedOneThousand.createFinalWord());
    }

    @Test
    public void compareConvertedTwoThousandAndTwoThousandTheWord() {
        assertEquals(TWO_THOUSAND_RUSSIAN_WORD, convertedTwoThousand.createFinalWord());
    }

    @Test
    public void compareConvertedThreeThousandAndThreeThousandTheWord() {
        assertEquals(THREE_THOUSAND_RUSSIAN_WORD, convertedThreeThousand.createFinalWord());
    }

    @Test
    public void compareConvertedSixThousandAndSixThousandTheWord() {
        assertEquals(SIX_THOUSAND_RUSSIAN_WORD, convertedSixThousand.createFinalWord());
    }

    @Test
    public void compareConvertedThirteenThousandAndThirteenThousandTheWord() {
        assertEquals(THIRTEEN_THOUSAND_RUSSIAN_WORD, convertedThirteenThousand.createFinalWord());
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
    public void checkIndexOutOfBoundsExceptionWithNumberOutedOfBoundsExcel() {
        convertOutOfExcelDirectory = new ConvertNumberToWord(NUMBER_WHO_OUT_OF_EXCEL_DIRECTORY, LANGUAGE_RUSSIAN);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            convertOutOfExcelDirectory.createFinalWord();
        });
    }
}