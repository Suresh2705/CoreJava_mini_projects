package excelMiniProject;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadAndWrite {
	private String path;

	public ReadAndWrite() {
		// loi
	}

	public ReadAndWrite(String path) {
		this.path = path;
	}

	public String readExcel(String sheetName, int rowNo) {
		String data = "";
		try {
			FileInputStream fis = new FileInputStream(path);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sheet = wb.getSheet(sheetName);

			int clmCount = sheet.getRow(rowNo).getLastCellNum();
			DataFormatter dataFormatter = new DataFormatter();
			Row row = sheet.getRow(rowNo);
			for (int j = 0; j < clmCount; j++) {
				Cell cell = row.getCell(j);
//				switch(cell.getCellType()) {
//				case STRING: System.out.println(cell.getStringCellValue()); break;
//				case NUMERIC: System.out.println(cell.getNumericCellValue());break;
//				case BOOLEAN: System.out.println(cell.getBooleanCellValue());break;
//				default: System.out.println("Null");break;
//				}
				data = dataFormatter.formatCellValue(cell);
				System.out.println(data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}

	public void writeExcel(String sheetName, int rowNo, int clmNo, String data) {
		try {
			FileInputStream fis = new FileInputStream(path);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sheet = wb.getSheet(sheetName);
			Row row = sheet.createRow(rowNo);
			Cell cell = row.createCell(clmNo);
			cell.setCellValue(data);
			FileOutputStream fos = new FileOutputStream(path);
			wb.write(fos);
			wb.close();
			System.out.println("Data written successfully!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ReadAndWrite excel = new ReadAndWrite("D:/QSP/Java/eclipse-workspace/MiniProjects/src/excelMiniProject/OrdersWithNullsUpdated.xlsx");
		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter the row number to get the Data:");
//		int rowNo = sc.nextInt();
//		excel.readExcel("Orders", rowNo);
		excel.writeExcel("Sheet3", 0, 0, "Testing");
		sc.close();
	}
}