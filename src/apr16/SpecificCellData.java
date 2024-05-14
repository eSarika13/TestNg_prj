package apr16;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SpecificCellData {

	public static void main(String[] args) throws Throwable {
		//read the path of file
		FileInputStream fi = new FileInputStream("E:/Book1.xlsx");
		//get workbook from file
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		//get sheet from wb
		XSSFSheet ws = wb.getSheet("Emp");
		//get 4 row from emp sheet
		XSSFRow row = ws.getRow(4);
		//Number rows in sheet
		int rc = ws.getLastRowNum();
		//get each cell data 
		XSSFCell c1 = row.getCell(0);
		XSSFCell c2 = row.getCell(1);
		XSSFCell c3 = row.getCell(2);
		XSSFCell c4 = row.getCell(3);
		String fname = c1.getStringCellValue();
		String mname = c2.getStringCellValue();
		String lname = c3.getStringCellValue();
		int eid = (int) c4.getNumericCellValue();
		System.out.println("No.of rows::" +rc);
		System.out.println(fname +" " +mname +" " +lname + " "+eid);
		fi.close();
		wb.close();	
	}

}
