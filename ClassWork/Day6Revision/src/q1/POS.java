package q1;

import java.util.Scanner;

// 1. create a new class called POS
public class POS {
	
	// 5. create static constant variable to store username and PIN
	public final static String VALID_USER = "superman";
	public final static int VALID_PIN = 1234;
	
	// 7a. create static constant to store max num of incorrect attempts
	public final static int MAX_ATTEMPTS = 3;
	
	// variables to take in user input/pin
	public static String username;
	public static int pin;
	
	private final static Scanner in = new Scanner(System.in);
	
	// 2. create entry point from where jvm begins execution
	public static void main(String[] args) {
		
		// 3. write instructions to print following
		System.out.println(">>> Welcome to POS!");
		
		// track validity
		boolean isValid = false;
		
		// track num of attempts
		int attempts = 0;
		
		// while user and pin invalid, loop
		// 6a. write instructions to prompt user for username and PIN
		while (attempts < MAX_ATTEMPTS && !isValid) {
			
			// 4. write instructions for user to enter username and PIN
			System.out.println(">>> Please enter your username: ");
			username = in.nextLine();
			
			System.out.println(">>> Please enter your PIN: ");
			
			try {
				pin = Integer.parseInt(in.nextLine());
				
				// update valid flag
				if (username.equals(VALID_USER) && pin == VALID_PIN) {
					System.out.printf(">>> Welcome %s, you are now logged in.%n", username); // success message
					isValid = true;
				} else {
					// 6b. print error message
					attempts++; // incr attempts tracker
					if (attempts < MAX_ATTEMPTS) System.out.println(">>> Invalid username or PIN. Please try again.");
				}

			} catch (Exception ex) {
				attempts++; // incr attempts tracker
				if (attempts < MAX_ATTEMPTS) System.out.println(">>> Invalid username or PIN. Please try again.");
			}
			
		}
		
		// on exit of while loop, print fail attempts message if not valid
		if (!isValid) System.out.printf("You have exceeded %d attempts. Exiting program...%n", MAX_ATTEMPTS);
		
		in.close();
		
	}

}
