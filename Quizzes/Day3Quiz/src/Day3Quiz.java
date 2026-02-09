import java.util.Scanner;

public class Day3Quiz {
	
	private final static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("Welcome to ISS Gadget Shop where every gadget is priced at $500!");
		System.out.println(">>> Number of items to purchase: ");
		
		int n = scanner.nextInt(); // input
		int p = 500; // price per gadget
		double t = 0; // init total price
		
		if (n * p > 6000) t = n * p * .92; // 8% disc
		else if (n * p > 3000) t = n * p * .95; // 5% disc
		else if (n * p > 2000) t = n * p * .97; // 3% disc
		else t = n * p; // no disc
		
		System.out.printf(">>> Please pay: %.2f", t);
		
		scanner.close();
		
	}

}
