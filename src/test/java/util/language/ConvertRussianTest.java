package util.language;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;
import static util.ConstantData.*;

public class ConvertRussianTest {
    private static StringBuilder actualNumber;
    private static ConvertRussian convertRussian = new ConvertRussian();

    @BeforeEach
    public void createMemoryForTest() {

        actualNumber = new StringBuilder();
    }

    @AfterEach
    public void clearMemoryForTest() {
        convertRussian = null;
        actualNumber = null;
    }

    @Test
    public void compareConvertedThreeAndThreeRussianWord() {
        actualNumber = convertRussian.createOnOtherLanguage(THREE_NUMBER, UNIT_CLASSES);
        assertEquals(THREE_RUSSIAN_WORD, actualNumber.toString());
    }

    @Test
    public void compareConvertedOneHundredTwentyThreeAndOneHundredTwentyThreeRussianWord() {
        actualNumber = convertRussian.createOnOtherLanguage(ONE_HUNDRED_TWENTY_THREE_NUMBER, UNIT_CLASSES);
        assertEquals(ONE_HUNDRED_TWENTY_THREE_RUSSIAN_WORD, actualNumber.toString());
    }

    @Test
    public void compareConvertedOneHundredTwentyThreeThousandAndOneHundredTwentyThreeThousandRussianWord() {
        actualNumber = convertRussian.createOnOtherLanguage(ONE_HUNDRED_TWENTY_THREE_NUMBER, THOUSAND_CLASSES);
        assertEquals(ONE_HUNDRED_TWENTY_THREE_THOUSAND_RUSSIAN_WORD, actualNumber.toString());
    }

    @Test
    public void compareConvertedOneHundredAndOneHundredRussianWord() {
        actualNumber = convertRussian.createOnOtherLanguage(ONE_HUNDRED_NUMBER, UNIT_CLASSES);
        assertEquals(ONE_HUNDRED_WITH_SPACE_RUSSIAN_WORD, actualNumber.toString());
    }

    @Test
    public void checkNumberFormatExceptionInRussianConverter() {
        assertThrows(NumberFormatException.class, () -> {
            convertRussian.createOnOtherLanguage(NOT_NUMBER_FORMAT, UNIT_CLASSES);
        });
    }
}