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
            lib.currentDay = lib.currentDay + 1;
            System.out.println("\n--- Day " + lib.currentDay + " ---");

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
            	m = lib.members[Rand.randomInt(0, numMembers)];
            	b = lib.books[Rand.randomInt(0, numBooks)];
            	if (b.isTaken) {
                	System.out.println(m.name + " tried to take " + b.title + ", but it was already taken.");
            	} else if (m.book != null) {
            		System.out.println(m.name + " tried to take " + b.title + ", but they already have a book.");
            	} else {
            		m.book = b;
                	b.isTaken = true;
                	System.out.println(m.name + " has taken " + b.title);
            	}
            	break;
            case 2: // Give back book
            	m = lib.members[Rand.randomInt(0, numMembers)];
            	if (m.borrowTime >= 14) {
            		System.out.println(m.name + " has given " + m.book.title + " and paid a late fee of $" + m.loan.price);
            		m.book.isTaken = false;
            		m.book = null;
            		m.borrowTime = 0;
            		m.loan.price = 0f;
            	} else if (m.book != null) {
            		System.out.println(m.name + " has given " + m.book.title);
            		m.book.isTaken = false;
            		m.book = null;
            		m.borrowTime = 0;
            	}
            	else {
            		System.out.println(m.name + " tried to give a book, but they don't have any.");
            	}
            	break;
            case 3: // Reading a book
            	m = lib.members[Rand.randomInt(0, numMembers)];
            	if (m.book != null) {
            		System.out.println(m.name + " came in today to read their book, " + m.book.title + " by " + m.book.author + ", having " + m.book.pages + " pages!");
            	} else {
            		System.out.println(m.name + " tried reading a book, but they don't have any.");
            	}
            	break;
            }
            
            // For each day since they have taken a book, a counter called borrowTime is incremented
            for (Member mem : lib.members) {
            	if (mem.book != null) mem.borrowTime++;
            	if (mem.borrowTime >= 14) mem.loan.price = Rand.randomFloat(10f, 30f);
            }

            Input.waitForUserToPressEnter("Press Enter to simulate the next day.");
        }
    }
}