package excelMiniProject;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelDriver {
	public static void main(String[] args) {
//		ReadAndWrite excel = new ReadAndWrite("D:\\QSP\\Java\\ExcelHandling\\Orders-WithNulls.xlsx");
		try {
			FileInputStream fis = new FileInputStream("D:/QSP/Java/eclipse-workspace/MiniProjects/src/excelMiniProject/OrdersWithNullsUpdated.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sheet = wb.getSheet("Orders");
//			int rowCount = sheet.getLastRowNum();
			int rowCount = 11;
//			int clmCount = sheet.getRow(1).getLastCellNum();
			int clmCount = 11;
			DataFormatter dataFormatter = new DataFormatter();

			for (int i = 0; i < rowCount; i++) {
				Row row = sheet.getRow(i);
				System.out.println("Data from the Row: " + i);
				for (int j = 0; j < clmCount; j++) {
					Cell cell = row.getCell(j);
//					switch(cell.getCellType()) {
//					case STRING: System.out.println(cell.getStringCellValue()); break;
//					case NUMERIC: System.out.println(cell.getNumericCellValue()); break;
//					case BOOLEAN: System.out.println(cell.getBooleanCellValue()); break;
//					case BLANK: System.out.println("Blank"); break;
////					case _NONE: System.out.println("None"); break;
//					default: System.out.println(cell.getDateCellValue()); break;
//					}
					String cellStringValue = dataFormatter.formatCellValue(cell);
					System.out.println(cellStringValue);
				}
				System.out.println("-------------------------------------------");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}