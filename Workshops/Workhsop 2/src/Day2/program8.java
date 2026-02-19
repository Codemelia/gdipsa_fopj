package Day2;
import java.util.Scanner;

public class program8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 0 - Sunday
        // 1 - Monday
        // 2 - Tuesday
        // 6 - Saturday

        System.out.print("Enter a number: (0-6) ");
        int no = (int) in.nextDouble();
        
        // Close the Scanner object
        in.close();

        String day = "";
        switch (no) {
            case 0:
                day = "Sunday";
                break;
            case 1:
                day = "Monday";
                break;
            case 2:
                day = "Tuesday";
                break;
            case 3:
                day = "Wednesday";
                break;
            case 4:
                day = "Thursday";
                break;
            case 5:
                day = "Friday";
                break;
            case 6:
                day = "Saturday";
                break;
            default:
                day = "Not a day";
                break;
        }

        System.out.println(day);
    }
}
