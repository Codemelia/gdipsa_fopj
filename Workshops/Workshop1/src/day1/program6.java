package day1;
import java.util.Scanner;

public class program6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter double number:");
        double num = in.nextDouble();
        double square = num * num;
        System.out.println(square);

        in.close();
    }
}
