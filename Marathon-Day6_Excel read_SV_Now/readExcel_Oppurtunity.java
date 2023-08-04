package Marathon;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readExcel_Oppurtunity {
	public static String[][] readExcelData(String excelFileName) throws IOException {
		// Set up the file path
		XSSFWorkbook wb = new XSSFWorkbook("./data/"+excelFileName+".xlsx");//./data/CreateLead.xlsx

		//Enter into the sheet by using sheetname/index
		XSSFSheet sheet = wb.getSheet("Sheet2");

		//Find the total number of rows
		int rowCount = sheet.getLastRowNum();
		System.out.println("The total number of rows: "+rowCount);

		//Find the total number of columns
		short columnCount = sheet.getRow(0).getLastCellNum();
		System.out.println("The total number of columns: "+columnCount);

//		XSSFRow row = sheet.getRow(2);
//		XSSFCell cell = row.getCell(3);
//		String firstCellData = cell.getStringCellValue();
//		System.out.println("Single cell data: "+firstCellData);

		//enter into the row
		//String stringCellValue = sheet.getRow(1).getCell(0).getStringCellValue();
		//System.out.println(stringCellValue);

		System.out.println("Entire data :----------------------");

		String[][] data = new String[rowCount][columnCount];

		for (int i = 1; i <= rowCount; i++) {
			XSSFRow eachRow = sheet.getRow(i);
			for (int j = 0; j < columnCount; j++) {
				String stringCellValue = eachRow.getCell(j).getStringCellValue();
				System.out.println(stringCellValue);
				data[i-1][j]=stringCellValue;//0,0 
			}

		}

        wb.close();
		return data;



	}

}

