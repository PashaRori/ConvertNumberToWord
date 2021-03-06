package util.language;

import util.ConvertProcessing;
import util.TextDataParsing;

import java.util.List;

import static util.ConstantData.*;

public class ConvertEnglish extends ConvertProcessing {

    public ConvertEnglish(){
        //default constructor
    }

    @Override
    public StringBuilder createOnOtherLanguage(String receivedSegment, int quantityOfNumberClasses) {
        StringBuilder resultCreateWord = new StringBuilder();

        getNumberAndWordFromSegment(receivedSegment, LANGUAGE_ENGLISH);

        if (quantityOfNumberClasses == 0 && !receivedSegment.equals(ZEROS)) {
            resultCreateWord.append(getHundredEndingOnEnglish(quantityOfNumberClasses));
        }
        if ((hundredOfNumber != 0 || dozenOfNumber != 0) && quantityOfNumberClasses > 0) {
            resultCreateWord.append(getBillionsClassesEndingOnEnglish(quantityOfNumberClasses));
        }
        return resultCreateWord;
    }

    private static StringBuilder getHundredEndingOnEnglish(int sizeInputNumber) {
        StringBuilder hundredEnding = new StringBuilder();

        if (hundredOfNumber == 0 && dozenOfNumber == 0) {
            if (sizeInputNumber == 0) {
                hundredEnding.append(hundredFromWords).append(dozenFromWords);
            }
        } else {
            if (dozenOfNumber != 0) {
                hundredEnding.append(hundredFromWords).append(AND).append(dozenFromWords);
            } else {
                hundredEnding.append(hundredFromWords).append(dozenFromWords);
            }
        }
        return hundredEnding;
    }

    private static StringBuilder getBillionsClassesEndingOnEnglish(int quantityOfNumberClasses) {
        StringBuilder exponentialNumberEnding = new StringBuilder();
        final List<String> arrayFromOneThousandToMaximumAvailableNumber = TextDataParsing.getArrayOneThousandToMaximumAvailableNumber(LANGUAGE_ENGLISH);
        exponentialNumberEnding.append(hundredFromWords).append(dozenFromWords).append(SPACE)
                .append(arrayFromOneThousandToMaximumAvailableNumber.get(quantityOfNumberClasses - 1));
        return exponentialNumberEnding;
    }
}
