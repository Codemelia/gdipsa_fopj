package Day2;

public class program2 {
    public static void main(String[] args) {
        int x = 20;
        int y = 3;

        System.out.printf("20/3 = %d\n", x / y); // 6 because it's integer division
        System.out.printf("20/3 = %.1f\n",  1.0*x / y); // 6.7 because it's NOT integer division
        System.out.printf("remainder = %d\n", x % y); // 2 because both are integer

        double xx = 20.1;
        double yy = 3.1;

        System.out.printf("20.1/3.1 = %.1f\n", xx / yy); // 6.5 because it's NOT integer division
        System.out.printf("remainder = %.1f\n", xx % yy); // 1.5 because both are not integer
        System.out.printf("remainder = %.1f\n", 5.0 % 2.2); // 0.6 because both are not integer
    }
}
