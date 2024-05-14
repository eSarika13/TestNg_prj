package apr17;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ConvertinttoString {

	public static void main(String[] args) throws Throwable {
		FileInputStream fi = new FileInputStream("E:/Book1.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet ws = wb.getSheet("Emp");
		int rc = ws.getLastRowNum();
		for(int i=1;i<=rc;i++)
		{
			if(wb.getSheet("Emp").getRow(i).getCell(3).getCellType()==CellType.NUMERIC);
			{
			int celldata = (int)ws.getRow(i).getCell(3).getNumericCellValue();
			String eid = String.valueOf(celldata);
			System.out.println(eid);
			ws.getRow(i).createCell(4).setCellValue("pass");
			}
		}
		fi.close();
		FileOutputStream fo = new FileOutputStream("E:/Results.xlsx");
		fo.close();
		wb.close();
	}

}
