package com.flipkart.utilities;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class XlsReader {

	private Workbook workBook = null;
	private Sheet sheet = null;
	private FileInputStream fileInputStream = null;
	private String fileExtensionName;
	private Row row = null;
	private Cell cell = null;
	public String path = null;
	private String cellValue;

	public void setPath(String path) throws IOException {
		this.path = path;
		verifyExcelWorkBook(path);
	}

	private void verifyExcelWorkBook(String filePath) throws IOException {
		try {
			File file = new File(filePath);
			fileInputStream = new FileInputStream(file);
			fileExtensionName = FilenameUtils.getExtension(filePath);

			if (fileExtensionName.equals("xlsx")) {
				workBook = new XSSFWorkbook(fileInputStream);
			} else if (fileExtensionName.equals("xls")) {
				workBook = new HSSFWorkbook(fileInputStream);
			}

			fileInputStream.close();
		} catch (IOException ioException) {
			throw new IOException("IOException occured as " + ioException.getMessage());
		}
	}

	public String getCellDataByColumnIndex(String sheetName, int columnIndex, int rowIndex) {
		try {
			int index = workBook.getSheetIndex(sheetName);
			sheet = workBook.getSheetAt(index);
			return verifyCellData(rowIndex, columnIndex);
		} catch (Exception exception) {
			return "row " + rowIndex + " or column " + columnIndex + " does not exist in xls";
		}
	}

	public String getCellDataByColumnName(String sheetName, String columnName, int rowIndex) {
		int columnIndex = -1;

		try {
			int index = workBook.getSheetIndex(sheetName);
			sheet = workBook.getSheetAt(index);
			row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().trim().equals(columnName.trim())) {
					columnIndex = i;
				}
			}
			if (columnIndex == -1) {
				return "Column doesn't exist with given name " + columnName;
			}
			return verifyCellData(rowIndex, columnIndex);
		} catch (Exception exception) {
			return "row " + rowIndex + " or column " + columnIndex + " does not exist  in xls";
		}
	}

	private String verifyCellData(int rowIndex, int columnIndex) {
		row = sheet.getRow(rowIndex);

		if (row == null)
			return "Data doesn't exist in given row";

		cell = row.getCell(columnIndex);

		if (cell == null)
			return "Data doesn't exist in given cell";

		if (CellType.STRING == cell.getCellType())
			cellValue = cell.getStringCellValue();
		else if (CellType.NUMERIC == cell.getCellType())
			cellValue = String.valueOf(cell.getNumericCellValue());
		else if (CellType.FORMULA == cell.getCellType())
			cellValue = String.valueOf(cell.getNumericCellValue());
		else if (CellType.BLANK == cell.getCellType())
			cellValue = "";
		else if (CellType.BOOLEAN == cell.getCellType())
			cellValue = String.valueOf(cell.getBooleanCellValue());
		else {
			cellValue = "Invalid data type";
		}

		return cellValue;
	}

	public int getRowCount(String sheetName) {
		int rowCount = 0;

		try {
			sheet = workBook.getSheet(sheetName);
			rowCount = sheet.getLastRowNum();
		} catch (Exception exception) {
		}

		return rowCount;
	}

	public int getColumnCount(String sheetName) {
		int columnCount = 0;

		try {
			sheet = workBook.getSheet(sheetName);
			columnCount = sheet.getRow(0).getLastCellNum();

			for (Row row : sheet) {
				if (columnCount < row.getLastCellNum()) {
					columnCount = row.getLastCellNum();
				}
			}
		} catch (Exception exception) {
		}

		return columnCount;
	}

}
