import java.util.Arrays;
import java.util.Scanner;

public class ExerciseH {

private final static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		// conv input to number
        // throws exception if input is not number
        try {
            int loop = 1;

            while (loop == 1) {
                // prompt user to select question to run
                System.out.println(">>> Select the function you wish to run:\n1. Q1\n2. Q2\n3. Q3\n4. Q4\n5. Q5 \n6. Q6\n7. Q7");
                int input = scanner.nextInt();
                scanner.nextLine(); // clears newline in buffer from nextInt()

                // run respective function based on input
                // invalid input is handled by throwing exception
                selectFunction(input);

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
	
	// select function
	public static void selectFunction(int selected) {
		switch(selected) {
			case 1:
				int out1 = readInteger(">>> Enter an integer: ");
				System.out.printf(">>> Your input %d is a valid integer.%n", out1);
				break;
				
			case 2:
				System.out.println(">>> Please enter an array with values separated by spaces(eg. 4 10 9 20 3): ");
				String in2 = scanner.nextLine();
				
				//
				
				printArray(new int[] { 4, 10, 2, 3, 8, 6 });
				break;
				
			case 3:
				String out3 = substitute("I like to read books", 'e', 'd');
				System.out.printf(">>> New string: %s%n", out3);
				break;
			
			case 4:
				String out4 = Arrays.toString(setArray(new int[] { 2, 3, 0, 5 }, 8));
				System.out.printf(">>> New array: %s%n", out4);
				break;
				
			case 5:
				String out5 = Arrays.toString(resizeArray(new int[] {3, 2, 1, 8}, 6));
				System.out.printf(">>> New array%s%n", out5);
				break;
				
			case 6:
				StringBuffer sb6 = new StringBuffer();
				
				boolean first = true;
				for (int i = 5; i <= 1000; i++) {
					if (!isPrime(i)) continue; // breaks out of curr loop if not prime
					if (!first) sb6.append(", ");
					sb6.append(i);
					first = false;
				}
				
				System.out.printf(">>> Prime numbers: %s%n", sb6.toString());
				break;
				
			case 7:
				StringBuffer sb7 = new StringBuffer();
				int[][] A = { {3, -2, 5}, {3, 0, 4} };
				int[][] B = { {2, 3}, {-9, 0}, {0, 4} };
				
				int[][] newArr = matrixMultiply(A, B);
				
				for (int i = 0; i < newArr.length; i++) {
					for (int j = 0; j < newArr[0].length; j++) {
						sb7.append(newArr[i][j]).append(" "); // insert value into each cell
					}
					sb7.append("\n"); // new line per row
				}
				
				System.out.println(sb7.toString());
				break;
				
			default: throw new IllegalArgumentException("Input is out of range.");
		}
	}
	
	// run functions
	// Q1
	public static Integer readInteger(String msg) {
		
		// while loop loops until user input is valid
		while (true) {
			
			// get user input
			System.out.println(msg);
			
			// use hasNextInt() to retrieve and check if input is int
			// if integer, exit loop
			// if not integer, print try again msg and loop again
			if (scanner.hasNextInt()) {
				int num = scanner.nextInt();
				scanner.nextLine(); // clears newline
				return num; // exit loop
			} else {
				String str = scanner.nextLine();
				System.out.printf(">>> Your input %s is not a valid integer. Please try again.%n", str);
			}
			
		}

	}
	
	// Q2
	public static void printArray(int[] arr) {
		
		System.out.println(">>> This is the array: ");
		
		// sb
		StringBuffer sb = new StringBuffer()
			.append("["); // opening bracket
		
		// loop through arr length and print each int
		for (int i = 0; i < arr.length; i++) {
			if (i == arr.length - 1) sb.append(arr[i]);
			else sb.append(arr[i]).append(", ");
		}
		
		sb.append("]"); // closing bracket
		System.out.println(sb.toString());
		
	}
	
	// Q3
	public static String substitute(String msg, char c1, char c2) {
		
		// conv string to char array
		char[] arr = msg.toCharArray();
		
		// sb
		StringBuffer sb = new StringBuffer();
		
		// iterate thru array
		for (int i = 0; i < arr.length; i++) {
			// if char matches c1, replace with c2
			if (arr[i] == c1) sb.append(c2);
			else sb.append(arr[i]);
		}
		
		// return new array as string
		return sb.toString();
	}
	
	// Q4
	public static int[] setArray(int[] arr, int value) {
		
		// loop thru arr and replace all values with value
		for (int i = 0; i < arr.length; i++) {
			arr[i] = value;
		}
		
		return arr;
		
	}
	
	// Q5
	public static int[] resizeArray(int[] arr, int newSize) {
		
		// new arr
		int[] newArr = new int[newSize];
		
		// loop till new size length
		// fill elements with arr values
		// after arr length, auto fills with 0s
		for (int i = 0; i < newSize; i++) {
			if (i < arr.length) {
				newArr[i] = arr[i];
			}
		}
		
		return newArr;
	}
	
	// Q6
	public static boolean isPrime(int n) {
		
		// if n less than 2, not prime
		if (n < 2) return false;
		
		// else loop from 2 to sqrt of n
		// if n is divisible by i, not prime
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) return false;
		}
		
		// if program reaches here, n is divisible by none other than 1 and itself
		return true;
		
	}

	// Q7 - ask to go through
	public static int[][] matrixMultiply(int[][] A, int[][] B) {
		
		// new arr with num of A rows and num of B cols
		int[][] newArr = new int[A.length][B[0].length];
		
		// outer loop new arr
		for (int row = 0; row < newArr.length; row++) {
			for (int col = 0; col < newArr[0].length; col++) {
				
				int sum = 0; // sum for curr cell in newArr
				
				// inner loop for num of A cols (which is also num of B rows)
				for (int comm = 0; comm < A[0].length; comm++) {
					
					// add multiplication of each corresponding cell to sum
					sum += A[row][comm] * B[comm][col];					
				}
				
				// insert sum into each cell
				newArr[row][col] = sum;
				
			}	
		}
		
		return newArr;
		
	}
	
}
