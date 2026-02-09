import java.util.Scanner;

public class Day2Quiz {
	
	private final static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println(">>> Enter the length in cm: ");
		double input = scanner.nextDouble();
		
		System.out.printf(">>> Your length in inches: %.3f", input / 2.54);
		
		scanner.close();
	}

}
