//Name: Timothy Pyryev
package Main;

import java.io.IOException;

public class Display{
	public static void main(String[] args) throws IOException{
		Display display = new Display();
		Database db = new Database("db.txt");
		keyboardInput keyb = new keyboardInput();
		
		pn("   Tim's Official Movie Database");
		pn("------------------------------------");
		
		boolean check = true;
		while(check == true) {
			display.primaryDisplay();
			display.command();
			
			String input = keyb.getKeyboardLine();
			input = input.toLowerCase();
			
			if(input.equals("h") || input.equals("quit")) {
				pn("Thank you for using Tim's Official Movie Database!");
				check = false;
			}
			else {
				keyboardInput.optionsPrimary(input, db);
				db = new Database("db.txt");				//Parses through new information if added
			}		
		}
		//When exiting program
		keyb.closeKeyboard();
	}	
		
	public void primaryDisplay() {
		pn("a.) new entry");
		pn("b.) search by actor");
		pn("c.) search by year");
		pn("d.) search by runtime (in minutes)");
		pn("e.) search by director");
		pn("f.) search by title");
		pn("g.) delete entry");
		pn("h.) quit");	
	}
		
	public void command() {
		p("\nEnter command >");
	}
		
		
	public static <E> void pn(E item){
		System.out.println(item);
	}
		
	public static <E> void p(E item){
		System.out.print(item + " ");
	}
}