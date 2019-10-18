package util;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

import static util.FinalData.*;

public class ExcelOpen {
    private static final Logger LOGGER = Logger.getLogger(ExcelOpen.class);

    private ExcelOpen() {
    }

    private static Workbook getDocumentName(String languageConvert) {
        return openFile((languageConvert.equals(RUSSIAN)) ? RUSSIAN_DIRECTORY : ENGLISH_DIRECTORY);
    }

    public static String convertCell(Cell cell) {
        String resultConvert = null;

        switch (cell.getCellType()) {
            case STRING:
                resultConvert = cell.getRichStringCellValue().getString();
                break;
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    resultConvert = cell.getDateCellValue().toString();
                } else {
                    resultConvert = Double.toString(cell.getNumericCellValue());
                }
                break;
            case BOOLEAN:
                resultConvert = Boolean.toString(cell.getBooleanCellValue());
                break;
            case FORMULA:
                resultConvert = cell.getCellFormula();
                break;
            default:
                break;
        }
        return resultConvert;
    }

    private static Workbook openFile(String documentName) {
        ClassLoader classLoader = ExcelOpen.class.getClassLoader();
        FileInputStream fileInputStream = null;
        Workbook workbook = null;

        try {
            fileInputStream = new FileInputStream(Objects.requireNonNull(classLoader.getResource(documentName)).getFile());
            try {
                workbook = new HSSFWorkbook(fileInputStream);
            } catch (IOException e) {
                PropertyConfigurator.configure(classLoader.getResource(LOG4J_FILE));
                LOGGER.error(ERROR_INPUT_STREAM);
            } finally {
                try {
                    assert workbook != null;
                    workbook.close();
                } catch (IOException e) {
                    PropertyConfigurator.configure(classLoader.getResource(LOG4J_FILE));
                    LOGGER.error(ERROR_CLOSE_STREAM);
                }
            }
        } catch (FileNotFoundException e) {
            PropertyConfigurator.configure(classLoader.getResource(LOG4J_FILE));
            LOGGER.error(FILE_NOT_FOUND);
        } finally {
            try {
                assert fileInputStream != null;
                fileInputStream.close();
            } catch (IOException e) {
                PropertyConfigurator.configure(classLoader.getResource(LOG4J_FILE));
                LOGGER.error(ERROR_CLOSE_STREAM);
            }
        }
        return workbook;
    }

    public static String[] getArrayWithValues(String languageConvert) {
        Workbook workbook = getDocumentName(languageConvert);
        assert workbook != null;
        int quantityRow = workbook.getSheetAt(0).getLastRowNum() + 1;
        String[] resultArray = new String[quantityRow];

        for (int i = 0; i < quantityRow; i++) {
            resultArray[i] = convertCell(workbook.getSheetAt(0).getRow(i).getCell(0));
        }
        return resultArray;
    }
}