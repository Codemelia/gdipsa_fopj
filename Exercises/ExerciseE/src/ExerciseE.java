import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExerciseE {
	
	private final static Scanner scanner = new Scanner(System.in);
		
	public static void main(String[] args) {
		// conv input to number
        // throws exception if input is not number
        try {
            int loop = 1;

            while (loop == 1) {
                // prompt user to select question to run
                System.out.println(">>> Select the function you wish to run:\n1. Q1\n2. Q2\n3. Q3\n4. Q4\n5. Q5\n6. Q6");
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
	/* find factorial of num */
	public static String runQ1() {
		
		System.out.println(">>> Enter a positive integer to find its factorial: ");
		int input = scanner.nextInt();
		scanner.nextLine(); // clear newline
		
		// a. using incr counter
		int ans1 = 1; // init to 1 to multiply later
		for (int i = 0; i < input; i++) { // exclude input number
			ans1 *= input - i; // 5 - 0 > 5 - 1 > 5 - 2 > ...
		}
		
		// b. using decr counter
		int ans2 = 1; // init to 1 to multiply later
		for (int j = input; j > 0; j--) { // last loop stops at 1
			ans2 *= j; // 5 > 4 > 3 > ...
		}
		
		return String.format("Answer using incr counter: %d%nAnswer using decr counter: %d", ans1, ans2);
	}
	
	/* print numbers 1-10 with values of inverse, sqrt, sq */
	public static String runQ2() {
		
		String out = String
				.format("%10s%10s%15s%10s%n------------------------------------------------%n", "NO", "INVERSE", "SQUARE ROOT", "SQUARE");
		
		// decimal format
		DecimalFormat df = new DecimalFormat("#.###");
		
		// loop from 1 to 10 and add values
		for (double i = 1.0; i <= 10.0; i++) {
			out += String.format("%10.1f%10s%15s%10s%n", 
				i, df.format(inverse(i)), df.format(sqRoot(i)), df.format(square(i)));
		}
		
		return out;
	}
	
	public static String runQ3() {
		System.out.println(">>> Enter a positive integer to check whether it is a prime number: ");
		int input = scanner.nextInt();
		scanner.nextLine();
		
		// handle invalid input (negative num)
		if (input <= 0) throw new IllegalArgumentException("Invalid input, number should be > 1.");
		
		// 1-3 are prime nums
		if (input <= 3) return "Prime";
		
		// loop from 2 to input -1 to check for non-prime
		// skip i = 1 and i = input as prime nums are divisible by 1 and itself
		for (int i = 2; i < input; i++) {
			if (input % i == 0) return "Not Prime"; // exits program
		}
		
		return "Prime"; // return prime if program exits loop 
	}
	
	public static String runQ4() {
		
		System.out.println(">>> Enter a positive integer to check whether it is a Perfect Number: ");
		int input = scanner.nextInt();
		scanner.nextLine();
		
		// handle invalid input - 1 and neg num are not perf nums
		if (input <= 1) throw new IllegalArgumentException("Invalid input, input must be a positive number.");

		// sum to sum up factors
		int sum = 0;
		
		// loop from 1 to input - 1
		for (int i = 1; i < input; i++) {
			if (input % i == 0) sum += i;
		}
		
		// if sum != input, return not perfect
		if (sum != input) return "Not Perfect";
		
		// if program reaches here, return perfect
		return "Perfect";
	}
	
	public static String runQ5() {
		
		System.out.println(">>> Here are all the prime numbers from 5 to 1000: ");

		// simplified from array: string builder
		StringBuilder sb = new StringBuilder()
			.append("5"); // start with 5 since it is an odd num
		
		// loop from 7 to 1000
		// skip 6 on start since it is an even num
		// iterate by +2 so that we skip even nums (non prime)
		for (int i = 7; i <= 1000; i += 2) {
			
			// boolean to flag prime nums
			boolean isPrime = true;
			
			// for each odd number, do an inner loop to test if it is a prime num
			// optimisation: only check until sq root of i
			// numbers beyond sq root would not be factor of i
			// start loop from 3 since even numbers were weeded on outer loop
			// iterate by 2 again to skip even nums
			for (int j = 3; j * j <= i; j += 2) { // skips 1 and number itself
				if (i % j == 0) {
					isPrime = false; // flag non prime
					break; // break out of loop
				}
			}
			
			// add prime nums to array
			if (isPrime) sb.append(", " + i);
			
		}
		
		return sb.toString(); // return array aft done
	}
	
	public static String runQ6() {
		
		System.out.println(">>> Here are all perfect numbers from 1 to 1000: ");
		
		// init sb
		StringBuilder sb = new StringBuilder()
			.append(6); // smallest perf num
		
		// loop from 6 to 1000
		// 1 is not a perf num
		// smallest perf num is 6, start above it
		for (int i = 7; i <= 1000; i++) {
			
			// init sum
			// always starts with 1
			int sum = 1;
			
			// inner loop to test sum of factors
			// check until half of num - factors should not go above half
			for (int j = 2; j <= i / 2; j++) {
				if (i % j == 0) sum += j;
			}
			
			if (sum == i) sb.append(", " + i);
			
		}
		
		return sb.toString();
	}
	
	// select function
	public static String selectFunction(int selected) {
		switch(selected) {
			case 1: return runQ1();
			case 2: return runQ2();
			case 3: return runQ3();
			case 4: return runQ4();
			case 5: return runQ5();
			case 6: return runQ6();
			default: throw new IllegalArgumentException("Input is out of range.");
		}
	}
	
	// helpers
	public static double inverse(double n) { return 1 / n; }
	public static double sqRoot(double n) { return Math.sqrt(n); }
	public static double square(double n) { return n * n; }
	
}
