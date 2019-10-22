package util.language;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.Test;

import static org.testng.Assert.*;
import static util.ConstantData.*;

public class ConvertEnglishTest {
    private static StringBuilder actualNumber;
    private static ConvertRussian convertEnglish = new ConvertRussian();

    @BeforeEach
    public void createMemoryForTest() {
        actualNumber = new StringBuilder();
    }

    @AfterEach
    public void clearMemoryForTest() {
        actualNumber = null;
    }

    @Test
    public void compareConvertedThreeAndThreeEnglishWord() {
        actualNumber = convertEnglish.createOnOtherLanguage(THREE_NUMBER, UNIT_CLASSES);
        assertEquals(THREE_ENGLISH_WORD, actualNumber.toString());
    }

    @Test
    public void compareConvertedOneHundredTwentyThreeAndOneHundredTwentyThreeEnglishWord() {
        actualNumber = convertEnglish.createOnOtherLanguage(ONE_HUNDRED_TWENTY_THREE_NUMBER, UNIT_CLASSES);
        assertEquals(ONE_HUNDRED_TWENTY_THREE_ENGLISH_WORD, actualNumber.toString());
    }

    @Test
    public void compareConvertedOneHundredTwentyThreeThousandAndOneHundredTwentyThreeThousandEnglishWord() {
        actualNumber = convertEnglish.createOnOtherLanguage(ONE_HUNDRED_TWENTY_THREE_NUMBER, THOUSAND_CLASSES);
        assertEquals(ONE_HUNDRED_TWENTY_THREE_THOUSAND_ENGLISH_WORD, actualNumber.toString());
    }

    @Test
    public void compareConvertedOneHundredAndOneHundredEnglishWord() {
        actualNumber = convertEnglish.createOnOtherLanguage(ONE_HUNDRED_NUMBER, UNIT_CLASSES);
        assertEquals(ONE_HUNDRED_WITH_SPACE_ENGLISH_WORD, actualNumber.toString());
    }

    @Test
    public void checkNullPointerExceptionExplosionInEnglishConverter() {
        assertThrows(NullPointerException.class, () -> {
            convertEnglish.createOnOtherLanguage(ONE_HUNDRED_TWENTY_THREE_NUMBER, UNIT_CLASSES);
        });
    }

    @Test
    public void checkNumberFormatExceptionInEnglishConverter() {
        assertThrows(NumberFormatException.class, () -> {
            convertEnglish.createOnOtherLanguage(NOT_NUMBER_FORMAT, UNIT_CLASSES);
        });
    }
}