import java.util.Scanner;

public class ExerciseH_Solutions {
	
    static final Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) {
    	
    	// Q1
        int x = readInteger("Please enter x: ");
        System.out.println(x);
        
        // Q2
        printArray(new int[] { 1, 2, 3, 4, 5 });
        
        // Q3
        System.out.println(substitute("abbase", 'a', 'Z'));
        
        // Q4
        int[] A4 = new int[] { 1, 2, 3, 4, 5, 6 };
        printArray(A4);
        setArray(A4, 999);
        printArray(A4);
        
        // Q5
        int[] A5 = new int[] { 1, 2, 3, 4, 5 };
        printArray(A5);

        int[] B5 = resizeArray(A5, 10);
        printArray(B5);

        int[] C5 = resizeArray(B5, 3);
        printArray(C5);
        
        // Q6
        for (int i = 0; i < 100; i++) {
            if (isPrime(i)) {
                System.out.println(i + " is a prime number.");
            }
        }
        
        // Q7
        int[][] A7 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8}
        };
        printMatrix("A", A7);

        int[][] B7 = {
            {1, 2},
            {3, 4},
            {5, 6},
            {7, 8}
        };
        printMatrix("B", B7);

        int[][] C7 = matrixMultiply(A7, B7);
        printMatrix("C", C7);
        
        in.close();
        
    }

    // Q1
	static int readInteger(String message) {
        int output;

        do {
            System.out.print(message);

            // Check if the next input is an integer
            if (!in.hasNextInt()) {
                System.out.println("Invalid input. Please enter an integer.");
                in.nextLine(); // Consume the invalid input
            } else {
                // Read the integer input
                output = in.nextInt();
                return output;
            }
        } while (true); // Replace with your desired condition (if any)
    }
	
	// Q2
	public static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println("]");
    }
	
	// Q3
	public static String substitute(String s, char c1, char c2) {
        String newString = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c1) {
                newString += c2;
            } else {
                newString += s.charAt(i);
            }
        }
        return newString;
    }
	
	// Q4
	static void setArray(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            array[i] = value;
        }
    }
	
	// Q5
	static int[] resizeArray(int[] array, int newSize) {
        int[] newArray = new int[newSize];

        int limit = Math.min(array.length, newSize); // Ensure we don't go beyond the original array's length

        for (int i = 0; i < limit; i++) {
            newArray[i] = array[i];
        }

        return newArray;
    }
	
	// Q6
	static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        } else {
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            // There's no other factor between 1 and n so it must be prime
            return true;
        }
    }
	
	// Q7
	static int[][] matrixMultiply(int[][] A, int[][] B) {
        int[][] R = new int[A.length][B[0].length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                for (int k = 0; k < A[0].length; k++) {
                    R[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return R;
    }
	
	static void printMatrix(String name, int[][] A) {
        System.out.println("----" + name + "----");
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                System.out.print(A[i][j] + "\t");
            }
            System.out.println();
        }
    }
	
}
