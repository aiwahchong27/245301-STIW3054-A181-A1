package com.assignment1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class WriteExcelFile {
	public static void main() throws IOException {
		
		try {
		HSSFWorkbook wbook = new HSSFWorkbook();
		HSSFSheet sheet = wbook.createSheet("Trivia");
		
		int r=0;
		for (TableInfo i : com.assignment1.ReadTableInfo.findAll()) {
			
			Row row = sheet.createRow(r);
			Cell cellLeft = row.createCell(0);
			cellLeft.setCellValue(i.getLeft());
			
			Cell cellRight = row.createCell(1);
			cellRight.setCellValue(i.getRight());
			r++;
			
		}
		
		for (int i=0; i<2; i++)
			sheet.autoSizeColumn(i);
		
		FileOutputStream output = new FileOutputStream(new File ("C:\\Users\\user\\Documents\\Trivia.xls"));
		wbook.write(output);
		output.close();
		wbook.close();
		System.out.println("Excel written successfully...");
		
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	


}
