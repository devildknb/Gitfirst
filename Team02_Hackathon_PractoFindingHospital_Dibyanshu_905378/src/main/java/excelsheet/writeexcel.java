package excelsheet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class writeexcel {
    public void write(int rownm,int cellnum,String message) throws Exception {
    String filepath="./test cases/hackathon find hospital.xlsx";
    File file= new File(filepath);
    FileInputStream fis=new FileInputStream(file);
    XSSFWorkbook workbook=new XSSFWorkbook(fis);
    XSSFSheet sheet=workbook.getSheet("TEST CASES");
    Row row=sheet.getRow(rownm);
    row.createCell(cellnum).setCellValue(message);
    FileOutputStream fos=new FileOutputStream(filepath);
    workbook.write(fos);
    workbook.close();
   
   
   
   
   
    }
}