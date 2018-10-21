package com.assignment1;

import java.io.IOException;

public class App {
	
	public static void main (String[] args) throws IOException{
		System.out.println("Writing file.....");
		ReadTableInfo.findAll();
		WriteExcelFile.main();
	}

}
