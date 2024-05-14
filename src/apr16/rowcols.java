package apr16;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class rowcols {

	public static void main(String[] args) throws Throwable {
		//read path of file
		FileInputStream fi = new FileInputStream("e:/Book1.elsx");
		//get wb from file
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		//get sheet from wb
		XSSFSheet ws = wb.getSheet("Emp");
		//get rows in sheet
		int rc =ws.getFirstRowNum();
		System.out.println(rc);
		

	}

}
