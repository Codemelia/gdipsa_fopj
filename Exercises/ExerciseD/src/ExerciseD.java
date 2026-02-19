import java.util.Scanner;
import java.util.Random;

public class ExerciseD {

	private final static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// conv input to number
        // throws exception if input is not number
        try {
            int loop = 1;

            while (loop == 1) {
                // prompt user to select question to run
                System.out.println(">>> Select the function you wish to run:\n1. Q1\n2. Q2\n3. Q3");
                int input = scanner.nextInt();
                scanner.nextLine(); // clears newline in buffer from nextInt()

                // run respective function based on input
                // invalid input is handled by throwing exception
                String output = selectFunction(input);
                System.out.printf(">>> Output:\n%s\n", output);

                // ask if user wishes to continue
                System.out.println(">>> Would you like to run another function? (Y/N)");
                String cont = scanner.nextLine().trim().toLowerCase();

                // if user does not want to continue, exit loop; else continue
                if (!cont.equals("yes") && !cont.equals("y")) { loop = 0; } 
            }
            
            // close scanner
            scanner.close();

        } catch (Exception ex) {
            System.out.println(">>> Invalid input! Please enter your input as instructed");
            scanner.close();
            return; // exit program
        }
	}
	
	// run functions
	public static String runQ1() {
		int num = 0; // init
		
		// loop until user enters 88
		while (num != 88) {
			System.out.println(">>> Enter an integer number: ");
			num = scanner.nextInt();
			scanner.nextLine();
		}
		
		// output upon exit
		return ("Lucky you...");
	}
	
	public static String runQ2() {
		System.out.println(">>> Enter number A: ");
		int nA = scanner.nextInt();
		scanner.nextLine();
		
		System.out.println(">>> Enter number B: ");
		int nB = scanner.nextInt();
		scanner.nextLine();
		
		// find gcd which is hcf
		// int hcf = gcd(nA, nB);
		
		// manual working of gcd
		int tempA = nA, tempB = nB;
		while (tempB != 0) {
			int rem = tempA % tempB; // store remainder in a var to prevent inaccurate calcs following this line
			tempA = tempB; // replace tempA with tempB first to prevent inaccurate tempB moving forward
			tempB = rem; // now tempB is replaced with remainder that was alr calculated
		}
		
		// when nB == 0, assign hcf
		int hcf = tempA;
		
		// calc lcm
		int lcm = (nA * nB) / hcf;
		
		return String.format("HCF: %d\nLCM: %d", hcf, lcm);
	}
	
	public static String runQ3() {
		// gen random number
		int rand = (int) new Random().nextInt(0, 10); // 0-9
		
		// init guess
		int guess = -1;
		
		// init count
		int count = 0;
		
		// keeps looping until user guesses within range
		while (guess != rand) {
			
			if (count == 0) {
				System.out.println(">>> Guess the number in my mind (0-9): ");
			} else {
				System.out.println(">>> Try again!");
			}
			
			guess = scanner.nextInt();
			scanner.nextLine();
			
			count += 1;
		}
		
		// a. once user guesses correctly, congratulate and state num of attempts
		// return String.format(">>> You guessed it, the number was %d! You took %d attempts to guess it correctly%n", guess, count);
		
		// b. congratulate according to number of attempts
		if (count <= 2) {
			return String.format("You are a Wizard! You took %d attempt(s) to guess it right%n", count);
		} else if (count <= 5) {
			return String.format("You are a good guesser! You took %d attempt(s) to guess it right%n", count);
		} else {
			return String.format("You are lousy! You took %d attempt(s) to guess it right%n", count);
		}
	}
	
	// helpers
	public static int gcd(int a, int b) {
		if (b == 0) return a; // if int that is replaced = 0, return the constant int
		return gcd(b, a % b); // else recurse while replacing int b with a % b each time, and moving int b up to int a
	}
	
	// select function based on input
    public static String selectFunction(int selected) {

        switch (selected) {
            case 1: return runQ1();
            case 2: return runQ2();
            case 3: return runQ3();

            default: throw new IllegalArgumentException("Input is out of range.");
        }
	}

}
