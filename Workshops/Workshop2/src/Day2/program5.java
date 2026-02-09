package Day2;
import java.util.Scanner;

public class program5 {
    public static void main(String[] args) {
        // Getting the input
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number grade: ");
        double noGrade = in.nextDouble();
        in.close();

        // Check the input 
        String grade = "";

        // If between 85-100 A+
        if (noGrade > 85 && noGrade <= 100) {
            grade = "A+";
        }
        // 80-85 A
        if (noGrade > 80 && noGrade <= 85) {
            grade = "A";
        }
        // 75-80 A-
        if (noGrade > 75 && noGrade <= 80) {
            grade = "A-";
        }
        // 70-75 B+
        if (noGrade > 70 && noGrade <= 75) {
            grade = "B+";
        }
        // 65-70 B
        if (noGrade > 65 && noGrade <= 70) {
            grade = "B";
        }
        // Others, less than B
        if (noGrade <= 65) {
            grade = "Less than B";
        }

        // Print out the grade
        System.out.println("Your grade is " + grade);
    }
}
