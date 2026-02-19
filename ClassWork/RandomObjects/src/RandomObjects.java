import java.util.Random;

public class RandomObjects {
	
	private final static Random rand = new Random();

	public static void main(String[] args) {
		
		/*
		 * Random int btw 3 and 20, 20 excluded
		 */
		int rand0 = rand.nextInt(3, 20);
		System.out.printf(">>> Random int: %d%n", rand0);
		
		/*
		 * Random double btw 5 and 10, 10 excluded
		 */
		double rand1 = rand.nextDouble(5, 10);
		System.out.printf(">>> Random double: %.3f%n", rand1);
		
		/*
		 * Random float btw 3 and 20, 20 excluded
		 */
		float rand2 = 3 + (20 - 3) * rand.nextFloat(); // lower + remainder to upper * rand btw 0-1
		System.out.printf(">>> Random float: %.5f%n", rand2);
		
		/*
		 * Random double btw 4 and 35, 35 included
		 */
		double rand3 = 4 + (35 - 4 + 1) * rand.nextDouble(); // lower + remainder to upper + 1 * rand btw 0-1
		System.out.printf(">>> Random double : %.3f%n", rand3);
	
		/*
		 * Random int using Math class btw 0 and 1, 1 excluded
		 */
		int rand4 = (int) Math.random();
		System.out.printf(">>> Random int: %d%n", rand4);
		
		/*
		 * Random double btw 0 and 4, 4 excluded
		 */
		double rand5 = Math.random() * (4 - 0) + 0; // random * (max - min) + min
		System.out.printf(">>> Random double: %.3f%n", rand5);
		
		/*
		 * Random float btw 3 and 10, 10 included
		 */
		float rand6 = (float) Math.random() * (10 - 3 + 1) + 3; // random * (max - min + 1) + min
		System.out.printf(">>> Random float: %.5f%n", rand6);
		
	}

}
