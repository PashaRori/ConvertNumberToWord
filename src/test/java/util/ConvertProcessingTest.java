package util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static util.ConstantData.*;
import static org.junit.jupiter.api.Assertions.*;

class ConvertProcessingTest {
    private static StringBuilder actualNumber;

    @BeforeEach
    public void createMemoryForTest() {
        actualNumber = new StringBuilder();
    }

    @AfterEach
    public void clearMemoryForTest() {
        actualNumber = null;
    }

    @Test
    public void compareConvertedOneHundredTwentyThreeAndOneHundredTwentyThreeRussianWord() {
        actualNumber = ConvertProcessing.createOnRussian(ONE_HUNDRED_TWENTY_THREE_NUMBER, UNIT_CLASSES, LANGUAGE_RUSSIAN);
        assertEquals(ONE_HUNDRED_TWENTY_THREE_RUSSIAN_WORD, actualNumber.toString());
    }

    @Test
    public void compareConvertedOneHundredTwentyThreeThousandAndOneHundredTwentyThreeThousandRussianWord() {
        actualNumber = ConvertProcessing.createOnRussian(ONE_HUNDRED_TWENTY_THREE_NUMBER, THOUSAND_CLASSES, LANGUAGE_RUSSIAN);
        assertEquals(ONE_HUNDRED_TWENTY_THREE_THOUSAND_RUSSIAN_WORD, actualNumber.toString());
    }

    @Test
    public void compareConvertedOneHundredAndOneHundredRussianWord() {
        actualNumber = ConvertProcessing.createOnRussian(ONE_HUNDRED_NUMBER, UNIT_CLASSES, LANGUAGE_RUSSIAN);
        assertEquals(ONE_HUNDRED_RUSSIAN_WORD, actualNumber.toString());
    }

    @Test
    public void checkNullPointerExceptionExplosionInRussianConverter() {
        assertThrows(NullPointerException.class, () -> {
            ConvertProcessing.createOnRussian(ONE_HUNDRED_TWENTY_THREE_NUMBER, UNIT_CLASSES, NULL);
        });
    }

    @Test
    public void checkNumberFormatExceptionInRussianConverter() {
        assertThrows(NumberFormatException.class, () -> {
            ConvertProcessing.createOnRussian(NOT_NUMBER_FORMAT, UNIT_CLASSES, LANGUAGE_RUSSIAN);
        });
    }

    @Test
    public void compareConvertedOneHundredTwentyThreeAndOneHundredTwentyThreeEnglishWord() {
        actualNumber = ConvertProcessing.createOnEnglish(ONE_HUNDRED_TWENTY_THREE_NUMBER, UNIT_CLASSES, LANGUAGE_ENGLISH);
        assertEquals(ONE_HUNDRED_TWENTY_THREE_ENGLISH_WORD, actualNumber.toString());
    }

    @Test
    public void compareConvertedOneHundredTwentyThreeThousandAndOneHundredTwentyThreeThousandEnglishWord() {
        actualNumber = ConvertProcessing.createOnEnglish(ONE_HUNDRED_TWENTY_THREE_NUMBER, THOUSAND_CLASSES, LANGUAGE_ENGLISH);
        assertEquals(ONE_HUNDRED_TWENTY_THREE_THOUSAND_ENGLISH_WORD, actualNumber.toString());
    }

    @Test
    public void compareConvertedOneHundredAndOneHundredEnglishWord() {
        actualNumber = ConvertProcessing.createOnEnglish(ONE_HUNDRED_NUMBER, UNIT_CLASSES, LANGUAGE_ENGLISH);
        assertEquals(ONE_HUNDRED_ENGLISH_WORD, actualNumber.toString());
    }

    @Test
    public void checkNullPointerExceptionExplosionInEnglishConverter() {
        assertThrows(NullPointerException.class, () -> {
            ConvertProcessing.createOnEnglish(ONE_HUNDRED_TWENTY_THREE_NUMBER, UNIT_CLASSES, NULL);
        });
    }

    @Test
    public void checkNumberFormatExceptionInEnglishConverter() {
        assertThrows(NumberFormatException.class, () -> {
            ConvertProcessing.createOnEnglish(NOT_NUMBER_FORMAT, UNIT_CLASSES, LANGUAGE_ENGLISH);
        });
    }
}