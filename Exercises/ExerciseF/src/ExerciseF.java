import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ExerciseF {

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
	public static String runQ1() {
		System.out.println(">>> Enter a phrase to count the number of vowels in it: ");
		String input = scanner.nextLine()
			.trim()
			.toLowerCase();
		
		// init vowel counters
		int a = 0, e = 0, i = 0, o = 0, u = 0;
		
		// conv input to char array
		char[] arr = input.toCharArray();
		
		// loop through char array to check each vowel
		for (char c : arr) {
			
			// use switch statement to check vowels
			switch (c) {
				case 'a':
					a++;
					break;
				case 'e':
					e++;
					break;
				case 'i':
					i++;
					break;
				case 'o':
					o++;
					break;
				case 'u':
					u++;
					break;
			}
			
		}
		
		// calc total aft finish check
		int total = a + e + i + o + u;
		
		// return total count and indiv counts
		return String.format("Total count: %d%nCount of each vowel: A - %d E - %d I - %d O - %d U - %d",
			total, a, e, i, o, u);
		
		/* 
		 * hashmap method
				// init vowel string
				String vowels = "aeiou";
				
				// a. counter
				int count = 0;
				
				// b. hashmap to map count to vowels
				Map<Character, Integer> vowMap = new HashMap<>();
				
				// loop thru chars in input to count vowels
				for (int i = 0; i < input.length(); i++) {
					char currVow = input.charAt(i);
					for (int j = 0; j < vowels.length(); j++) {
						if (currVow == vowels.charAt(j)) {
							count++; // update total count
							vowMap.put(currVow, vowMap.getOrDefault(currVow, 0) + 1); // update map
						}
					}
				}
				
				return String.format("Total count: %d%nCount of each vowel: A - %d E - %d I - %d O - %d U - %d",
					count, vowMap.getOrDefault('a', 0), 
					vowMap.getOrDefault('e', 0), vowMap.getOrDefault('i', 0), 
					vowMap.getOrDefault('o', 0), vowMap.getOrDefault('u', 0));
		 */
	}
	
	public static String runQ2() {
		System.out.println(">>> Enter a word/phrase to test if it is a palindrome: ");
		String input = scanner.nextLine();
		
		// conv input to char array
		char[] arr = input.toCharArray();
		
		// pointers
		int p1 = 0;
		int p2 = arr.length - 1;
		
		// loop while p1 < p2 to check if both char is same
		while (p1 < p2) {
			if (arr[p1] != arr[p2]) {
				return "Not Palindrome"; // exits program once unmatched
			}
			
			// move pointers toward middle
			p1++;
			p2--;
		}
		
		// if program reaches here, input is a palindrome
		return "Palindrome";
	}
	
	public static String runQ3() {
		
		System.out.println(">>> Enter a word/phrase to test if it is a palindrome: ");
		String input = scanner.nextLine()
			.toLowerCase(); // ignore upper case diff
		
		// conv input to char array
		char[] arr = input.toCharArray();
		
		// list of punctuation
		String punct = ",./<>?;\':\"[]\\{}|`~!@#$%^&**()-=_+";
		
		// pointers
		int p1 = 0;
		int p2 = arr.length - 1;
		
		// loop while p1 < p2 to check if both char is same
		while (p1 < p2) {
			
			// if curr char is punctuation/space, skip
			if (arr[p1] == ' ' || punct.contains(String.valueOf(arr[p1]))) {
				p1++;
				continue;
			}
			
			if (arr[p2] == ' ' || punct.contains(String.valueOf(arr[p2]))) {
				p2--;
				continue;
			}
			
			if (arr[p1] != arr[p2]) {
				return "Not Palindrome"; // exits program once unmatched
			}
			
			// move pointers toward middle
			p1++;
			p2--;
		}
		
		// if program reaches here, input is a palindrome
		return "Palindrome";

	}
	
	public static String runQ4() {
		System.out.println(">>> Enter a sentence/phrase to convert it to title case: ");
		String input = scanner.nextLine();
		
		// conv to char array
		char[] arr = input.toCharArray();
		
		// using manual way
		// loop thru char array
		for (int i = 0; i < arr.length; i++) {
			char curr = arr[i];
			
			if ((i == 0 || arr[i - 1] == ' ')) {
				if (curr >= 'a' && curr <= 'z') arr[i] = (char) (curr - 32); // if char is lowercase, conv to uppercase
			} else {
				if (curr >= 'A' && curr <= 'Z') arr[i] = (char) (curr + 32); // if char is uppercase (not supposed to), conv to lowercase
			}
		}
		
		/* 
		  	//using char class methods		
			// loop thru char array to find start of words
			for (int i = 0; i < arr.length; i++) {
				char curr = arr[i]; // curr char
				if (i == 0 || arr[i - 1] == ' ') {
					if (Character.isUpperCase(curr)) continue; // skip correct uppercase
					arr[i] = Character.toUpperCase(curr); // conv first char of each word to upper case
				}
				else if (Character.isUpperCase(curr)) arr[i] = Character.toLowerCase(curr); // conv rest to lower case
			} 
		*/
		
		return String.valueOf(arr);
	}
	
	public static String runQ5() {
		// init both arrays
		String[] names = { "John", "Venkat", "Mary", "Victor", "Betty" };
		int[] marks = { 63, 29, 75, 82, 55 };
		
		int len = names.length;
		
		// a. descending order of marks
		// bubble sorting - pair wise sort from front of arr
		/*
			for (int i = 0; i < len - 1; i++) { // loop from front of arr
				for (int j = 0; j < len - 1 - i; j++) { // loop from front of arr until last idx (alr sorted)
					if (marks[j] < marks[j + 1]) {
						int tempMarks = marks[j];
						marks[j] = marks[j + 1];
						marks[j + 1] = tempMarks;
					
						String tempName = names[j];
						names[j] = names[j + 1];
						names[j + 1] = tempName;
					}
				}
			}
		*/
		
		// selection sorting - whole sort from back of arr
		for (int i = len - 1; i >= 0; i--) { // loop from back of arr
			int minIdx = i;
			for (int j = 0; j < i; j++) { // inner loop normally from start to compare each num to num at index i
				if (marks[j] < marks[minIdx]) minIdx = j; // if num at later idx is smaller than min idx, replace idx
			}
			if (minIdx != i) { // only update array if min index has changed
				int tempMarks = marks[minIdx];
				marks[minIdx] = marks[i]; // move first mark to smallest mark place
				marks[i] = tempMarks; // move smallest mark to first mark place
				
				String tempName = names[minIdx];
				names[minIdx] = names[i];
				names[i] = tempName;
			}
		}
		
		// form string for marks sorted
		StringBuilder sb = new StringBuilder();
		for (int k = 0; k < len; k++) {
			sb.append(String.format("%6s | %2d%n", names[k], marks[k]));
		}
		
		// b. alphabetical order
		// bubble sorting - pair wise sort; move higher alphabet to back of arr
		/*
			for (int a = 0; a < len - 1; a++) {
				for (int b = 0; b < len - 1 - a; b++) {
					if (names[b].charAt(0) > names[b + 1].charAt(0)) {
						String tempName = names[b];
						names[b] = names[b + 1];
						names[b + 1] = tempName;
						
						int tempMarks = marks[b];
						marks[b] = marks[b + 1];
						marks[b + 1] = tempMarks;
					}
				}
			}
		*/
		
		// selection sorting - whole sort; move lower alphabet to front of arr
		for (int a = 0; a < len; a++) {
			int minIdx = a; // idx for min num
			for (int b = a + 1; b < len; b++) {
				if (names[b].charAt(0) < names[minIdx].charAt(0)) minIdx = b; // if first letter of name lower than letter at min idx, replace it
			}
			if (minIdx != a) { // only enter if minIdx has changed
				String tempName = names[minIdx]; // store name with lower char
				names[minIdx] = names[a]; // move name with lower char to curr idx
				names[a] = tempName; // move name with higher char to prev idx of name with lower char
				
				int tempMarks = marks[minIdx]; // store score of name with lower char
				marks[minIdx] = marks[a]; // move score to curr idx
				marks[a] = tempMarks; // move score of name w higher char to prev idx of score of name w lower char
			}
		}
		
		// form string for names sorted
		sb.append("\n"); // space
		for (int c = 0; c < len; c++) {
			sb.append(String.format("%6s | %2d%n", names[c], marks[c]));
		}
		
		return sb.toString();
	}
	
	public static String runQ6() {
		System.out.println(">>> Enter your matriculation number for validation: ");
		String input = scanner.nextLine()
			.trim();
		
		// if first number doesnt start with A, error
		if (!input.startsWith("A")) return "Your matriculation number is invalid.";
		
		// length
		int len = input.length();
		
		// init sum
		int sum = 0;
		
		// loop char array and calc sum of digits
		for (int i = 1; i < len - 1; i++) {
			sum += Integer.parseInt(input.substring(i, i + 1));
		}
		
		// retrieve remainder when div by 5
		int rem = sum % 5;
		
		// retrieve correct checksum via rem
		char correct = 0;
		switch(rem) {
			case 0:
				correct = 'O';
				break;
			case 1:
				correct = 'P';
				break;
			case 2:
				correct = 'Q';
				break;
			case 3:
				correct = 'R';
				break;
			case 4:
				correct = 'S';
				break;
			default:
				return "Your matriculation number is invalid.";
		}
		
		// use rem to check checksum
		char check = input.charAt(len - 1);
		if (check != correct) return "Your matriculation number is invalid.";
		
		// program reaches here if num is valid
		return "Your matriculation number is valid.";
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

}
