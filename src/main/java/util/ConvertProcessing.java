package util;

import java.util.List;

import static util.ConstantData.*;

public abstract class ConvertProcessing {
    public static int hundredOfNumber;
    public static int dozenOfNumber;
    public static int unitOfNumber;
    public static String hundredFromWords;
    public static String dozenFromWords;

    public ConvertProcessing() {}

    public static void getNumberAndWordFromSegment(String receivedSegment, String languageConvert) {
        int numberSegment = Integer.parseInt(receivedSegment);
        hundredOfNumber = numberSegment / 100;
        hundredFromWords = getHundred(languageConvert);
        dozenOfNumber = numberSegment % 100;
        dozenFromWords = getDozen(languageConvert);
        unitOfNumber = numberSegment % 10;
    }

    public abstract StringBuilder createOnOtherLanguage(String receivedSegment, int quantityOfNumberClasses, String languageConvert);

    private static String getHundred(String languageConvert) {
        final List<String> arrayFromOneHundredToNineHundred = TextDataParsing.getArrayOneHundredToOneThousand(languageConvert);
        return ((hundredOfNumber == 0) ? "" : SPACE + arrayFromOneHundredToNineHundred.get(hundredOfNumber - 1));
    }

    private static String getDozen(String languageConvert) {
        final List<String>  arrayFromZeroToOneHundred = TextDataParsing.getArrayZeroToOneHundred(languageConvert);
        return ((hundredOfNumber > 0 && dozenOfNumber == 0) ? EMPTY : SPACE + arrayFromZeroToOneHundred.get(dozenOfNumber));
    }
}
