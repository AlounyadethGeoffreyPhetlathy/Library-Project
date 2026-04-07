
public class Member {
	// Fields
	String name;
	Book book;
	Loan loan;
	int borrowTime;
	
	// Constructor
	public Member(String name) {
		this.name = name;
		this.loan = new Loan();
	}
}
