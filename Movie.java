package Main;

public class Movie {
	// Fields
	private String title;
	private String actor1;
	private String actor2;
	private String director;
	private int year;
	private int runtimeMinutes;
	
	// Constructor
	public Movie(String title, int year, int runtimeMinutes, String actor1, String actor2, String director){
		this.title = title;
		this.year = year;
		this.runtimeMinutes = runtimeMinutes;
		this.actor1 = actor1;
		this.actor2 = actor2;
		this.director = director;
	}
	
	// Methods
	public String getTitle(){
		return title;
	}
	
	public int getYear(){
		return year;	
	}
	
	public int getRuntime(){
		return runtimeMinutes;	
	}
	
	public String getActor1(){
		return actor1;
	}
	
	public String getActor2(){
		return actor2;
	}
	
	public String getDirector(){
		return director;
	}
	
}