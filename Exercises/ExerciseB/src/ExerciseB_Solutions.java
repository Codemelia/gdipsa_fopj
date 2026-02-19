import java.util.Scanner;
import java.text.DecimalFormat;

public class ExerciseB_Solutions {
	
	final static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		
		// Q1
		double num1;
		System.out.print("Enter your double number: ");  // Show prompting message
		num1 = in.nextDouble(); 
		
		DecimalFormat df1 = new DecimalFormat("0.###"); // Specifiy the data format
		System.out.println(df1.format(Math.sqrt(num1)));
		
		// Q2
		double num2;
		System.out.print("Enter your double number: ");  // Show prompting message
		num2 = in.nextDouble(); 
		
		num2 = Math.sqrt(num2);
		
		String formatted_str2 = String.format("%.3f", num2); //Turns the double number into string with 2 decimals
		
		System.out.println(formatted_str2);
		
		// Q3
		double num3;
        System.out.print("Enter your salary: ");  // Show prompting message
        num3 = in.nextDouble(); 
        
        num3 = num3 * 1.13;

        DecimalFormat df3 = new DecimalFormat("#,#00.00");
        String formatted_str3 = df3.format(num3);

        System.out.println("$" + formatted_str3);
        
        // Q4
        double num4;
		System.out.print("Please enter the temperature in Centigrade: ");  // Show prompting message
		num4 = in.nextDouble(); 
		
		num4 = num4 * 1.8 + 32;
				
		DecimalFormat df4 = new DecimalFormat("");
		
		System.out.println(df4.format(num4));
		
		// Q5
		double num5;
		System.out.print("Enter x: ");  // Show prompting message
		num5 = in.nextDouble(); 
		
		num5 = 5* num5 * num5 - 4 * num5 + 3;
				
		DecimalFormat df5 = new DecimalFormat("");
		
		System.out.println(df5.format(num5));
        
		// Q6
		double x1;
		double y1;
		double x2;
		double y2;

		System.out.print("Enter x1: ");
		x1 = in.nextDouble();
		System.out.print("Enter y1: ");
		y1 = in.nextDouble();
		System.out.print("Enter x2: ");
		x2 = in.nextDouble();
		System.out.print("Enter y2: ");
		y2 = in.nextDouble();
		
		DecimalFormat df6 = new DecimalFormat("");
		
		double dist6 = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
		System.out.println(df6.format(dist6));
        
        // Q7
        System.out.print("Enter the distance: ");
        double dist7 = in.nextDouble();

        System.out.println(2.4 + 0.4 * dist7);
        
        // Q8
        System.out.print("Enter the distance: ");
        double dist8 = in.nextDouble();
        
        double fare = 2.4 + 0.4 * dist8;
        fare *= 10; // Multiply fare by 10
        fare = Math.ceil(fare); // Round fare up to the nearest whole number
        fare /= 10; // Divide fare by 10
        System.out.printf("%.1f%n", fare); // Print fare rounded to one decimal place
        
        // Q9
        System.out.print("Please enter a: ");
        double a = in.nextDouble();
        System.out.print("Please enter b: ");
        double b = in.nextDouble();
        System.out.print("Please enter c: ");
        double c = in.nextDouble();

        double s9 = (a + b + c) / 2;

        DecimalFormat df9 = new DecimalFormat();
        
        if ((a + b) > c && (b + c) > a && (a + c) > b) {
            System.out.println(df9.format(Math.sqrt(s9 * (s9 - a) * (s9 - b) * (s9 - c))));
        } else {
            System.out.println("NaN");
        }
        
        // Q9 alternative
        System.out.print("Enter side d: ");
        double d = in.nextDouble();

        System.out.print("Enter side e: ");
        double e = in.nextDouble();

        System.out.print("Enter side f: ");
        double f = in.nextDouble();

        // Check for a valid triangle using the triangle inequality theorem
        if (a + b > c && a + c > b && b + c > a) {
            double s9a = (a + b + c) / 2;
            double area = Math.sqrt(s9a * (s9a - d) * (s9a - e) * (s9a - f));
            System.out.printf("The area of the triangle is: %.2f%n", area);
        } else {
            // Print NaN if the sides do not form a valid triangle
            System.out.println("NaN");
        }
        
        in.close();
		
	}

}
