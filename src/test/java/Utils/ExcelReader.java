package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

    public static Object[][] readExcelData(String sheetName,String pathOfExcelSheet) {
        List<Object[]> dataList = new ArrayList<>();

        try {
            String filePath = System.getProperty("user.dir") +pathOfExcelSheet ;
            FileInputStream fis = new FileInputStream(filePath);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet(sheetName);

            int totalCols = sheet.getRow(0).getLastCellNum();
            System.out.println(totalCols);


            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row == null || isRowEmpty(row)) {
                    continue; // skip blank rows
                }

                Object[] rowData = new Object[totalCols];
                for (int j = 0; j < totalCols; j++) {
                    Cell cell = row.getCell(j);
                    String cellValue = "";

                    if (cell != null) {
                        cell.setCellType(CellType.STRING);
                        cellValue = cell.getStringCellValue().trim();
                        if (cellValue.equals("\"\"") || cellValue.trim().isEmpty()) {
                            cellValue = "";
                        }
                    }

                    rowData[j] = cellValue;
                }

                // Optional debug print
                System.out.println("Row " + i + ": " + String.join(" | ", toStringArray(rowData)));

                dataList.add(rowData);
            }

            workbook.close();
            fis.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return dataList.toArray(new Object[0][]);
    }

    private static boolean isRowEmpty(Row row) {
        for (int i = 0; i < row.getLastCellNum(); i++) {
            Cell cell = row.getCell(i);
            if (cell != null && cell.getCellType() != CellType.BLANK && !cell.toString().trim().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    private static String[] toStringArray(Object[] arr) {
        String[] strArr = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            strArr[i] = arr[i] == null ? "" : arr[i].toString();
        }
        return strArr;
    }
}
