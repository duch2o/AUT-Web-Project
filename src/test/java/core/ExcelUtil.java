package core;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ExcelUtil {
    public static Object[][] getTableArray(String filePath,String sheetname,int startCol,int totalCol){
        String[][] tableArray =null;
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
            XSSFSheet xssfSheet = xssfWorkbook.getSheet(sheetname);
            int startRow = 1;
            int ci,cj;
            int totalRows = xssfSheet.getLastRowNum();
            ci = 0;
            tableArray = new String[totalRows][totalCol];

            for(int i= startRow;i<=totalCol;i++){
                cj=0;
                for(int j=startCol;j<totalCol;j++,cj++){
                    XSSFCell cell = xssfSheet.getRow(i).getCell(j);
                    tableArray[ci][cj] = cell.getStringCellValue();
                }
            }
            fileInputStream.close();
        }catch (Exception e){

        }
        return tableArray;
    }
}
