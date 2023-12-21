package Main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class fileWrite {
	// Fields
	private ArrayList<String> writeBuffer;
	private String filename;
	
	// Constructor
	public fileWrite(String filename){
		this.filename = filename;			// Save filename for later
		writeBuffer = new ArrayList<>();
	}
	
	//Methods
	public void writeLine(String newLine){
		writeBuffer.add(newLine);
	}
	
	public void saveFile() throws FileNotFoundException, IOException{
		BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true));	//Appending file
		File read = new File(filename);
			if(read.length() > 0)
				bw.write("\n");			//When there is data in first line of text file, write a newline
		try {		
			for(int i = 0; i < writeBuffer.size() - 1; i++) {
				bw.write(writeBuffer.get(i));
				bw.write("*");
			}
			bw.write(writeBuffer.get(writeBuffer.size()-1));		//Write last element without delimiter
			p("Entries Were Successfully Added!\n");
			bw.close();		//Closes file after writing
			writeBuffer.clear();
		}catch(IOException ex) {
			p(ex);
		}catch(Exception e) {
			p(e);
		}
	}
	
	public static void updateFile(String filename, ArrayList<Movie> movies) throws FileNotFoundException, IOException{
		BufferedWriter bw = new BufferedWriter(new FileWriter(filename));	//Overwriting file
		int index = 1;
		int sizeList = movies.size();
		try {
			for(Movie movie : movies) {
					bw.write(movie.getTitle());
					bw.write("*");
					String year = Integer.toString(movie.getYear());
					bw.write(year);
					bw.write("*");
					String runtime = Integer.toString(movie.getRuntime());
					bw.write(runtime);
					bw.write("*");
					bw.write(movie.getActor1());
					bw.write("*");
					bw.write(movie.getActor2());
					bw.write("*");
					bw.write(movie.getDirector());
					
					if(index < sizeList)
						bw.write("\n");	
					
					index++;
			}
			bw.close();		//Closes file after writing
			
		}catch(IOException ex) {
			p(ex);
		}catch(Exception e) {
			p(e);
		}
	}

	
	public static <E> void p(E item){
		System.out.println(item);
	}
}