package apr16;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RowCellCount {

	public static void main(String[] args) throws Throwable {
		//read the path of file
		FileInputStream fi = new FileInputStream("E:/Book1.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet ws = wb.getSheet("Emp");
		XSSFRow row = ws.getRow(0);
		int rc = ws.getLastRowNum();
		int cc = row.getLastCellNum();
		System.out.println("No.of rows::" +rc);
		System.out.println("No.of Cells in First row::" +cc);
		fi.close();
		wb.close();
	}

}
