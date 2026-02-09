package Day2;
import java.util.Scanner;

public class program4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter a number below 10: ");
        int number = in.nextInt();
        in.close();

        if (number < 10) {
            System.out.println("Very good. You can follow instructions.");
            System.out.println("**************************************");
        } else {
            System.out.println("You cannot follow instructions.");
        }

        // not very safe
        if (number < 10)
            System.out.println("Very good. You can follow instructions.");
        else
            System.out.println("You cannot follow instructions.");
    }
}
