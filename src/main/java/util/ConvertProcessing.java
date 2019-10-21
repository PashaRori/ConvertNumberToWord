package util;

import java.util.List;

import static util.ConstantData.*;

public class ConvertProcessing {
    private static int hundredOfNumber;
    private static int dozenOfNumber;
    private static int unitOfNumber;
    private static String hundredFromWords;
    private static String dozenFromWords;

    private ConvertProcessing() {
    }

    private static void getNumberAndWordFromSegment(String receivedSegment, String languageConvert) {
        int numberSegment = Integer.parseInt(receivedSegment);
        hundredOfNumber = numberSegment / 100;
        hundredFromWords = getHundred(languageConvert);
        dozenOfNumber = numberSegment % 100;
        dozenFromWords = getDozen(languageConvert);
        unitOfNumber = numberSegment % 10;
    }

    public static StringBuilder createOnRussian(String receivedSegment, int quantityOfNumberClasses, String languageConvert) {
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

    public static StringBuilder createOnEnglish(String receivedSegment, int quantityOfNumberClasses, String languageConvert) {
        StringBuilder resultCreateWord = new StringBuilder();

        getNumberAndWordFromSegment(receivedSegment, languageConvert);

        if (quantityOfNumberClasses == 0 && !receivedSegment.equals(ZEROS)) {
            resultCreateWord.append(getHundredEndingOnEnglish(quantityOfNumberClasses));
        }
        if ((hundredOfNumber != 0 || dozenOfNumber != 0) && quantityOfNumberClasses > 0) {
            resultCreateWord.append(getBillionsClassesEndingOnEnglish(quantityOfNumberClasses, languageConvert));
        }
        return resultCreateWord;
    }

    private static String getHundred(String languageConvert) {
        final List<String> arrayFromOneHundredToNineHundred = TextDataParsing.getArrayOneHundredToOneThousand(languageConvert);
        return ((hundredOfNumber == 0) ? "" : SPACE + arrayFromOneHundredToNineHundred.get(hundredOfNumber - 1));
    }

    private static String getDozen(String languageConvert) {
        final List<String>  arrayFromZeroToOneHundred = TextDataParsing.getArrayZeroToOneHundred(languageConvert);
        return ((hundredOfNumber > 0 && dozenOfNumber == 0) ? EMPTY : SPACE + arrayFromZeroToOneHundred.get(dozenOfNumber));
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

    private static StringBuilder getThousandEndingOnRussian(int quantityOfNumberClasses, String languageConvert) {
        StringBuilder thousandEnding = new StringBuilder();
        final List<String>  arrayFromOneThousandToMaximumAvailableNumber = TextDataParsing.getArrayOneThousandToMaximumAvailableNumber(languageConvert);
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

    private static StringBuilder getBillionsClassesEndingOnEnglish(int quantityOfNumberClasses, String languageConvert) {
        StringBuilder exponentialNumberEnding = new StringBuilder();
        final List<String>  arrayFromOneThousandToMaximumAvailableNumber = TextDataParsing.getArrayOneThousandToMaximumAvailableNumber(languageConvert);
        exponentialNumberEnding.append(hundredFromWords).append(dozenFromWords).append(SPACE)
                .append(arrayFromOneThousandToMaximumAvailableNumber.get(quantityOfNumberClasses - 1));
        return exponentialNumberEnding;
    }
}
