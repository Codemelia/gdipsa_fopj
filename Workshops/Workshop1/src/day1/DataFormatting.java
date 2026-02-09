package day1;
import java.util.Scanner;
import java.text.DecimalFormat;

public class DataFormatting {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.println("Please enter a number: ");
        String num = in.nextLine();
        double a = Double.parseDouble(num);
        System.out.println(a);
        DecimalFormat df = new DecimalFormat("#.#");
        System.out.println(df.format(a));	
        DecimalFormat df1 = new DecimalFormat("#.###");
        System.out.println(df1.format(a));
        DecimalFormat df2 = new DecimalFormat("#.###");
        System.out.println(df2.format(a));
        System.out.println(String.format("%.1f", a));
        System.out.println(String.format("%.3f", a));
        // using decimal format won't be able to use money format, this is getting messy...
        System.out.println(String.format("%,.2f", a));
        
        in.close();
    }
}
