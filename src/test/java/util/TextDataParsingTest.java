package util;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static util.ConstantData.*;
import static util.TextDataParsing.*;

class TextDataParsingTest {
    private static final List<String> RUSSIAN_DIFFERENCE_ARRAY_ZERO_TO_ONE_HUNDRED = Arrays.asList("ноль", "один", "два", "три");
    private static final List<String> ENGLISH_DIFFERENCE_ARRAY_ZERO_TO_ONE_HUNDRED = Arrays.asList("zero", "one", "two", "three");
    private static final List<String> RUSSIAN_DIFFERENCE_ONE_HUNDRED_TO_ONE_THOUSAND = Arrays.asList("сто", "двести");
    private static final List<String> RUSSIAN_ONE_HUNDRED_TO_ONE_THOUSAND = Arrays.asList("сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот");
    private static final List<String> ENGLISH_DIFFERENCE_ONE_HUNDRED_TO_ONE_THOUSAND = Arrays.asList("one hundred", "two hundred", "three hundred");
    private static final List<String> RUSSIAN_DIFFERENCE_ONE_THOUSAND_TO_MAXIMUM_AVAILABLE_NUMBER = Arrays.asList("тысяч", "миллион", "миллиард");
    private static final List<String> ENGLISH_DIFFERENCE_ONE_THOUSAND_TO_MAXIMUM_AVAILABLE_NUMBER = Arrays.asList("thousand", "million", "billion", "trillion");
    private static final List<String> ENGLISH_ONE_HUNDRED_TO_ONE_THOUSAND = Arrays.asList("one hundred", "two hundred", "three hundred", "four hundred", "five hundred", "six hundred", "seven hundred", "eight hundred", "nine hundred");
    private static final List<String> RUSSIAN_ONE_THOUSAND_TO_MAXIMUM_AVAILABLE_NUMBER = Arrays.asList("тысяч", "миллион", "миллиард", "триллион", "квадриллион", "квинтиллион", "секстиллион", "септиллион", "октиллион", "нониллион", "дециллион", "андециллион", "дуодециллион", "тридециллион", "квадридециллион", "квинтидециллион", "секстидециллион", "септидециллион", "октидециллион", "нонидециллион", "децидециллион");
    private static final List<String> ENGLISH_ONE_THOUSAND_TO_MAXIMUM_AVAILABLE_NUMBER = Arrays.asList("thousand", "million", "billion", "trillion", "quadrillion", "quintillion", "sextillion", "septillion", "octillion", "quintillion", "decillion", "andecillion", "duodecillion", "tridecillion", "quadrillion", "quintidecillion", "sextidecillion", "septidecillion", "octidecillion", "nonidecillion", "decidecillion");
    private static final List<String> RussianArrayZeroToOneHundred = Arrays.asList("ноль", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять", "десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать", "двадцать", "двадцать один", "двадцать два", "двадцать три", "двадцать четыре", "двадцать пять", "двадцать шесть", "двадцать семь", "двадцать восемь", "двадцать девять", "тридцать", "тридцать один", "тридцать два", "тридцать три", "тридцать четыре", "тридцать пять", "тридцать шесть", "тридцать семь", "тридцать восемь", "тридцать девять", "сорок", "сорок один", "сорок два", "сорок три", "сорок четыре", "сорок пять", "сорок шесть", "сорок семь", "сорок восемь", "сорок девять", "пятьдесят", "пятьдесят один", "пятьдесят два", "пятьдесят три", "пятьдесят четыре", "пятьдесят пять", "пятьдесят шесть", "пятьдесят семь", "пятьдесят восемь", "пятьдесят девять", "шестьдесят", "шестьдесят один", "шестьдесят два", "шестьдесят три", "шестьдесят четыре", "шестьдесят пять", "шестьдесят шесть", "шестьдесят семь", "шестьдесят восемь", "шестьдесят девять", "семьдесят", "семьдесят один", "семьдесят два", "семьдесят три", "семьдесят четыре", "семьдесят пять", "семьдесят шесть", "семьдесят семь", "семьдесят восемь", "семьдесят девять", "восемьдесят", "восемьдесят один", "восемьдесят два", "восемьдесят три", "восемьдесят четыре", "восемьдесят пять", "восемьдесят шесть", "восемьдесят семь", "восемьдесят восемь", "восемьдесят девять", "девяноста", "девяноста один", "девяноста два", "девяноста три", "девяноста четыре", "девяноста пять", "девяноста шесть", "девяноста семь", "девяноста восемь", "девяноста девять");
    private static final List<String> EnglishArrayZeroToOneHundred = Arrays.asList("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty", "twenty one", "twenty two", "twenty three", "twenty four", "twenty five", "twenty six", "twenty seven", "twenty eight", "twenty nine", "thirty", "thirty one", "thirty two", "thirty three", "thirty four", "thirty five", "thirty six", "thirty seven", "thirty eight", "thirty nine", "forty", "forty one", "forty two", "forty three", "forty four", "forty five", "forty six", "forty seven", "forty eight", "forty nine", "fifty", "fifty one", "fifty two", "fifty three", "fifty four", "fifty five", "fifty six", "fifty seven", "fifty eight", "fifty nine", "sixty", "sixty one", "sixty two", "sixty three", "sixty four", "sixty five", "sixty six", "sixty seven", "sixty eight", "sixty nine", "seventy", "seventy one", "seventy two", "seventy three", "seventy four", "seventy five", "seventy six", "seventy seven", "seventy eight", "seventy nine", "eighty", "eighty one", "eighty two", "eighty three", "eighty four", "eighty five", "eighty six", "eighty seven", "eighty eight", "eighty nine", "ninety", "ninety one", "ninety two", "ninety three", "ninety four", "ninety five", "ninety six", "ninety seven", "ninety eight", "ninety nine");

    @Test
    public void compareConvertedArrayZeroToOneHundredAndArrayZeroToOneHundredRussianWord() {
        assertEquals(RussianArrayZeroToOneHundred, getArrayZeroToOneHundred(LANGUAGE_RUSSIAN));
    }

    @Test
    public void compareConvertedArrayZeroToOneHundredAndNotFullArrayZeroToOneHundredRussianWord() {
        Assert.assertNotEquals(RUSSIAN_DIFFERENCE_ARRAY_ZERO_TO_ONE_HUNDRED, getArrayZeroToOneHundred(LANGUAGE_RUSSIAN));
    }

    @Test
    public void compareConvertedArrayZeroToOneHundredAndArrayZeroToOneHundredEnglishWord() {
        assertEquals(EnglishArrayZeroToOneHundred, getArrayZeroToOneHundred(LANGUAGE_ENGLISH));
    }

    @Test
    public void compareConvertedArrayZeroToOneHundredAndNotFullArrayZeroToOneHundredEnglishWord() {
        Assert.assertNotEquals(ENGLISH_DIFFERENCE_ARRAY_ZERO_TO_ONE_HUNDRED, getArrayZeroToOneHundred(LANGUAGE_ENGLISH));
    }

    @Test
    public void checkNullPointerExceptionFromArrayZeroToOneHundred() {
        assertThrows(NullPointerException.class, () -> {
            getArrayZeroToOneHundred(NULL);
        });
    }

    @Test
    public void compareConvertedArrayHundredToOneThousandAndArrayHundredToOneThousandRussianWord() {
        assertEquals(RUSSIAN_ONE_HUNDRED_TO_ONE_THOUSAND, getArrayOneHundredToOneThousand(LANGUAGE_RUSSIAN));
    }

    @Test
    public void compareConvertedArrayHundredToOneThousandAndNotFullArrayHundredToOneThousandRussianWord() {
        assertNotEquals(RUSSIAN_DIFFERENCE_ONE_HUNDRED_TO_ONE_THOUSAND, getArrayOneHundredToOneThousand(LANGUAGE_RUSSIAN));
    }


    @Test
    public void compareConvertedArrayHundredToOneThousandAndArrayHundredToOneThousandEnglishWord() {
        assertEquals(ENGLISH_ONE_HUNDRED_TO_ONE_THOUSAND, getArrayOneHundredToOneThousand(LANGUAGE_ENGLISH));
    }

    @Test
    public void compareConvertedArrayHundredToOneThousandAndNotFullArrayHundredToOneThousandEnglishWord() {
        assertNotEquals(ENGLISH_DIFFERENCE_ONE_HUNDRED_TO_ONE_THOUSAND, getArrayOneHundredToOneThousand(LANGUAGE_ENGLISH));
    }

    @Test
    public void checkNullPointerExceptionFromArrayOneHundredToOneThousand() {
        assertThrows(NullPointerException.class, () -> {
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
    public void checkNullPointerExceptionFromArrayOneThousandToMaximumAvailableNumber() {
        assertThrows(NullPointerException.class, () -> {
            getArrayOneThousandToMaximumAvailableNumber(NULL);
        });
    }
}