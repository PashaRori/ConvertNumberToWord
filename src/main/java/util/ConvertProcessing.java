package util;

import java.util.List;

import static util.ConstantData.*;

public abstract class ConvertProcessing {
    protected static int hundredOfNumber;
    protected static int dozenOfNumber;
    protected static int unitOfNumber;
    protected static String hundredFromWords;
    protected static String dozenFromWords;

    protected ConvertProcessing() {}

    public static void getNumberAndWordFromSegment(String receivedSegment, String languageConvert) {
        int numberSegment = Integer.parseInt(receivedSegment);
        hundredOfNumber = numberSegment / 100;
        hundredFromWords = getHundred(languageConvert);
        dozenOfNumber = numberSegment % 100;
        dozenFromWords = getDozen(languageConvert);
        unitOfNumber = numberSegment % 10;
    }

    public abstract StringBuilder createOnOtherLanguage(String receivedSegment, int quantityOfNumberClasses);

    private static String getHundred(String languageConvert) {
        final List<String> arrayFromOneHundredToNineHundred = TextDataParsing.getArrayOneHundredToOneThousand(languageConvert);
        return ((hundredOfNumber == 0) ? "" : SPACE + arrayFromOneHundredToNineHundred.get(hundredOfNumber - 1));
    }

    private static String getDozen(String languageConvert) {
        final List<String>  arrayFromZeroToOneHundred = TextDataParsing.getArrayZeroToOneHundred(languageConvert);
        return ((hundredOfNumber > 0 && dozenOfNumber == 0) ? EMPTY : SPACE + arrayFromZeroToOneHundred.get(dozenOfNumber));
    }
}
