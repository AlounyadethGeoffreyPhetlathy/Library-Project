// Simulation
public class Main {
    public static void main(String[] args) {
    	
    	// Simulation variables
    	int numMembers = 5;
    	int numBooks = 5;
    	
    	// Get the nescessary classes
        Library lib = new Library(numMembers,numBooks);

        while (true) {

            // Advance time
            lib.setCurrentDay(lib.getCurrentDay() + 1);
            System.out.println("\n--- Day " + lib.getCurrentDay() + " ---");

            // simulate a random event
            int randomNumber = Rand.randomInt(0, 4); // could generate 0, 1, 2, or 3
            
            // member and book
            Member m;
            Book b;

            switch (randomNumber) {
            case 0: // No action
            	System.out.println("Nothing happens.");
            	break;
            case 1: // Take out book
            	m = lib.pickMember(numMembers);
            	b = lib.pickBook(numBooks);
            	if (b.getIsTaken()) {
                	System.out.println(m.getMemberName() + " tried to take " + b.getTitle() + ", but it was already taken.");
            	} else if (m.getMemberBook() != null) {
            		System.out.println(m.getMemberName() + " tried to take " + b.getTitle() + ", but they already have a book.");
            	} else {
            		m.setMemberBook(b);
                	b.setIsTaken(true);
                	System.out.println(m.getMemberName() + " has taken " + b.getTitle());
            	}
            	break;
            case 2: // Give back book
            	m = lib.pickMember(numMembers);
            	if (m.getBorrowTime() >= 14) {
            		System.out.println(m.getMemberName() + " has given " + m.getMemberBook().getTitle() + " and paid a late fee of $" + m.getMemberLoan().getPrice());
            		// Learned something called method chaining
            		m.getMemberBook().setIsTaken(false);
            		m.setMemberBook(null);
            		m.setBorrowTime(0);
            		m.getMemberLoan().setPrice(0f);
            	} else if (m.getMemberBook() != null) {
            		System.out.println(m.getMemberName() + " has given " + m.getMemberBook().getTitle());
            		m.getMemberBook().setIsTaken(false);
            		m.setMemberBook(null);
            		m.setBorrowTime(0);
            	}
            	else {
            		System.out.println(m.getMemberName() + " tried to give a book, but they don't have any.");
            	}
            	break;
            case 3: // Reading a book
            	m = lib.pickMember(numMembers);
            	if (m.getMemberBook() != null) {
            		System.out.println(m.getMemberName() + " came in today to read their book, " + m.getMemberBook().getTitle() + " by " + m.getMemberBook().getAuthor() + ", having " + m.getMemberBook().getPages() + " pages!");
            	} else {
            		System.out.println(m.getMemberName() + " tried reading a book, but they don't have any.");
            	}
            	break;
            }
            
            // For each day since they have taken a book, a counter called borrowTime is incremented
            for (Member mem : lib.getMembers()) {
            	if (mem.getMemberBook() != null) mem.incrementBorrowTime();
            	if (mem.getBorrowTime() >= 14) mem.getMemberLoan().setPrice(Rand.randomFloat(10f, 30f));
            }

            Input.waitForUserToPressEnter("Press Enter to simulate the next day.");
        }
    }
}