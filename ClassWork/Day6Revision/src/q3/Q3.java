package q3;

import java.util.Scanner;

public class Q3 {
	
	final static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		
		// user input
		System.out.println(">>> Enter a string: ");
		String input = in.nextLine();
		System.out.printf(">>> Original string: %s%n", input);
		
		// Part 1
		String subArr1 = subReplace(input);
		System.out.printf(">>> New string via String.replace(): %s%n", subArr1);
		
		// Part 2
		String subArr2 = subCharAt(input);
		System.out.printf(">>> New string via String.charAt(): %s%n", subArr2);
		
	}
	
	public static String subReplace(String s) {	
		return s.replace("o", "a"); // replace all o's with a's
	}
	
	public static String subCharAt(String s) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) { // replace all e's with i's
			if (s.charAt(i) == 'e') sb.append('i');
			else sb.append(s.charAt(i));
		}
		return sb.toString();
	}

}
