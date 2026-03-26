//Represents the entire library system
class Library {

    int currentDay; // Current simulation day

    // add more fields here
    Member[] members;
    Book[] books;

    // add constructor(s) here
    /* no methods is an interesting challenge. 
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

}