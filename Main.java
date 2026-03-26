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
            int randomNumber = Rand.randomInt(0, 3); // could generate 0, 1, or 2
            
            // member and book
            Member m;
            Book b;

            switch (randomNumber) {
            case 0: // No action
            	System.out.println("Nothing happens.");
            	break;
            case 1: // Take out book
            	m = lib.members[Rand.randomInt(0, numMembers)];
            	b = lib.books[Rand.randomInt(0, numMembers)];
            	if (b.isTaken) {
                	System.out.println(m.name + " tried to take " + b.title + ", but it was already taken.");
            	} else if (m.book != null) {
            		System.out.println(m.name + " tried to take " + b.title + ", but it already has a book.");
            	} else {
            		m.book = b;
                	b.isTaken = true;
                	System.out.println(m.name + " has taken " + b.title);
            	}
            	break;
            case 2: // Give back book
            	m = lib.members[Rand.randomInt(0, numMembers)];
            	b = lib.books[Rand.randomInt(0, numMembers)];
            	if (!b.isTaken) {
            		System.out.println(m.name + " tried to give " + b.title + ", but the book was not taken out.");
            	} else if (m.book != b) {
            		System.out.println(m.name + " tried to give " + b.title + ", but they don't have it.");
            	} else {
            		m.book = null;
            		b.isTaken = false;
            		System.out.println(m.name + " has given " + b.title);
            	}
            	break;
            case 3: // Reading a book
            	m = lib.members[Rand.randomInt(0, numMembers)];
            	System.out.println(m.name + " came in today to their book, " + m.book.title + " by " + m.book.author + ", having " + m.book.pages + " pages!");
            	break;
            }

            Input.waitForUserToPressEnter("Press Enter to simulate the next day.");
        }
    }
}