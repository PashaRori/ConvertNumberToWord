package model;

import org.apache.log4j.Logger;
import util.language.ConvertEnglish;
import util.language.ConvertRussian;

import java.util.List;

import static util.ConstantData.*;
import static util.NumberProcessing.checkNegativityNumber;
import static util.NumberProcessing.numberSegments;

public class ConvertNumberToWord {
    private static final Logger LOGGER = Logger.getLogger(ConvertNumberToWord.class);
    private String conversionNumber;
    private String languageConvert;

    public ConvertNumberToWord(String introducedNumber, String languageConvert) {
        this.conversionNumber = introducedNumber;
        this.languageConvert = languageConvert;
    }

    public String createFinalWord() {
        StringBuilder conversionResult = new StringBuilder();

        try {
            final String positiveConversionNumber = checkNegativityNumber(conversionNumber);

            if (!conversionNumber.equals(positiveConversionNumber)) {
                conversionResult.append((languageConvert.equals(LANGUAGE_RUSSIAN)) ? MINUS_RUSSIAN : MINUS_ENGLISH);
            }

            List<String> numberSegments = numberSegments(positiveConversionNumber);
            int quantityOfNumberClasses = numberSegments.size() - 1;

            ConvertRussian convertRussian = new ConvertRussian();
            ConvertEnglish convertEnglish = new ConvertEnglish();
            for (String numberSegment : numberSegments) {
                conversionResult.append((languageConvert.equals(LANGUAGE_RUSSIAN)) ?
                        convertRussian.createOnOtherLanguage(numberSegment, quantityOfNumberClasses) :
                        convertEnglish.createOnOtherLanguage(numberSegment, quantityOfNumberClasses));

                quantityOfNumberClasses--;
            }
        } catch (NumberFormatException e) {
            LOGGER.error(NOT_NUMBER_EXCEPTION);
        } catch (NullPointerException e) {
            LOGGER.error(NULL_EXCEPTION);
        } catch (IndexOutOfBoundsException e) {
            LOGGER.error(OUT_OF_BOUNDS);
        }

        conversionResult.deleteCharAt(0);
        return conversionResult.toString();
    }
}
