//Represents the entire library system
class Library {

    private int currentDay; // Current simulation day

    // add more fields here
    private Member[] members;
    private Book[] books;

    // add constructor(s) here
    /* no methods is an interesting challenge for this assignment. 
     * My idea here is to use while loops in the constructor to generate members and books.
     * 
     * So far, it knows how many to generate each, working from the end of the array first. But can't generate
     * random names or titles, so generic placeholders it is then.
     */
    public Library(int numMembers, int numBooks) {
    	this.members = new Member[numMembers];
    	numMembers -= 1;
    	while (numMembers >= 0) {
    		this.members[numMembers] = new Member("Member " + numMembers);
    		numMembers--;
    	}
    	
    	this.books = new Book[numBooks];
    	numBooks -= 1;
    	while (numBooks >= 0) {
    		this.books[numBooks] = new Book("Book " + numBooks, "Author " + numBooks, Rand.randomInt(20, 400), numBooks);
    		numBooks--;
    	}
    }
    
    // Library methods
    public int getCurrentDay() {
    	return currentDay;
    }
    
    public void setCurrentDay(int currentDay) {
    	this.currentDay = currentDay;
    }
    
    public Member[] getMembers() {
    	return members;
    }
    
    public Member pickMember(int numMembers) {
    	return members[Rand.randomInt(0, numMembers)];
    }
    
    public Book pickBook(int numBooks) {
    	return books[Rand.randomInt(0, numBooks)];
    }

}