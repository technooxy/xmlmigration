package com.aig.riskdatavalidation.excelparser;

import com.aig.riskdatavalidation.model.ExcelReaderModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class RiskSpreadSheetReader {

    public void reader() throws IOException {
       /* //obtaining input bytes from a file
        FileInputStream fis = new FileInputStream(new File("C:/Users/Lohitaksha/OneDrive/Documents/Rajesh/xmlvalidation/riskdata/privateedge/privateEdgeV1.xls"));
        //creating workbook instance that refers to .xls file
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        //creating a Sheet object to retrieve the object
        XSSFSheet sheet = wb.getSheetAt(0);
        //evaluating cell type
        FormulaEvaluator formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();
        System.out.println("The given file is");
        for (Row row : sheet)
        //iteration over row using for each loop
        {
            for (Cell cell : row) //iteration over cell using for each loop
            {
                //CellType cellType= formulaEvaluator.evaluateInCell(cell).getCellType();
                CellType cellType = cell.getCellType();
                switch (cellType) {
                    case NUMERIC:
                        //field that represents numeric cell type
                        //getting the value of the cell as a number
                        System.out.print(cell.getNumericCellValue() + "\t\t");
                        break;
                    case STRING:
                        //field that represents string cell type
                        //getting the value of the cell as a string
                        System.out.print(cell.getStringCellValue() + "\t\t");
                        break;
                }
            }
            System.out.println();
        }*/

        String FILE_NAME = "C:/Users/Lohitaksha/OneDrive/Documents/Rajesh/xmlvalidation/riskdata/privateedge/privateEdgeV1.xls";

        try {
            FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
            XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
            XSSFSheet datatypeSheet = workbook.getSheetAt(0);
            Map<Integer, ExcelReaderModel> readExcel = new LinkedHashMap<>();
            for (Row row : datatypeSheet)
            //iteration over row using for each loop
            {
                int i = 0;
                // Cell currentCell = cellIterator.next();
                ExcelReaderModel excelReaderModel = new ExcelReaderModel();
                excelReaderModel.setV2Xpath(notBlank(row.getCell(i)));
                excelReaderModel.setV4keyPath(notBlank(row.getCell(i + 1)));
                // excelReaderModel.setV4Xpath(row.getCell(i+2).getStringCellValue());
                excelReaderModel.setFormula(notBlank(row.getCell(i + 2)));
                readExcel.put(row.getRowNum(), excelReaderModel);
            }

            //TODO remove
            readExcel.forEach((k, v) -> {
                System.out.println(k + ":" + v);
            });


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String notBlank(Cell s) {
        return s == null || StringUtils.trimWhitespace(s.getStringCellValue()).isEmpty() ? "" : s.getStringCellValue();
    }
}
