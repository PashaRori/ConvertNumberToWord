package util.language;

import util.ConvertProcessing;
import util.TextDataParsing;

import java.util.List;

import static util.ConstantData.*;

public class ConvertRussian extends ConvertProcessing {

    public ConvertRussian(){}

    @Override
    public StringBuilder createOnOtherLanguage(String receivedSegment, int quantityOfNumberClasses, String languageConvert) {
        StringBuilder resultCreateWord = new StringBuilder();

        getNumberAndWordFromSegment(receivedSegment, languageConvert);

        if (quantityOfNumberClasses == 0 && !receivedSegment.equals(ZEROS)) {
            resultCreateWord.append(getHundredEndingOnRussian(quantityOfNumberClasses));
        }
        if ((hundredOfNumber != 0 || dozenOfNumber != 0) && quantityOfNumberClasses > 0) {
            if (quantityOfNumberClasses == 1) {
                resultCreateWord.append(getThousandEndingOnRussian(quantityOfNumberClasses, languageConvert));
            }
            if (quantityOfNumberClasses > 1) {
                resultCreateWord.append(getBillionsClassesNumberEndingOnRussian(quantityOfNumberClasses, languageConvert));
            }
        }
        return resultCreateWord;
    }

    private static StringBuilder getHundredEndingOnRussian(int sizeInputNumber) {
        StringBuilder hundredEnding = new StringBuilder();

        if (hundredOfNumber == 0 && dozenOfNumber == 0) {
            if (sizeInputNumber == 0) {
                hundredEnding.append(hundredFromWords).append(dozenFromWords);
            }
        } else {
            hundredEnding.append(hundredFromWords).append(dozenFromWords);
        }
        return hundredEnding;
    }

    private static StringBuilder getThousandEndingOnRussian(int quantityOfNumberClasses, String languageConvert) {
        StringBuilder thousandEnding = new StringBuilder();
        final List<String> arrayFromOneThousandToMaximumAvailableNumber = TextDataParsing.getArrayOneThousandToMaximumAvailableNumber(languageConvert);
        final String valueFromArray = arrayFromOneThousandToMaximumAvailableNumber.get(quantityOfNumberClasses - 1);

        if (dozenOfNumber > 10 && dozenOfNumber < 20) {
            thousandEnding.append(hundredFromWords).append(dozenFromWords).append(SPACE).append(valueFromArray);
        } else {
            if (unitOfNumber == 1) {
                thousandEnding.append(hundredFromWords).append(ONE).append(valueFromArray).append(ENDING_A);
            }
            if (unitOfNumber == 2) {
                thousandEnding.append(hundredFromWords).append(TWO).append(valueFromArray).append(ENDING_I);
            }
            if (unitOfNumber > 2 && unitOfNumber < 5) {
                thousandEnding.append(hundredFromWords).append(dozenFromWords).append(SPACE).append(valueFromArray).append(ENDING_I);
            }
            if (unitOfNumber >= 5 || unitOfNumber == 0) {
                thousandEnding.append(hundredFromWords).append(dozenFromWords).append(SPACE).append(valueFromArray);
            }
        }
        return thousandEnding;
    }

    private static StringBuilder getBillionsClassesNumberEndingOnRussian(int quantityOfNumberClasses, String languageConvert) {
        StringBuilder exponentialNumberEnding = new StringBuilder();
        final List<String>  arrayFromOneThousandToMaximumAvailableNumber = TextDataParsing.getArrayOneThousandToMaximumAvailableNumber(languageConvert);
        final String valueFromArray = arrayFromOneThousandToMaximumAvailableNumber.get(quantityOfNumberClasses - 1);

        if (dozenOfNumber > 10 && dozenOfNumber < 20) {
            exponentialNumberEnding.append(hundredFromWords).append(dozenFromWords).append(SPACE).append(valueFromArray).append(ENDING_OF);
        } else {
            if (unitOfNumber == 1) {
                exponentialNumberEnding.append(hundredFromWords).append(dozenFromWords).append(SPACE).append(valueFromArray);
            }
            if (unitOfNumber > 1 && unitOfNumber < 5) {
                exponentialNumberEnding.append(hundredFromWords).append(dozenFromWords).append(SPACE).append(valueFromArray).append(ENDING_A);
            }
            if (unitOfNumber >= 5 || unitOfNumber == 0) {
                exponentialNumberEnding.append(hundredFromWords).append(dozenFromWords).append(SPACE).append(valueFromArray).append(ENDING_OF);
            }
        }
        return exponentialNumberEnding;
    }
}
