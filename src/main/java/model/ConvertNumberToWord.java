package model;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.List;

import static util.ConstantData.*;
import static util.ConvertProcessing.createOnEnglish;
import static util.ConvertProcessing.createOnRussian;
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
        ClassLoader classLoader = ConvertNumberToWord.class.getClassLoader();

        try {
            final String positiveConversionNumber = checkNegativityNumber(conversionNumber);

            if (!conversionNumber.equals(positiveConversionNumber)) {
                conversionResult.append((languageConvert.equals(LANGUAGE_RUSSIAN)) ? MINUS_RUSSIAN : MINUS_ENGLISH);
            }

            List<String> numberSegments = numberSegments(positiveConversionNumber);
            int quantityOfNumberClasses = numberSegments.size() - 1;

            for (String numberSegment : numberSegments) {
                conversionResult.append((languageConvert.equals(LANGUAGE_RUSSIAN)) ?
                        createOnRussian(numberSegment, quantityOfNumberClasses, languageConvert) :
                        createOnEnglish(numberSegment, quantityOfNumberClasses, languageConvert));

                quantityOfNumberClasses--;
            }
        } catch (NumberFormatException e) {
            PropertyConfigurator.configure(classLoader.getResource(LOG4J_PROPERTIES));
            LOGGER.error(NOT_NUMBER_EXCEPTION);
        } catch (NullPointerException e) {
            PropertyConfigurator.configure(classLoader.getResource(LOG4J_PROPERTIES));
            LOGGER.error(NULL_EXCEPTION);
        } catch (ArrayIndexOutOfBoundsException e) {
            PropertyConfigurator.configure(classLoader.getResource(LOG4J_PROPERTIES));
            LOGGER.error(OUT_OF_BOUNDS);
        }

        conversionResult.deleteCharAt(0);
        return conversionResult.toString();
    }
}
