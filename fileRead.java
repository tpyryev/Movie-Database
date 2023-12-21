package Main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;

public class fileRead {
	// Fields
	private ArrayList<String> lines;
	
	// Constructor
	public fileRead(String filename) throws FileNotFoundException, IOException, NumberFormatException{
		lines = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader(filename));
		
		try {
			String line = br.readLine();
			while(line != null) {
				lines.add(line);
				line = br.readLine();
			}
			
			br.close();		//Closes file after reading
		}catch(IOException ex) {
			p(ex);
		}catch(Exception e) {
			p(e);
		}	
	}
	
	// Methods
	public int getNumberOfLines() {
		return lines.size();
	}	
	
	public String getLine(int index) {
		if(index >= lines.size())
			return "Invalid Index!";
		
		return lines.get(index);
	}
	
	public static <E> void p(E item){
		System.out.println(item);
	}
}