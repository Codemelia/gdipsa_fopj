import java.util.Scanner;

public class ExerciseC_Solutions {
	
    static final Scanner in = new Scanner(System.in);

	public static void main(String[] args) {

		// Q1
        System.out.print("Please enter your name: ");
        String name1 = in.nextLine();
        System.out.print("Please enter your gender (M/F): ");
        String gender1 = in.nextLine();

        switch (gender1.toUpperCase()) {
            case "M":
                System.out.print("Good Morning Mr. " + name1);
                break;
            case "F":
                System.out.print("Good Morning Ms. " + name1);
                break;
            default:
                System.out.println("Wrong gender");
                break;
        }
        
        // Q2
        System.out.print("Please enter your name: ");
        String name2 = in.next();

        System.out.print("Please enter your gender (M/F): ");
        String gender2 = in.next();

        System.out.print("Please enter your age: ");
        int age = in.nextInt();

        switch (gender2.toUpperCase()) {
            case "M":
                if (age >= 40) {
                    System.out.println("Good Morning Uncle " + name2);
                } else {
                    System.out.println("Good Morning Mr. " + name2);
                }
                break;
            case "F":
                if (age >= 40) {
                    System.out.println("Good Morning Aunty " + name2);
                } else {
                    System.out.println("Good Morning Ms. " + name2);
                }
                break;
            default:
                System.out.println("Wrong gender");
                break;
        }
        
        // Q3
        System.out.print("Please enter your grade: ");
        int grade = in.nextInt();

        if (grade >= 80 && grade <= 100) {
            System.out.printf("You scored %d marks which is A grade.%n", grade);
        } else if (grade >= 60 && grade < 80) {
            System.out.printf("You scored %d marks which is B grade.%n", grade);
        } else if (grade >= 40 && grade < 60) {
            System.out.printf("You scored %d marks which is C grade.%n", grade);
        } else if (grade >= 0 && grade < 40) {
            System.out.printf("You scored %d marks which is F grade.%n", grade);
        } else {
            System.out.println("**Error**");
        }
        
        // Q4
        System.out.print("Please enter distance: ");
        double distance = in.nextDouble();

        double cost = 2.4;
        distance -= 0.5; // first 0.5km no additional charges apply

        if (distance > 0) {
            if (distance <= 8.5) {
                cost += Math.ceil(distance * 10) * 0.04;
                // cost = cost + Math.ceil(distance * 10) * 0.04;
            } else if (distance > 8.5) {
                distance -= 8.5;
                cost += 3.4; // next 8.5 km is 8.5 * 0.4 = 3.4
                cost += Math.ceil(distance * 10) * 0.05;
            }
        }
        System.out.println(cost);
        
        // Q5
        System.out.print("Please enter a 3-digits number: ");
        int n = Integer.parseInt(in.nextLine());

        int digit1 = n / 100;
        int digit2 = n % 100 / 10;
        int digit3 = n % 10;
        int sum = (int) (Math.round(Math.pow(digit1, 3)) + Math.round(Math.pow(digit2, 3)) + Math.round(Math.pow(digit3, 3)));

        if (sum == n) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }

        in.close();
    }

}
