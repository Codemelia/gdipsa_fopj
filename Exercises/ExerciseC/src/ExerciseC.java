import java.util.Scanner;

public class ExerciseC {
	
	private final static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// conv input to number
        // throws exception if input is not number
        try {
            int loop = 1;

            while (loop == 1) {
                // prompt user to select question to run
                System.out.println(">>> Select the function you wish to run:\n1. Q1\n2. Q2\n3. Q3\n4. Q4\n5. Q5");
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
    	// take in name and gender input
    	System.out.println(">>> Enter your name: ");
    	String name = scanner.nextLine()
			.trim();
    	System.out.println(">>> Enter your gender (M/F): ");
    	String gender = scanner.nextLine()
			.trim()
			.toLowerCase();
    	
    	// use switch statement to handle prefix according to gender
    	// greet based on gender and name
    	return String.format("Good Morning %s%s!", selectPrefix(gender), name);
    }
    
    public static String runQ2() {
    	// take in name, gender, age inputs
    	System.out.println(">>> Enter your name: ");
    	String name = scanner.nextLine()
			.trim();
    	System.out.println(">>> Enter your gender (M/F): ");
    	String gender = scanner.nextLine()
			.trim()
			.toLowerCase();
    	System.out.println(">>> Enter your age: ");
    	int age = Integer.parseInt(scanner.nextLine());
    	
    	// use switch statement to handle prefix according to age and gender
    	return String.format("Good Morning %s%s!", selectPrefix(gender, age), name);

    }
    
    public static String runQ3() {
    	// take input marks
    	System.out.println(">>> Enter your score: ");
    	double score = scanner.nextDouble();
    	scanner.nextLine();
    	
    	// init grade
    	String grade = "";
    	
    	// handle error
    	if (score < 0 || score > 100) grade = "**Error**";
    	
    	// select grade
    	if (score < 40) grade = "F";
    	else if (score < 60) grade = "C";
    	else if (score < 80) grade = "B";
    	else grade = "A";
    	
    	// print according to grade
    	return String.format("You scored %.2f marks which is %s grade.", score, grade);
    }
    
    public static String runQ4() {
    	// take in distance input
    	System.out.println(">>> Enter your distance travelled(km): ");
    	String input = scanner.nextLine()
    		.trim() // trim whitespaces
    		.replace("km", ""); // replace km if its in input
    	double dist = Double.parseDouble(input); // conv string to double
    	dist = Math.ceil(dist * 10) / 10; // round up
    	
    	// init total charge
    	double total = 0.00;
    	
    	// handle error
    	if (dist < 0) return String.format("%.2f", total);

    	// calc total charge based on dist
    	total += 2.4; // add base
    	dist -= 0.5; // subtract first .5km
    	
    	// if dist more than .5km, continue charges
    	if (dist > 0) {
    		// find remaining dist btw 0.5km and 8.5km
    		// Math.min helps determine if dist is </> 8.5km
    		double btwDist = Math.min(dist, 8.5);
    		total += (0.4 * btwDist); // add charges till 8.5km - .4 / km
    		
    		dist -= btwDist; // subtract next 8.5km
    		
    		// if dist still > 0, add charges for remaining dist - .5 / km
    		if (dist > 0) total += (0.5 * (dist));
    	}
     	
    	// round up to nearest 10 cents
    	return String.format("%.2f", total);
    }
    
    public static String runQ5() {
    	System.out.println(">>> Enter a three-digit integer: ");
    	String input = scanner.nextLine();
    	
    	// handle error
    	if (input.length() < 3 || input.length() > 3)
    		throw new IllegalArgumentException("Invalid three-digit integer.");
    	
    	int num = Integer.parseInt(input);
    	int conv = num; // num to conv to digits
    	
    	// retrieve each digit in num
    	// power each digit to 3
    	int d1 = (int) Math.pow((conv % 10), 3);
    	conv /= 10; // move dp up
    	int d2 = (int) Math.pow((conv % 10), 3);
    	conv /= 10;
    	int d3 = (int) Math.pow((conv % 10), 3);
    	
    	if ((d1 + d2 + d3) == num) return "True";
    	else return "False";
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

            default: throw new IllegalArgumentException("Input is out of range.");
        }
	}
    
    // select prefix based on gender & age
    public static String selectPrefix(String gender, int age) {
    	switch (gender) {
    		case "female":
    		case "f":
    			if (age >= 40) return "Aunty ";
    			return "Ms. ";
    		case "male":
    		case "m":
    			if (age >= 40) return "Uncle ";
    			return "Mr. ";
    			
    		default:
    			return "";
    	}
    }
    
    // overloading for no age parameter
    public static String selectPrefix(String gender) {
    	switch (gender) {
    		case "female":
    		case "f":
    			return "Ms. ";
    		case "male":
    		case "m":
    			return "Mr. ";
    			
    		default:
    			return "";
    	}
    }

}
