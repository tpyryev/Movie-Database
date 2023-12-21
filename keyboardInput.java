package Main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class keyboardInput {
	// Fields
	private Scanner keyb;
	
	// Constructor
	public keyboardInput(){
		keyb = new Scanner(System.in);
	}
	
	// Methods
	public String getKeyboardLine(){
		return keyb.nextLine();
	}
	
	public static void optionsPrimary(String input, Database db) throws FileNotFoundException, IOException, NumberFormatException {
		keyboardInput choice = new keyboardInput();
		
		switch(input) {
		
			case "a":
			case "new entry":
				try {
					pn("New Entry");
					pn("---------");
					p("Enter Title >");
					String title = choice.getKeyboardLine();
					while(title.length() < 3) {								//Title must have minimum 3 characters
						pn("Title length must be at least 3 characters!");
						p("Enter Title >");
						title = choice.getKeyboardLine();
					}
					
					p("Enter Year >");
					String year = choice.getKeyboardLine();
					while(year.length() < 1) {
						pn("Input Valid Year!");
						p("Enter Year >");
						year = choice.getKeyboardLine();
					}
					int yearInt = Integer.parseInt(year);
					
						
					p("Enter Runtime (Minutes) >");
					String runtime = choice.getKeyboardLine();
					while(runtime.length() < 1) {
						pn("Input Valid Runtime!");
						p("Enter Runtime (Minutes) >");
						runtime = choice.getKeyboardLine();
					}
					int runtimeInt = Integer.parseInt(runtime);

					p("Enter Actor 1 >");
					String actor1 = choice.getKeyboardLine();
					while(actor1.length() < 1) {
						pn("Enter Valid Name!");
						p("Enter Actor 1 >");
						actor1 = choice.getKeyboardLine();
					}	
					
					p("Enter Actor 2 >");
					String actor2 = choice.getKeyboardLine();
					if(actor2.equals(""))
						actor2 = " ";							//If there is no Actor 2 in the Movie, assign it a space character
					p("Enter Director >");
					String director = choice.getKeyboardLine();
					while(director.length() < 1) {
						pn("Enter Valid Name!");
						p("Enter Director >");
						director = choice.getKeyboardLine();
					}		
					
					Movie data = new Movie(title, yearInt, runtimeInt, actor1, actor2, director);
					db.addEntry(data);
					}catch(NumberFormatException ex) {
						pn("Value Not Recognized. Please Enter a Proper Integer for Year or Runtime!\n");
					}catch(Exception e) {
						pn(e);
					}
					break;
				
			case "b":
			case "search by actor":
					pn("Search by Actor");
					pn("---------------");
					p("Enter Actor >");
					String actorSearch = choice.getKeyboardLine();
					while(actorSearch.length() < 1) {
						pn("Enter Valid Name!");
						p("Enter Actor >");
						actorSearch = choice.getKeyboardLine();
					}		
					db.searchByActor(actorSearch);
					break;
				
			case "c":
			case "search by year":
					try {
						pn("Search by Year");
						pn("--------------");
						p("Enter Year >");
						String yearSearch = choice.getKeyboardLine();
						while(yearSearch.length() < 1) {
							pn("Enter Valid Year!");
							p("Enter Year >");
							yearSearch = choice.getKeyboardLine();
						}		
						db.searchByYear(Integer.parseInt(yearSearch));
					}catch(NumberFormatException ex) {
						pn("Value Not Recognized. Please Enter a Proper Integer!\n");
					}catch(Exception e) {
						pn(e);
					}
					break;
			
			case "d":
			case "search by runtime":
					try {
						pn("Search by Runtime");
						pn("-----------------");
						p("Enter Runtime (Minutes) >");
						String runtimeSearch = choice.getKeyboardLine();
						while(runtimeSearch.length() < 1) {
							pn("Enter Valid Runtime!");
							p("Enter Runtime (Minutes) > >");
							runtimeSearch = choice.getKeyboardLine();
						}		
						db.searchByRuntime(Integer.parseInt(runtimeSearch));
					}catch(NumberFormatException ex) {
						pn("Value Not Recognized. Please Enter a Proper Integer!\n");
					}catch(Exception e) {
						pn(e);
					}
					break;
				
			case "e":
			case "search by director":
					pn("Search by Director");
					pn("------------------");
					p("Enter Director >");
					String directorSearch = choice.getKeyboardLine();
					while(directorSearch.length() < 1) {
						pn("Enter Valid Name!");
						p("Enter Director >");
						directorSearch = choice.getKeyboardLine();
					}		
					db.searchByDirector(directorSearch);
					break;
				
			case "f":
			case "search by title":
					pn("Search by Title");
					pn("---------------");
					p("Enter Title >");
					String titleSearch = choice.getKeyboardLine();
					while(titleSearch.length() < 3) {
						pn("Title length must be at least 3 characters!");
						p("Enter Title >");
						titleSearch = choice.getKeyboardLine();
					}		
					db.searchByTitle(titleSearch);
					break;
				
			case "g":
			case "delete entry":
					pn("Delete Entry");
					pn("------------");
					p("Enter Title to Delete >");
					String titleDelete = choice.getKeyboardLine();
					while(titleDelete.length() < 3) {
						pn("Title length must be at least 3 characters!");
						p("Enter Title to Delete >");
						titleDelete = choice.getKeyboardLine();
					}
					db.deleteEntry(titleDelete);
					break;
			
			case "h":
			case "quit":
					break;
			
			default:
					pn("Invalid Input!\n");
				
		}	
	}
	
	public void closeKeyboard(){
		keyb.close();
	}
	
	public static <E> void p(E item){
		System.out.print(item + " ");
	}
	
	public static <E> void pn(E item){
		System.out.println(item);
	}
}