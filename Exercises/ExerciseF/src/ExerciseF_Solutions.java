import java.util.Scanner;

public class ExerciseF_Solutions {

    static final Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
        
		// Q1
        System.out.print("Please enter a phrase: ");
        String phrase1 = in.nextLine();

        int count = 0;
        String[] vowels = { "a", "e", "i", "o", "u" };
        String vowels_string = "aeiou";
        int[] vowelCount = new int[5];

        for (int i = 0; i < phrase1.length(); i++) {
            String c = phrase1.substring(i, i + 1).toLowerCase();
            if (vowels_string.contains(c)) { /////// double check this, 2 methods are available, contain or regex, regex isnt taught yet, contain might import package.
                count++;
                for (int j = 0; j < 5; j++) {
                    if (c.equals(vowels[j])) {
                        vowelCount[j]++;
                    }
                }
            }
        }
        
//        Below is the char method

//        char[] vowels = { 'a', 'e', 'i', 'o', 'u' };
//        int[] vowelCount = new int[5];
//
//        for (int i = 0; i < phrase.length(); i++) {
//            char c = Character.toLowerCase(phrase.charAt(i));
//            if (c >= 'a' && c <= 'z') { // Check if it's an alphabet character
//                for (int j = 0; j < 5; j++) {
//                    if (c == vowels[j]) {
//                        count++;
//                        vowelCount[j]++;
//                        break; // Once a vowel is found, no need to check further
//                    }
//                }
//            }
//        }
        
        System.out.println("Total number of vowels: " + count);
        for (int i = 0; i < 5; i++) {
            System.out.println("Number of " + vowels[i] + ": " + vowelCount[i]);
        }
        
        // Q2
        System.out.print("Please enter a phrase: ");
        String phrase2 = in.nextLine();

        String reversePhrase2 = "";

        // Generate reverse phrase
        for (int i = phrase2.length() - 1; i >= 0; i--) {
        	reversePhrase2 += phrase2.charAt(i);
        }

        if (phrase2.equals(reversePhrase2)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }
        
        // Q3
        System.out.print("Please enter a phrase: ");
        String phrase3 = in.nextLine();

        phrase3 = phrase3.toLowerCase();
        String newPhrase3 = "";
        String reversePhrase3 = "";
        String listOfPunctuations = ".;!?, ";

        // Remove all the punctuations
        for (int i = 0; i < phrase3.length(); i++) {
            char ch = phrase3.charAt(i);
            if (!listOfPunctuations.contains(String.valueOf(ch))) {
                newPhrase3 += ch;
            }
        }

        // Generate reverse phrase
        int len = newPhrase3.length() - 1;
        while (len >= 0) {
        	reversePhrase3 += newPhrase3.charAt(len);
            len--;
        }

        if (newPhrase3.equals(reversePhrase3)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }
        
        // Q4
        System.out.print("Please enter a phrase: ");
        String phrase4 = in.nextLine();

        String[] words = phrase4.split(" ");
        
        // Capitalize the first letter of each word
        for (int i = 0; i < words.length; i++) {
            if (!words[i].isEmpty()) {
                words[i] = Character.toUpperCase(words[i].charAt(0)) + words[i].substring(1);
            }
        }

        // Reconstruct the phrase
        String newPhrase4 = String.join(" ", words);
        System.out.println(newPhrase4);
        
        // Q5
        // Store values as 2-dimensional string array
        String[][] arr5 = new String[][] { { "John", "63" }, { "Venkat", "29" }, { "Mary", "75" }, { "Victor", "82" }, { "Betty", "55" } };

        // Descending order bubble sort based on marks
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                if (Integer.parseInt(arr5[j][1]) < Integer.parseInt(arr5[j + 1][1])) {
                    swap(j, arr5);
                }
            }
        }

        System.out.println("Sorted by order of Marks descendingly\n");
        for (int i = 0; i < 5; i++) {
            System.out.println(arr5[i][0] + " " + arr5[i][1]);
        }

        // Ascending order bubble sort based on student name alphabetically
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                if (arr5[j][0].compareTo(arr5[j + 1][0]) > 0) {
                    swap(j, arr5);
                }
            }
        }

        System.out.println("\nSorted by student name alphabetically\n");
        for (int i = 0; i < 5; i++) {
            System.out.println(arr5[i][0] + " " + arr5[i][1]);
        }
        
        // Q5 alt
        // The data
        String[] names = { "John", "Venkat", "Mary", "Victor", "Betty" };
        int[] marks = { 63, 29, 75, 82, 55 };
        
        // Part A - Sorting marks in descending order
        int[] marksDesc = new int[] { 0, 1, 2, 3, 4 };
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 5; j++) {
                if (marks[marksDesc[i]] < marks[marksDesc[j]]) {
                    // Swap the order
                    int temp = marksDesc[i];
                    marksDesc[i] = marksDesc[j];
                    marksDesc[j] = temp;
                }
            }
        }

        // Display sorted marks
        System.out.println("Sorted by marks in descending order:");
        for (int i = 0; i < 5; i++) {
            System.out.println(names[marksDesc[i]] + "\t" + marks[marksDesc[i]]);
        }

        System.out.println();

        // Part B - Sorting names in ascending order
        int[] namesAsc = new int[] { 0, 1, 2, 3, 4 };
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 5; j++) {
                if (names[namesAsc[i]].compareTo(names[namesAsc[j]]) > 0) {
                    // Swap the order
                    int temp = namesAsc[i];
                    namesAsc[i] = namesAsc[j];
                    namesAsc[j] = temp;
                }
            }
        }

        // Display sorted names
        System.out.println("Sorted by student name alphabetically:");
        for (int i = 0; i < 5; i++) {
            System.out.println(names[namesAsc[i]] + "\t" + marks[namesAsc[i]]);
        }
        
        // Q6
        System.out.print("Enter a matriculation number: ");
        String input = in.nextLine();
        in.close();

        // If not 7 characters
        if (input.length() != 7) {
            // Invalid
            System.out.println("Invalid");
        } else {
            // Convert input into uppercase
            input = input.toUpperCase();

            // Calculate checksum
            int sum = 0;
            // Take 1st digit and multiply with 6
            int d1 = Integer.parseInt(input.substring(1,2));
            sum += d1 * 6;
            // Take 2nd digit and multiply with 5
            int d2 = Integer.parseInt(input.substring(2,3));
            sum += d2 * 5;
            // Take 3rd digit and multiply with 4
            int d3 = Integer.parseInt(input.substring(3,4));
            sum += d3 * 4;
            // Take 4th digit and multiply with 3
            int d4 = Integer.parseInt(input.substring(4,5));
            sum += d4 * 3;
            // Take 5th digit and multiply with 2
            int d5 = Integer.parseInt(input.substring(5,6));
            sum += d5 * 2;
            // Calculate the sum
            // Divide by 5 and get the remainder
            int remainder = sum % 5;

            // Map the remainder to the checksum
            String checksum = "";
            switch (remainder) {
                case 0:
                    checksum = "O";
                    break;
                case 1:
                    checksum = "P";
                    break;
                case 2:
                    checksum = "Q";
                    break;
                case 3:
                    checksum = "R";
                    break;
                case 4:
                    checksum = "S";
                    break;
            }

            // If last char matches checksum
            String lastChar = input.substring(6, 7);
            if (lastChar.equals(checksum)) {
                // Valid
                System.out.println("Valid");
            } else {
                // Invalid
                System.out.println("Invalid");
            }
        }

        in.close();
    }
	
	// Q5 helper
	static void swap(int j, String[][] arr) {
        // Swapping method
        String tempName = arr[j][0];
        String tempMarks = arr[j][1];
        arr[j][0] = arr[j + 1][0];
        arr[j][1] = arr[j + 1][1];
        arr[j + 1][0] = tempName;
        arr[j + 1][1] = tempMarks;
    }

}
