
public class Book {
	// fields to be initialized
	private String title;
	private String author;
	private int pages;
	private int id;
	
	// non-initialized fields
	private boolean isTaken;
	
	// Constructor
	public Book(String title, String author, int pages, int id) {
		this.title = title;
		this.author = author;
		this.pages = pages;
		this.id = id;
	}
	
	// Getters and Setters
	public boolean getIsTaken() {
		return isTaken;
	}
	
	public void setIsTaken(boolean isTaken) {
		this.isTaken = isTaken;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}

	public int getPages() {
		return pages;
	}
	
	public int getId() {
		return id;
	}
}
