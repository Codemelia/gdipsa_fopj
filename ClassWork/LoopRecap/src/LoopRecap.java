public class LoopRecap {
		
	public static void main(String[] args) {
		
		/*
		 * R1: 1 2 3 4
		 * R2: 1 2 3 4
		 * R3: 1 2 3 4
		 * R4: 1 2 3 4
		 */
		for (int j = 1; j <= 4; j++) {
			
			System.out.printf("R%d:", j);
			
			for (int i = 1; i <= 4; i++) {
				System.out.printf(" %d", i);
			}
			
			System.out.println();
			
		}
		
		/*
		 * R1: 1
		 * R2: 1 2
		 * R3: 1 2 3
		 * R4: 1 2 3 4
		 */
		for (int j = 1; j <= 4; j++) {
			
			System.out.printf("R%d:", j);
			
			for (int i = 1; i <= j; i++) { // end stops at outer loop
				System.out.printf(" %d", i);
			}
			
			System.out.println();
			
		}
		
	}

}
