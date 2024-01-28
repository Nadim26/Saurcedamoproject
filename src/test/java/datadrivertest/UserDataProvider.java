package datadrivertest;

import org.testng.annotations.DataProvider;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class UserDataProvider {
	
//	private static XSSFWorkbook workbook;
//	private static XSSFSheet sheet;
//	private static String file = "F://users.xlsx";
//	private static String sheetName ="users"; 

	@DataProvider(name="userData")
	public Object[][] userDataSet() {
		return new Object[][] {
	{ "standard_user", "secret_sauce" },
	{ "problem_user", "secret_sauce"},
	{ "performanceglitch_user", "secret_sauce"},
		};
	}
	
//	public void readExcel() throws IOException {
//		workbook = new XSSFWorkbook(file);
//		sheet = workbook.getSheet(sheetName);
//				
//	}
//	
//		public int getRowCount() {
//           return sheet.getPhysicalNumberOfRows();
//		}
//
//		public int getColCount() {
//           return sheet.getRow(0).getPhysicalNumberOfCells();
//		}
//
//		
//
//		public String getCelDataString(int row, int col) {
//
//		return sheet.getRow(row).getCell(col).getStringCellValue();
//
//		}
	
}
