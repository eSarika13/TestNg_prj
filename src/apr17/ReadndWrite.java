package apr17;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadndWrite {

	public static void main(String[] args) throws Throwable {
		//read path of file
		FileInputStream fi = new FileInputStream("E:/Book1.xlsx");
		//get WB from file
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		//get sheet from WB
		XSSFSheet ws = wb.getSheet("Emp");
		//get rows count from sheet
		int rc = ws.getLastRowNum();
		for(int i=1;i<=rc;i++)
		{
			String fname = ws.getRow(i).getCell(0).getStringCellValue();
			String mname = ws.getRow(i).getCell(1).getStringCellValue();
			String lname = ws.getRow(i).getCell(2).getStringCellValue();
			int eid = (int) ws.getRow(i).getCell(3).getNumericCellValue();
			System.out.println( fname +mname +lname +eid +"\t");
			ws.getRow(i).createCell(4).setCellValue("pass");
		}
		fi.close();
		FileOutputStream fo = new FileOutputStream("E:/Result.xlsx");
		wb.write(fo);
		fo.close();
		wb.close();
	}

}
