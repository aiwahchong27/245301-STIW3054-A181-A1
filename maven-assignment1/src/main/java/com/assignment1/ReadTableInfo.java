package com.assignment1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class ReadTableInfo {
public static  List<TableInfo> findAll() {
		
		final String url= "https://ms.wikipedia.org/wiki/Malaysia";

		try {
			
			final Document doc = Jsoup.connect(url).get();
			List<TableInfo> info= new ArrayList<TableInfo>();
			
			
		for (Element row : doc.select("#mw-content-text > div > table:nth-child(148) > tbody > tr")) {
			
			String left = row.select("th").text();
			String right = row.select("td").text();
			info.add(new TableInfo(left,right));
			
		}return info;
		
		
	} catch (IOException e) {
		
		e.printStackTrace();
	
	}
		return null;
		
	
	}

}
