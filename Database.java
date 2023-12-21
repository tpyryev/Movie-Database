package Main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Database {
	// Fields
	private ArrayList<Movie> movies;
	
	// Constructor
	public Database(String filename) throws IOException{
		try {
			movies = new ArrayList<>();
			fileRead fr = new fileRead(filename);
			for(int i = 0; i < fr.getNumberOfLines(); i++){
				String raw = fr.getLine(i);
				StringTokenizer st = new StringTokenizer(raw, "*");
				String title = st.nextToken();
				String year = st.nextToken().trim();
				int yearInt = Integer.parseInt(year);
				String runtime = st.nextToken().trim();
				int runtimeInt = Integer.parseInt(runtime);
				String actor1 = st.nextToken();
				String actor2 = st.nextToken();
				String director = st.nextToken();
				
				Movie data = new Movie (title, yearInt, runtimeInt, actor1, actor2, director);
				movies.add(data);
			}
		}catch(IOException ex) {
			p(ex);
		}catch(Exception e) {
			p(e);
		}
	}
	
	// Methods
	public void addEntry(Movie newEntry) throws FileNotFoundException, IOException, NumberFormatException{
		fileWrite write = new fileWrite("db.txt");
		
		String title = newEntry.getTitle();
		int yearInt = newEntry.getYear();
		String year = Integer.toString(yearInt);
		int runtimeInt = newEntry.getRuntime();
		String runtime = Integer.toString(runtimeInt);
		String actor1 = newEntry.getActor1();
		String actor2 = newEntry.getActor2();
		String director = newEntry.getDirector();
		
		write.writeLine(title);		//writes all variables to memory in an ArrayList
		write.writeLine(year);
		write.writeLine(runtime);
		write.writeLine(actor1);
		write.writeLine(actor2);
		write.writeLine(director);
		
		
		write.saveFile();	//Writes and saves new entries to file
	}
	
	public void searchByTitle(String title) throws FileNotFoundException, IOException{
		boolean check = false;
		
		for(Movie movie: movies) {
			String titleCheck = movie.getTitle();
			if(title.equalsIgnoreCase(titleCheck)) {
				if(movie.getActor2().equals(" ")) {
					p("Actor:");
					pn(movie.getActor1());
				}
				else {
					p("Actors:");
					pn(movie.getActor1() + ", " + movie.getActor2());
				}
				p("Director:");
				pn(movie.getDirector());
				p("Year:");
				pn(movie.getYear());
				p("Runtime:");
				pn(movie.getRuntime() + " Minutes");
				check = true;
			}
		}
		
		if(check == false)
			pn("The Title " + title + " was not Found!");
		
		pn("");
	}
	
	public void searchByActor(String actor) throws FileNotFoundException, IOException{
		boolean check = false;
		
		pn("\nMovies Starring " + actor);
		pn("----------------------------");
		
		for(Movie movie: movies) {
			String actorCheck1 = movie.getActor1();
			String actorCheck2 = movie.getActor2();
			if(actor.equalsIgnoreCase(actorCheck1) || actor.equalsIgnoreCase(actorCheck2)) {
				if(!actor.equalsIgnoreCase(" ")) {		//If actor is not empty string then print title
					pn(movie.getTitle());
					check = true;
				}
			}
		}
		
		if(check == false)
			pn("No Titles Found for this Actor!");
		
		pn("");		//Create newline after displaying titles or Invalid message
	}
	
	public void searchByDirector(String director) throws FileNotFoundException, IOException{
		boolean check = false;
		
		pn("\nMovies Directed by " + director);
		pn("---------------------------------");
		
		for(Movie movie: movies) {
			String directorCheck = movie.getDirector();
			if(director.equalsIgnoreCase(directorCheck)) {
				pn(movie.getTitle());
				check = true;
			}
		}
		
		
		if(check == false)
			pn("No Titles Found for this Director!");
		
		pn("");		//Create newline after displaying titles or Invalid message
		
	}
	
	public void searchByYear(int year) throws FileNotFoundException, IOException, NumberFormatException{
		try {
			boolean check = false;
			
			pn("\nMovies Made in the Year " + year);
			pn("-----------------------------");
			
			for(Movie movie: movies) {
				int yearCheck = movie.getYear();
				if(year == yearCheck) {
					pn(movie.getTitle());
					check = true;
				}
			}
			
			if(check == false)
				pn("No Titles Found for this Year!");
			
			pn("");		//Create newline after displaying titles or Invalid message
		}catch(NumberFormatException ex) {
			pn(ex);
		}catch(Exception e) {
			pn(e);
		}
	}
	
	public void searchByRuntime(int runtime) throws FileNotFoundException, IOException, NumberFormatException{
		boolean check = false;
		
		pn("\nMovies Made in the Runtime " + runtime + " Minutes");
		pn("---------------------------------------");
		
		for(Movie movie: movies) {
			int runtimeCheck = movie.getRuntime();
			if(runtime == runtimeCheck) {
				pn(movie.getTitle());
				check = true;
			}
		}
		
		if(check == false)
			pn("No Titles Found for this Runtime!");
		
		pn("");		//Create newline after displaying titles or Invalid message
	}
	
	public void deleteEntry(String title) throws FileNotFoundException, IOException{
		boolean check = false;
		Iterator<Movie> iter = movies.iterator();
		
		while(iter.hasNext()) {
			Movie movie = iter.next();
			String titleCheck = movie.getTitle();
			
			if(title.equalsIgnoreCase(titleCheck)) {
				iter.remove();
				fileWrite.updateFile("db.txt", movies);	
				pn(title + " was deleted from the Database!");
				check = true;
			}
		}
		
		if(check == false)
			pn("The Title " + title + " was not Found!");
		
		pn("");		//Create newline after deleting title or Invalid message
	}
	
	public static <E> void pn(E item){
		System.out.println(item);
	}
	
	public static <E> void p(E item){
		System.out.print(item + " ");
	}
}