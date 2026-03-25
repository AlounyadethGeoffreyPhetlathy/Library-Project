
public class Book {
	// fields to be initialized
	String title;
	String author;
	int pages;
	int id;
	
	// non-initialized fields
	boolean isTaken;
	
	public Book(String title, String author, int pages, int id) {
		this.title = title;
		this.author = author;
		this.pages = pages;
		this.id = id;
	}
}
