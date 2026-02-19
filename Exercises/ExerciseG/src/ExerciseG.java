import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class ExerciseG {

private final static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		// conv input to number
        // throws exception if input is not number
        try {
            int loop = 1;

            while (loop == 1) {
                // prompt user to select question to run
                System.out.println(">>> Select the function you wish to run:\n1. Q1\n2. Q2\n3. Q3");
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
	
	// select function
	public static String selectFunction(int selected) {
		switch(selected) {
			case 1: return runQ1();
			case 2: return runQ2();
			case 3: return runQ3();
			default: throw new IllegalArgumentException("Input is out of range.");
		}
	}
	
	// run functions
	public static String runQ1() {
		
		// string buffer for ans
		StringBuffer sb = new StringBuffer();
		
		// a. retrieve sales for 12 mths
		double[] sales = get12MthSales();
		
		// length of arr
		int len = sales.length;
		
		// b. print mth with max sales
		// c. print month with min sales
		// d. print avg monthly sales per year
		double total = 0; // store total sales
		
		double maxi = Double.MIN_VALUE; // store max num
		double mini = Double.MAX_VALUE; // store min num
		int maxiIdx = 0; // store month by index
		int miniIdx = 0; // store month by index
		
		for (int i = 0; i < len; i++) {
			if (sales[i] > maxi) { // gets maximum sales
				maxi = sales[i];
				maxiIdx = i;
			}
			if (sales[i] < mini) { // gets minimum sales
				mini = sales[i];
				miniIdx = i;
			}
			total += sales[i]; // sum up sales
		}
	
		// get month name via index
		String maxiMth = getMonthByIdx(maxiIdx);
		String miniMth = getMonthByIdx(miniIdx);
		
		// get avg from total
		double avg = total / len;
		
		// print all answers
		sb.append(String.format("A. All sales for 12 months:%n%s%n%n", Arrays.toString(sales)));
		sb.append(String.format("B. Max sales is %,.2f in the month of %s%n%n", maxi, maxiMth));
		sb.append(String.format("C. Min sales is %,.2f in the month of %s%n%n", mini, miniMth));
		sb.append(String.format("D. Average monthly sales for the year is %,.2f%n%n", avg));
				
		return sb.toString();
	}
	
	public static String runQ2() {
		
		// sort 12 month sales in descending order
		double[] sales = get12MthSales();
		
		// loop through arr to sort
		for (int i = 0; i < sales.length; i++) {
			for (int j = i + 1; j < sales.length; j++) {
				if (sales[j] < sales[i]) { // if sales at index j < sales at index i, swap positions
					double temp = sales[j];
					sales[j] = sales[i];
					sales[i] = temp;
				}
			}
			System.out.printf("Loop %d sort: %s%n%n", i, Arrays.toString(sales)); // print each loop sorted array
		}
		
		return Arrays.toString(sales);
	}
	
	public static String runQ3() {
		
		// for ans
		StringBuffer sb = new StringBuffer();
		
		// d. code works regardless of num of students/subjects
		// take number inputs from user and generate random marks for each student
		System.out.println(">>> Enter the number of students: ");
		int numOfStudents = scanner.nextInt();
		scanner.nextLine();
		
		System.out.println(">>> Enter the number of subjects: ");
		int numOfSubjects = scanner.nextInt();
		scanner.nextLine();
		
		// get all marks
		int[][] allMarks = getAllMarks(numOfStudents, numOfSubjects);
		
		sb.append(String.format("All marks by Student and Subject: %s%n%n", Arrays.deepToString(allMarks)));
		
		// int numOfStudents = allMarks.length;
		// int numOfSubjects = allMarks[0].length;
		
		// a. calc total marks obtained by each student
		// c. calc avg marks for each student for all subs
		for (int i = 0; i < numOfStudents; i++) {
			
			int total = 0; // total marks per student
			
			for (int j = 0; j < numOfSubjects; j++) {
				total += allMarks[i][j]; // add up total marks for all subs
			}
			
			int studentAvg = total / numOfSubjects; // get avg for each student
			
			sb.append(String.format("Total marks obtained by Student %d: %d%n%n", 
				i + 1, total)); // print total marks by student
			
			sb.append(String.format("Average marks obtained by Student %d: %d%n%n", 
					i + 1, studentAvg)); // print avg marks by student
			
		}

		// b. calc class avg + sdof marks for each sub
		for (int j = 0; j < numOfSubjects; j++) {
			
			// calc mean
			int total = 0; // subj total
			for (int i = 0; i < numOfStudents; i++) {
				total += allMarks[i][j];
			}
			int classAvg = total / numOfStudents; // store avg of each subj
			
			// calc sd
			double squareSum = 0; // sum up all square
			for (int i = 0; i < numOfStudents; i++) {
				double dist = allMarks[i][j] - classAvg; // calc dist of data point to mean
				squareSum += dist * dist; // add square of dist to sum
			}
			double sd = Math.sqrt(squareSum / numOfStudents); // find sd by sq root of variance
			
			// print avg + sd
			sb.append(String.format("Average marks obtained for Subject %d: %d%n", 
				j + 1, classAvg)); // a. print total marks by student
			sb.append(String.format("Standard deviation for Subject %d: %.2f%n%n", 
				j + 1, sd));
		}

		return sb.toString();
	}

	// helpers
	// retrieve 12 month sales - randomly generated
	public static double[] get12MthSales() {
		double[] sales = new double[12];
		for (int i = 0; i < sales.length; i++) {
			sales[i] = Double
				.parseDouble(new DecimalFormat("#.##")
				.format(new Random()
				.nextDouble(20000.00, 90000.00)));
		}
		return sales;
	}
	
	// retrieve month by idx
	public static String getMonthByIdx(int idx) {
		switch(idx) {
			case 0: return "January";
			case 1: return "February";
			case 2: return "March";
			case 3: return "April";
			case 4: return "May";
			case 5: return "June";
			case 6: return "July";
			case 7: return "August";
			case 8: return "September";
			case 9: return "October";
			case 10: return "November";
			case 11: return "December";
			default: return "Invalid month";
		}
	}
	
	// retrieve student marks array
	public static int[][] getAllMarks(int numOfStudents, int numOfSubjects) {
		int[][] marks = new int[numOfStudents][numOfSubjects]; // 12 rows 4 cols; changed to based on user input
		for (int i = 0; i < marks.length; i++) {
			for (int j = 0; j < marks[0].length; j++) {
				marks[i][j] = new Random().nextInt(0, 101); // 0 - 100, 100 inclusive
			}
		}
		return marks;
	}
}
