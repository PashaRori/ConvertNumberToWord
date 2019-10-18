package util;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static util.FinalData.*;
import static util.TextDataParsing.*;

class TextDataParsingTest {

    @Test
    public void compareConvertedArrayZeroToOneHundredAndArrayZeroToOneHundredRussianWord() {
        assertEquals(RussianArrayZeroToOneHundred, getArrayZeroToOneHundred(LANGUAGE_RUSSIAN));
    }

    @Test
    public void compareConvertedArrayZeroToOneHundredAndNotFullArrayZeroToOneHundredRussianWord() {
        Assert.assertNotEquals(RUSSIAN_DIFFERENCE_ARRAY_ZERO_TO_ONE_HUNDRED, getArrayZeroToOneHundred(LANGUAGE_RUSSIAN));
    }

    @Test
    public void compareConvertedArrayneZeroToOneHundredAndArrayZeroToOneHundredEnglishWord() {
        assertEquals(EnglishArrayZeroToOneHundred, getArrayZeroToOneHundred(LANGUAGE_ENGLISH));
    }

    @Test
    public void compareConvertedArrayneZeroToOneHundredAndNotFullArrayZeroToOneHundredEnglishWord() {
        Assert.assertNotEquals(ENGLISH_DIFFERENCE_ARRAY_ZERO_TO_ONE_HUNDRED, getArrayZeroToOneHundred(LANGUAGE_ENGLISH));
    }

    @Test
    public void checkAssertionErrorFromArrayZeroToOneHundred() {
        assertThrows(AssertionError.class, () -> {
            getArrayZeroToOneHundred(NULL);
        });
    }

    @Test
    public void compareConvertedArrayneHundredToOneThousandAndArrayHundredToOneThousandRussianWord() {
        assertEquals(RUSSIAN_ONE_HUNDRED_TO_ONE_THOUSAND, getArrayOneHundredToOneThousand(LANGUAGE_RUSSIAN));
    }

    @Test
    public void compareConvertedArrayneHundredToOneThousandAndNotFullArrayHundredToOneThousandRussianWord() {
        assertNotEquals(RUSSIAN_DIFFERENCE_ONE_HUNDRED_TO_ONE_THOUSAND, getArrayOneHundredToOneThousand(LANGUAGE_RUSSIAN));
    }


    @Test
    public void compareConvertedArrayneHundredToOneThousandAndArrayHundredToOneThousandEnglishWord() {
        assertEquals(ENGLISH_ONE_HUNDRED_TO_ONE_THOUSAND, getArrayOneHundredToOneThousand(LANGUAGE_ENGLISH));
    }

    @Test
    public void compareConvertedArrayneHundredToOneThousandAndNotFullArrayHundredToOneThousandEnglishWord() {
        assertNotEquals(ENGLISH_DIFFERENCE_ONE_HUNDRED_TO_ONE_THOUSAND, getArrayOneHundredToOneThousand(LANGUAGE_ENGLISH));
    }

    @Test
    public void checkAssertionErrorFromArrayOneHundredToOneThousand() {
        assertThrows(AssertionError.class, () -> {
            getArrayOneHundredToOneThousand(NULL);
        });
    }

    @Test
    public void compareConvertedArrayOneThousandToMaximumAvailableNumberAndArrayOneThousandToMaximumAvailableNumberRussianWord() {
        assertEquals(RUSSIAN_ONE_THOUSAND_TO_MAXIMUM_AVAILABLE_NUMBER, getArrayOneThousandToMaximumAvailableNumber(LANGUAGE_RUSSIAN));
    }

    @Test
    public void compareConvertedArrayOneThousandToMaximumAvailableNumberAndNotFullArrayOneThousandToMaximumAvailableNumberRussianWord() {
        Assert.assertNotEquals(RUSSIAN_DIFFERENCE_ONE_THOUSAND_TO_MAXIMUM_AVAILABLE_NUMBER, getArrayOneThousandToMaximumAvailableNumber(LANGUAGE_RUSSIAN));
    }

    @Test
    public void compareConvertedArrayOneThousandToMaximumAvailableNumberAndArrayOneThousandToMaximumAvailableNumberEnglishWord() {
        assertEquals(ENGLISH_ONE_THOUSAND_TO_MAXIMUM_AVAILABLE_NUMBER, getArrayOneThousandToMaximumAvailableNumber(LANGUAGE_ENGLISH));
    }

    @Test
    public void compareConvertedArrayOneThousandToMaximumAvailableNumberAndNotFullArrayOneThousandToMaximumAvailableNumberEnglishWord() {
        Assert.assertNotEquals(ENGLISH_DIFFERENCE_ONE_THOUSAND_TO_MAXIMUM_AVAILABLE_NUMBER, getArrayOneThousandToMaximumAvailableNumber(LANGUAGE_ENGLISH));
    }

    @Test
    public void checkAssertionErrorFromArrayOneThousandToMaximumAvailableNumber() {
        assertThrows(AssertionError.class, () -> {
            getArrayOneThousandToMaximumAvailableNumber(NULL);
        });
    }
}