import java.util.Scanner;
import java.util.Arrays;
import java.text.DecimalFormat;

public class ExerciseB {
	
	private final static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		// conv input to number
        // throws exception if input is not number
        try {
            int loop = 1;

            while (loop == 1) {
                // prompt user to select question to run
                System.out.println(">>> Select the function you wish to run:\n1. Q1\n2. Q2\n3. Q3\n4. Q4\n5. Q5\n6. Q6\n7. Q7\n8. Q8\n9. Q9");
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

    // helper functions

    // select function based on input
    public static String selectFunction(int selected) {

        switch (selected) {
            case 1: return runQ1();
            case 2: return runQ2();
            case 3: return runQ3();
            case 4: return runQ4();
            case 5: return runQ5();
			case 6: return runQ6();
			case 7: return runQ7();
			case 8: return runQ8();
			case 9: return runQ9();

            default: throw new IllegalArgumentException("Input is out of range.");
        }
	}
	
	// run functions	
	public static String runQ1() {
		System.out.println(">>> Enter a double precision number: ");
		double input = scanner.nextDouble();
		scanner.nextLine();
		return String.format("%f", input * input);
	}
	
	public static String runQ2() {
		System.out.println(">>> Enter a double precision number: ");
		double input = scanner.nextDouble();
		scanner.nextLine();
		return String.format("%.3f", input * input);
	}
	
	public static String runQ3() {
		System.out.println(">>> Enter your salary: ");
		double input = scanner.nextDouble();
		scanner.nextLine();
		return String.format("%,.2f", input + (input * .03) + (input * .1));
	}
	
	public static String runQ4() {
		System.out.println(">>> Enter a temperature in Centigrade scale");
		double input = scanner.nextDouble();
		scanner.nextLine();
		DecimalFormat df = new DecimalFormat("#.##");
		return df.format(1.8 * input + 32);
	}
	
	public static String runQ5() {
		System.out.println(">>> Enter the value of x: ");
		double input = scanner.nextDouble();
		scanner.nextLine();
		DecimalFormat df = new DecimalFormat("#.##");
		return df.format((5 * Math.pow(input, 2)) - (4 * input) + 3);
	}
	
	public static String runQ6() {
		System.out.println(">>> Enter (x,y) coordinates of the first point: ");
		String input1 = scanner.nextLine().trim();
		if (input1.length() < 3) throw new IllegalArgumentException("Inaccurate coordinates.");
		
		System.out.println(">>> Enter (x,y) coordinates of the second point: ");
		String input2 = scanner.nextLine();
		if (input2.length() < 3) throw new IllegalArgumentException("Inaccurate coordinates.");
		
		// conv inputs to arrays
		Double[] arr1 = Arrays.stream(input1.split(","))
			.map(String::trim) // trim each string value
			.map(Double::parseDouble) // parse each string value to double
			.toArray(Double[]::new); // map all double values to new double array
			
		Double[] arr2 = Arrays.stream(input2.split(","))
			.map(String::trim)
			.map(Double::parseDouble)
			.toArray(Double[]::new);
		
		double x1 = arr1[0], y1 = arr1[1], 
			x2 = arr2[0], y2 = arr2[1];
			
		return String.format("%.2f",
			Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2))
		);
	}
	
	public static String runQ7() {
		System.out.println(">>> Enter the distance travelled: ");
		double input = scanner.nextDouble();
		scanner.nextLine();
		return new DecimalFormat("#.##").format(2.4 + input * 0.4);
	}
	
	public static String runQ8() {
		System.out.println(">>> Enter the distance travelled: ");
		double input = scanner.nextDouble();
		scanner.nextLine();
		double preOut = Math.ceil((2.4 + input * 0.4) * 10) / 10; // multi rounds up to whole number, then div moves dp back
		return new DecimalFormat("0.00").format(preOut);
	}
	
	public static String runQ9() {
		System.out.println(">>> Enter three sides of a triangle(a,b,c): ");
		String input = scanner.nextLine();
		
		// conv input to double array
		Double[] arr = Arrays.stream(input.split(","))
			.map(String::trim)
			.map(Double::parseDouble)
			.toArray(Double[]::new);
		
		// error handling
		if (arr.length > 3) throw new IllegalArgumentException("Invalid triangle sides.");
		
		// assign values
		double a = arr[0], b = arr[1], c = arr[2];
		double s = (a + b + c) / 2;
		
		double area = Math.sqrt((s * (s - a)) * (s - b) * (s - c));
		
		if (Double.isNaN(area)) return "That is not a triangle.";
		else return new DecimalFormat("#.##").format(area);
	}
	
}