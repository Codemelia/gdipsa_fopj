// There will be currency instance method which will need to call a different package,
// and the current time that need to call different package.

package day1;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.time.LocalTime;

public class program4 {
	public static void main(String[] args) {
            Scanner in = new Scanner(System.in);

            System.out.print("Enter your salary: ");
            double salary = in.nextDouble();

            double tax = 0.05 * salary;
            System.out.printf("Your salary is $%,.2f, your tax is $%,.2f%n", salary, tax);
            
            NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
            System.out.printf("Your salary is %s, your tax is %s%n", currencyFormat.format(salary), currencyFormat.format(tax));
            
            // using other currency display.
            Locale ukLocale = new Locale("en", "gb"); // uk pounds
            NumberFormat currencyFormat_UK = NumberFormat.getCurrencyInstance(ukLocale);
            System.out.printf("Your salary is %s, your tax is %s%n", currencyFormat_UK.format(salary), currencyFormat_UK.format(tax));

            // Custom Numeric Format
            // "0" Specifier
            double value;
            value = 123;
            // DecimalFormat method
            DecimalFormat df1 = new DecimalFormat("00000");
            System.out.println(df1.format(value));
            // printf formatting method
            System.out.printf("%05.0f%n", value); // Displays 00123

            value = 1.234;
            // DecimalFormat method
            DecimalFormat df2 = new DecimalFormat("0.00");
            System.out.println(df2.format(value));
            // printf formatting method
            System.out.printf("%.2f%n", value); // Displays 1.23

            value = 1.345;
            // DecimalFormat method
            DecimalFormat df3 = new DecimalFormat("0.00");
            System.out.println(df3.format(value));
            // printf formatting method
            System.out.printf("%.2f%n", value); // Displays 1.35

            value = -1.234;
            // DecimalFormat method
            DecimalFormat df4 = new DecimalFormat("0.00");
            System.out.println(df4.format(value));
            // printf formatting method
            System.out.printf("%.2f%n", value); // Displays -1.23

            value = -1.345;
            // DecimalFormat method
            DecimalFormat df5 = new DecimalFormat("0.00");
            System.out.println(df5.format(value));
            // printf formatting method
            System.out.printf("%.2f%n", value); // Displays -1.35

            // "#" Specifier

            value = 1.2;
            DecimalFormat df6 = new DecimalFormat("#.##");
            System.out.println(df6.format(value)); // Display 1.20

            value = 1.234;
            DecimalFormat df7 = new DecimalFormat("#.##");
            System.out.println(df7.format(value)); // Displays 1.23

            value = 1.345;
            DecimalFormat df8 = new DecimalFormat("#.##");
            System.out.println(df8.format(value)); // Displays 1.35

            value = -1.234;
            DecimalFormat df9 = new DecimalFormat("#.##");
            System.out.println(df9.format(value)); // Displays -1.23

            value = -1.345;
            DecimalFormat df10 = new DecimalFormat("#.##");
            System.out.println(df10.format(value)); // Displays -1.35

            // Standard Date and Time Format, String format
            LocalTime currentTime = LocalTime.now();
            System.out.println("Current time: " + currentTime);
            
            LocalTime specificTime = LocalTime.of(14, 30, 0);
            System.out.println("Specific time: " + specificTime);

            in.close();
        }
}
