
public class Member {
	// Fields
	private String name;
	private Book book;
	private Loan loan;
	private int borrowTime;
	
	// Constructor
	public Member(String name) {
		this.name = name;
		this.loan = new Loan();
	}
	
	// Getters and Setters
	public Book getMemberBook() {
		return book;
	}
	
	public void setMemberBook(Book book) {
		this.book = book;
	}
	
	public String getMemberName() {
		return name;
	}
	
	public int getBorrowTime() {
		return borrowTime;
	}
	
	public void setBorrowTime(int borrowTime) {
		this.borrowTime = borrowTime;
	}
	
	public Loan getMemberLoan() {
		return loan;
	}
	
	// Other methods
	public void incrementBorrowTime() {
		borrowTime++;
	}
}
