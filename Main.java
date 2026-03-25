// Simulation
public class Main {
    public static void main(String[] args) {
    	
    	// Hardcoded variables
    	int numMembers = 3;
    	int numBooks
    	
    	// Get the nescessary classes
        Library lib = new Library(3,3);

        while (true) {

            // Advance time
            lib.currentDay = lib.currentDay + 1;
            System.out.println("\n--- Day " + lib.currentDay + " ---");

            // simulate a random event
            int randomNumber = Rand.randomInt(0, 4); // could generate 0, 1, 2, or 3

            switch (randomNumber) {
            case 0:
            	System.out.println("A member takes out a book");
            }

            Input.waitForUserToPressEnter("Press Enter to simulate the next day.");
        }
    }
}