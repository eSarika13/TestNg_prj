package apr16;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class AlternateMethod {
	public static void main(String[] args) throws Throwable {
		//read path of file
		FileInputStream fi = new FileInputStream("E:/Book1.xlsx");
		//get workbook from file
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		//get sheet from WB
		XSSFSheet ws = wb.getSheet("Emp");
		//count no.of rows in sheet
		int rc = ws.getLastRowNum();
		System.out.println("No.of rows::" +rc);
		//print specific row in each cell
		String fname = ws.getRow(1).getCell(0).getStringCellValue();
		String mname = ws.getRow(6).getCell(1).getStringCellValue();
		String lname = ws.getRow(2).getCell(2).getStringCellValue();
		int eid = (int) ws.getRow(12).getCell(3).getNumericCellValue();
		System.out.println(fname +" " +mname +" " +lname +" " +eid);
		fi.close();
		wb.close();
		
	}

}
