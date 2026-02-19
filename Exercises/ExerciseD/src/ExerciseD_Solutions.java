import java.util.Random;
import java.util.Scanner;

public class ExerciseD_Solutions {
	
    static final Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		
		// Q1
        int num = 0;

//		do {
//			System.out.print("Enter a number (1-100): ");
//			num = scanner.nextInt();
//		} while (num != 88);
//		
//		// Resetting num for the next loop
//		num = 0;

        while (num != 88) {
            System.out.print("Enter a number (1-100): ");
            num = in.nextInt();
        }

        System.out.println("Lucky you");
        
        // Q2
        System.out.print("Enter A: ");
        int a = in.nextInt();
        System.out.print("Enter B: ");
        int b = in.nextInt();

        int big = Math.max(a, b);
        int small = Math.min(a, b);

        while (big != small) {
            big = big - small;

            if (big < small) {
                int temp = small;
                small = big;
                big = temp;
            }
        }

        int hcf = big;
        int lcm = (a * b) / hcf;

        System.out.println("HCF:" + hcf);
        System.out.println("LCM:" + lcm);
        
        // Q3
        Random r = new Random();
        int secret = r.nextInt(10); // generate a random number between 0 and 9
        int guess = 0;
        int attempt = 0;
        Scanner in = new Scanner(System.in);
        
        do {
            System.out.print("Guess a number (0-9): ");
            guess = in.nextInt();
            attempt++;
        } while (secret != guess);

        if (attempt <= 2) {
            System.out.println("You are a Wizard!");
        } else if (attempt <= 5) {
            System.out.println("You are a good guess");
        } else {
            System.out.println("You are lousy");
        }

        in.close();
    }

}
