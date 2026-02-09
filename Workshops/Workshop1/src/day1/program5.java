package day1;

public class program5 {
	public static void main(String[] args) {
		int[] array = { 8, 5, 7, 3, 1 };
		bubbleSort(array);
		bubbleSort_revised(array);
	}

	static void bubbleSort(int[] array) {
		int n = array.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - 1; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j + 1];
					array[j + 1] = array[j];
					array[j] = temp;
					
					System.out.println("og inner loop="+j);
				}
			}
//			System.out.println("The " + (i + 1) + "th pass");
//			for (int item : array) {
//				System.out.println(item);
//			}
		}
//		System.out.println("Sorting result");
//		for (int item : array) {
//			System.out.println(item);
//		}
	}
	
	public static void bubbleSort_revised(int[] arr) {
	    int n = arr.length;
	    for (int i = 0; i < n - 1; i++) {
	        for (int j = 0; j < n - 1 - i; j++) {
	            if (arr[j] > arr[j + 1]) {
	                int temp = arr[j];
	                arr[j] = arr[j + 1];
	                arr[j + 1] = temp;
	                
	                System.out.println("revised inner loop="+j);
	            }
	        }
	    }
//	    System.out.println("Sorting result using bubbleSort_revised");
//		for (int item : arr) {
//			System.out.println(item);
//	    
//		}

	}
	
}
