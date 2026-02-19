import java.text.DecimalFormat;
import java.util.Scanner;

public class ExerciseE_Solutions {
	
    static final Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
        
		// Q1
        System.out.print("Enter a number: ");
        int n1 = in.nextInt();
        int maxvalue = Integer.MAX_VALUE;
        // double dvalue = Double.MAX_VALUE;
        System.out.println("Maximum value of an integer: " + maxvalue);
        // System.out.println("Maximum value of a double: " + dvalue);
        int fact = 1;
        int previousFact = fact;
       
        for (int i = 1; i <= n1; i++) {
            previousFact = fact;
            fact *= i;
            // check integer overflow
            if ((fact / i) != previousFact) {
                System.out.println("Integer overflow");
                break;
            }
        }
        /*
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        */

        System.out.println(fact);

        // some potential problem: it will overflow and exceed the upper limit of integer.
        // in production code, need to add some validation to ensure that that doesn't happen
        // some validation can be done for example: to check if (n! / n) is equal to (n-1)!
        // when overflow happens, the two may not be equal.

        // decrement version:
        // for (int i = n; i >= 1; i--) {
        //     fact *= i;
        // }
        
        // Q2
        System.out.println("NO\t\tINVERSE\t\tSQUARE ROOT\tSQUARE");
        for (int i = 1; i <= 10; i++) {
            double d = i;
            DecimalFormat df = new DecimalFormat("0.0##");
            System.out.println(String.format("%.1f", d) + "\t\t" + df.format(1 / d) + "\t\t" + df.format(Math.sqrt(d)) + "\t\t" + String.format("%.1f", Math.pow(d, 2)));
        }
        
        // Q3
        System.out.print("Please enter an integer: ");
        int n3 = in.nextInt();

        boolean isPrime3 = true;

        for (int i = 2; i < n3; i++) {
            if (n3 % i == 0) {
                isPrime3 = false;
                break;
            }
        }

        if (isPrime3) {
            System.out.println("Prime");
        } else {
            System.out.println("Not Prime");
        }

        // Q4
        System.out.print("Please enter an integer: ");
        int n4 = in.nextInt();

        int sum4 = 0;

        for (int i = 1; i < n4; i++) {
            if (n4 % i == 0) {
                sum4 += i;
            }
        }

        if (sum4 == n4) {
            System.out.println("Perfect Number");
        } else {
            System.out.println("Not Perfect Number");
        }
        
        // Q5
        for (int n = 5; n < 10000; n++) {
            boolean isPrime5 = true;

            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    isPrime5 = false;
                    break;
                }
            }

            if (isPrime5) {
                System.out.println(n);
            }
        }
        
        // Q6
        for (int n = 1; n < 1000; n++) {
            int sum6 = 0;

            for (int i = 1; i < n; i++) {
                if (n % i == 0) {
                    sum6 += i;
                }
            }

            if (sum6 == n) {
                System.out.println(n);
            }
        }
        
        in.close();
    }

}
