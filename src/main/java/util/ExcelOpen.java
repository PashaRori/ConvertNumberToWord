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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static util.ConstantData.*;

public class ExcelOpen {
    private static final Logger LOGGER = Logger.getLogger(ExcelOpen.class);
    private static final ClassLoader classLoader = ExcelOpen.class.getClassLoader();

    private ExcelOpen() {
    }

    private static Workbook getDocumentName(String languageConvert) {
        return openFile((languageConvert.equals(LANGUAGE_RUSSIAN)) ? RUSSIAN_DIRECTORY : ENGLISH_DIRECTORY);
    }

    public static String convertCell(Cell cell) {
        String resultConvert = null;
        if (cell != null) {
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
        } else {
            PropertyConfigurator.configure(classLoader.getResource(LOG4J_PROPERTIES));
            LOGGER.error(NULL_EXCEPTION);
        }
        return resultConvert;
    }

    public static Workbook openFile(String documentName) {
        Workbook workbook = null;

        try {
            FileInputStream createFileInputStream = new FileInputStream(Objects.requireNonNull(classLoader.getResource(documentName)).getFile());
            workbook = getWorkbook(createFileInputStream);
            createFileInputStream.close();
        } catch (FileNotFoundException e) {
            PropertyConfigurator.configure(classLoader.getResource(LOG4J_PROPERTIES));
            LOGGER.error(FILE_NOT_FOUND);
        } catch (IOException e) {
            PropertyConfigurator.configure(classLoader.getResource(LOG4J_PROPERTIES));
            LOGGER.error(ERROR_CLOSE_STREAM);
        }
        return workbook;
    }

    private static Workbook getWorkbook(FileInputStream fileInputStream) {
        ClassLoader classLoader = ExcelOpen.class.getClassLoader();
        Workbook workbook = null;

        try (Workbook createWorkbook = new HSSFWorkbook(fileInputStream)) {
            workbook = createWorkbook;
        } catch (IOException e) {
            PropertyConfigurator.configure(classLoader.getResource(LOG4J_PROPERTIES));
            LOGGER.error(ERROR_INPUT_STREAM);
        }
        return workbook;
    }

    public static List<String> getArrayWithValues(String languageConvert) {
        Workbook workbook = getDocumentName(languageConvert);
        assert workbook != null;
        int quantityRow = workbook.getSheetAt(0).getLastRowNum() + 1;
        List<String> resultArray = new ArrayList<>();

        for (int i = 0; i < quantityRow; i++) {
            resultArray.add(convertCell(workbook.getSheetAt(0).getRow(i).getCell(0)));
        }
        return resultArray;
    }
}