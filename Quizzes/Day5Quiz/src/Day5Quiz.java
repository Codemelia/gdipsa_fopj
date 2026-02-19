import java.util.Scanner;
import java.util.Random;

public class Day5Quiz {
	
	public static final Scanner scanner = new Scanner(System.in);
	public static final Random random = new Random();

	public static void main(String[] args) {
		
		// gen random array
		// int[][] arr = buildArray();
		
		// for testing
		int[][] arr = {
			{5, 3},
			{2, 9},
			{2, 9},
			{5, 1},
			{7, 1},
			{8, 3},
			{0, 3},
			{2, 2},
			{9, 7}
		};
		
		int rows = arr.length;
		int cols = arr[0].length;
		
		System.out.println(">>> Pick a number (0-9) to count its number of occurrences: ");
		int input = scanner.nextInt();
		
		while (input < 0 || input > 9) {
			System.out.println(">>> Invalid input. Please try again");
			input = scanner.nextInt();
		}
		
		// track count
		int count = 0;
		
		// if num is found in array, update count
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (arr[i][j] == input) count++;
			}
		}
		
		// print output
		if (count == 0) {
			System.out.printf(">>> There is no %d in the array.", input);
		} else {
			System.out.printf(">>> The number of %d is %d.", input, count);
		}
		
		scanner.close();
		
	}
	
	// funct to build array of rand num
	public static int[][] buildArray() {
		
		// gen array num of rows/cols
		int rr = random.nextInt(1, 11); // 1 - 10 rows
		int cr = random.nextInt(1, 5); // 1 - 4 cols
				
		// int 2d array
		int[][] arr = new int[rr][cr];
		
		// iterate array and gen + insert rand nums
		for (int i = 0; i < rr; i++) {
			for (int j = 0; j < cr; j++) {
				arr[i][j] = random.nextInt(0, 10); // 0 - 9
			}
		}
		
		return arr;
		
	}

}
