package util;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static util.FinalData.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static util.TextDataParsing.*;

class TextDataParsingTest {

    @Test
    public void compareConvertedArrayZeroToOneHundredAndArrayZeroToOneHundredRussianWord() {
        Assert.assertArrayEquals(RussianArrayZeroToOneHundred, getArrayZeroToOneHundred(LANGUAGE_RUSSIAN));
    }

    @Test
    public void compareConvertedArrayZeroToOneHundredAndNotFullArrayZeroToOneHundredRussianWord() {
        Assert.assertNotEquals(RussianDifferenceArrayZeroToOneHundred, getArrayZeroToOneHundred(LANGUAGE_RUSSIAN));
    }

    @Test
    public void compareConvertedArrayneZeroToOneHundredAndArrayZeroToOneHundredEnglishWord() {
        Assert.assertArrayEquals(EnglishArrayZeroToOneHundred, getArrayZeroToOneHundred(LANGUAGE_ENGLISH));
    }

    @Test
    public void compareConvertedArrayneZeroToOneHundredAndNotFullArrayZeroToOneHundredEnglishWord() {
        Assert.assertNotEquals(EnglishDifferenceArrayZeroToOneHundred, getArrayZeroToOneHundred(LANGUAGE_ENGLISH));
    }

    @Test
    public void checkAssertionErrorFromArrayZeroToOneHundred() {
        assertThrows(AssertionError.class, () -> {
            getArrayZeroToOneHundred(NULL);
        });
    }

    @Test
    public void compareConvertedArrayneHundredToOneThousandAndArrayHundredToOneThousandRussianWord() {
        Assert.assertArrayEquals(RussianOneHundredToOneThousand, getArrayOneHundredToOneThousand(LANGUAGE_RUSSIAN));
    }

    @Test
    public void compareConvertedArrayneHundredToOneThousandAndNotFullArrayHundredToOneThousandRussianWord() {
        assertNotEquals(RussianDifferenceOneHundredToOneThousand, getArrayOneHundredToOneThousand(LANGUAGE_RUSSIAN));
    }


    @Test
    public void compareConvertedArrayneHundredToOneThousandAndArrayHundredToOneThousandEnglishWord() {
        Assert.assertArrayEquals(EnglishOneHundredToOneThousand, getArrayOneHundredToOneThousand(LANGUAGE_ENGLISH));
    }

    @Test
    public void compareConvertedArrayneHundredToOneThousandAndNotFullArrayHundredToOneThousandEnglishWord() {
        assertNotEquals(EnglishDifferenceOneHundredToOneThousand, getArrayOneHundredToOneThousand(LANGUAGE_ENGLISH));
    }

    @Test
    public void checkAssertionErrorFromArrayOneHundredToOneThousand() {
        assertThrows(AssertionError.class, () -> {
            getArrayOneHundredToOneThousand(NULL);
        });
    }

    @Test
    public void compareConvertedArrayOneThousandToMaximumAvailableNumberAndArrayOneThousandToMaximumAvailableNumberRussianWord() {
        Assert.assertArrayEquals(RussianOneThousandToMaximumAvailableNumber, getArrayOneThousandToMaximumAvailableNumber(LANGUAGE_RUSSIAN));
    }

    @Test
    public void compareConvertedArrayOneThousandToMaximumAvailableNumberAndNotFullArrayOneThousandToMaximumAvailableNumberRussianWord() {
        Assert.assertNotEquals(RussianDifferenceOneThousandToMaximumAvailableNumber, getArrayOneThousandToMaximumAvailableNumber(LANGUAGE_RUSSIAN));
    }

    @Test
    public void compareConvertedArrayOneThousandToMaximumAvailableNumberAndArrayOneThousandToMaximumAvailableNumberEnglishWord() {
        Assert.assertArrayEquals(EnglishOneThousandToMaximumAvailableNumber, getArrayOneThousandToMaximumAvailableNumber(LANGUAGE_ENGLISH));
    }

    @Test
    public void compareConvertedArrayOneThousandToMaximumAvailableNumberAndNotFullArrayOneThousandToMaximumAvailableNumberEnglishWord() {
        Assert.assertNotEquals(EnglishDifferenceOneThousandToMaximumAvailableNumber, getArrayOneThousandToMaximumAvailableNumber(LANGUAGE_ENGLISH));
    }

    @Test
    public void checkAssertionErrorFromArrayOneThousandToMaximumAvailableNumber() {
        assertThrows(AssertionError.class, () -> {
            getArrayOneThousandToMaximumAvailableNumber(NULL);
        });
    }
}