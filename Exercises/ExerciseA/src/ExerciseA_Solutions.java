import java.util.Scanner;

public class ExerciseA_Solutions {
	
	final static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		
		// Q1
		// Print the results
		System.out.println("John Smith");
		System.out.println("e0011223@u.nus.edu");
		
		// Q2
		System.out.print("Enter your name: ");  // Show prompting message
		String str = in.next(); 
		
		System.out.println("Good Morning " + str);
		
		// Q3
		System.out.print("Enter your integer number: ");  // Show prompting message
		int num3 = in.nextInt(); 
		
		System.out.println(num3*num3);
		
		// Q4
		System.out.print("Enter your double number: ");  // Show prompting message
		double num4 = in.nextDouble(); 
		
		System.out.println(num4*num4);
		
		// Q5
		double num5;
		System.out.print("Enter your double number: ");  // Show prompting message
		num5 = in.nextDouble(); 
		
		String formatted_str = String.format("%.2f", num5); //Turns the double number into string with 2 decimals
		
		System.out.println(formatted_str);
		
		in.close();
		
	}

}
