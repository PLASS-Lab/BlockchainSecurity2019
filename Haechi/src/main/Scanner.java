package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Scanner {
	String json = "";

	public String createJson(String inputFile) {
		String astFile;
		try {
			astFile = inputFile + ".ast";
			FileReader fileReader = new FileReader(astFile);
			BufferedReader bufReader = new BufferedReader(fileReader);
			
			// Eliminate unnecessary data.
			for(int i=0; i<4; i++) {
				bufReader.readLine();
			}
			
			String line = "";
			while((line = bufReader.readLine()) != null) {
				json += line;
				json += "\r\n";
			}
			
			bufReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		return json;
	}
}
