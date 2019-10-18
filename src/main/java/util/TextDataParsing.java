package util;

import java.util.ArrayList;
import java.util.List;

import static util.ExcelOpen.getArrayWithValues;

public class TextDataParsing {

    private TextDataParsing() {
    }

    private static List<String> getArrayZeroToTen(String languageConvert) {
        final List<String> arrayFromZeroToTen = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arrayFromZeroToTen.add(i, String.valueOf(getArrayWithValues(languageConvert).get(i)));
        }
        return arrayFromZeroToTen;
    }

    private static List<String> getArrayZeroToTwenty(String languageConvert) {
        final List<String> arrayFromZeroToTwenty = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            arrayFromZeroToTwenty.add(i, String.valueOf(getArrayWithValues(languageConvert).get(i)));
        }
        return arrayFromZeroToTwenty;
    }

    private static List<String> getArrayTwentyToNinety(String languageConvert) {
        final List<String> arrayFromTwentyToNinety = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            arrayFromTwentyToNinety.add(i, String.valueOf(getArrayWithValues(languageConvert).get(20 + i)));
        }
        return arrayFromTwentyToNinety;
    }

    public static List<String> getArrayZeroToOneHundred(String languageConvert) {
        List<String> arrayFromZeroToOneHundred = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            if (i < 20) {
                arrayFromZeroToOneHundred.add(i, String.valueOf(getArrayZeroToTwenty(languageConvert).get(i)));
            } else {
                if (i % 10 == 0) {
                    arrayFromZeroToOneHundred.add(i, String.valueOf(getArrayTwentyToNinety(languageConvert).get((i / 10) - 2)));
                } else {
                    arrayFromZeroToOneHundred.add(i, (getArrayTwentyToNinety(languageConvert).get((i / 10) - 2) + " " + getArrayZeroToTen(languageConvert).get(i % 10)));
                }
            }
        }
        return arrayFromZeroToOneHundred;
    }

    public static List<String> getArrayOneHundredToOneThousand(String languageConvert) {
        final List<String> arrayFromOneHundredToNineHundred = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            arrayFromOneHundredToNineHundred.add(i, String.valueOf(getArrayWithValues(languageConvert).get(28 + i)));
        }
        return arrayFromOneHundredToNineHundred;
    }

    public static List<String> getArrayOneThousandToMaximumAvailableNumber(String languageConvert) {
        final List<String> arrayFromExcelFile = getArrayWithValues(languageConvert);
        int sizeQuantityRowExcelFile = arrayFromExcelFile.size();
        final List<String> arrayFromOneThousandToMaximumAvailableNumber = new ArrayList<>();
        for (int i = 0; i < sizeQuantityRowExcelFile - 37; i++) {
            arrayFromOneThousandToMaximumAvailableNumber.add(i, String.valueOf(getArrayWithValues(languageConvert).get(37 + i)));
        }
        return arrayFromOneThousandToMaximumAvailableNumber;
    }
}
