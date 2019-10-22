package util.language;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.Test;

import static org.testng.Assert.*;
import static util.ConstantData.*;

public class ConvertRussianTest {
    private static StringBuilder actualNumber;
    private static ConvertRussian convertRussian;

    @BeforeAll
    public static void createMemoryClass() {
        convertRussian = new ConvertRussian();
    }

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
        actualNumber = convertRussian.createOnOtherLanguage(ONE_HUNDRED_TWENTY_THREE_NUMBER, UNIT_CLASSES, LANGUAGE_RUSSIAN);
        assertEquals(ONE_HUNDRED_TWENTY_THREE_RUSSIAN_WORD, actualNumber.toString());
    }

    @Test
    public void compareConvertedOneHundredTwentyThreeThousandAndOneHundredTwentyThreeThousandRussianWord() {
        actualNumber = convertRussian.createOnOtherLanguage(ONE_HUNDRED_TWENTY_THREE_NUMBER, THOUSAND_CLASSES, LANGUAGE_RUSSIAN);
        assertEquals(ONE_HUNDRED_TWENTY_THREE_THOUSAND_RUSSIAN_WORD, actualNumber.toString());
    }

    @Test
    public void compareConvertedOneHundredAndOneHundredRussianWord() {
        actualNumber = convertRussian.createOnOtherLanguage(ONE_HUNDRED_NUMBER, UNIT_CLASSES, LANGUAGE_RUSSIAN);
        assertEquals(ONE_HUNDRED_WITH_SPACE_RUSSIAN_WORD, actualNumber.toString());
    }

    @Test
    public void checkNullPointerExceptionExplosionInRussianConverter() {
        assertThrows(NullPointerException.class, () -> {
            convertRussian.createOnOtherLanguage(ONE_HUNDRED_TWENTY_THREE_NUMBER, UNIT_CLASSES, NULL);
        });
    }

    @Test
    public void checkNumberFormatExceptionInRussianConverter() {
        assertThrows(NumberFormatException.class, () -> {
            convertRussian.createOnOtherLanguage(NOT_NUMBER_FORMAT, UNIT_CLASSES, LANGUAGE_RUSSIAN);
        });
    }
}