import java.util.Scanner;
import java.util.Random;

public class Day4Quiz {
	
	public final static Scanner scanner = new Scanner(System.in);
	public final static Random random = new Random();
	public final static String RAND_PIN = String.valueOf(random.nextInt(100000, 1000000));

	public static void main(String[] args) {
		
		// randomise PIN and print
		System.out.printf(">>> Random PIN generated: %s%n", RAND_PIN);
		
		// welcome & get input
		System.out.println(">>> Welcome to the Bank of ISS");
		System.out.println(">>> Enter your 6-digit PIN: ");
		String input = scanner.nextLine().trim();
		
		// attempts tracker
		int attempts = 0;
		
		do {
			System.out.println(">>> Incorrect PIN. Please try again.");
			input = scanner.nextLine().trim(); // retake input
			attempts++; // update attempt tracker
		} while (!isAuth(input) && attempts < 2);
		
		// final check
		if (!isAuth(input)) {
			System.out.println(">>> Too many wrong PIN entries. Your account is now locked.");
		} else {
			System.out.println(">>> PIN accepted. You can access your account now.");
		}
		
		scanner.close();
		
	}
	
	public static boolean isAuth(String input) {
		return input.equals(RAND_PIN);
	}

}
