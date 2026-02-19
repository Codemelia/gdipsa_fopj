import java.util.Scanner;

public class ExerciseG_Solutions {

    static final Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
        
		// Q1
        int[] sales = new int[12];
        String[] monthNames = new String[] {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };

        for (int n = 0; n < 12; n++) {
            System.out.print("Enter sales for month " + (n + 1) + " (" + monthNames[n] + "): ");
            sales[n] = in.nextInt();
        }
        
        int max = 0;
        int min = 0;
        int sum = sales[0];
        for (int i = 1; i < 12; i++) {
            if (sales[i] > sales[max]) {
                max = i;
            }
            if (sales[i] < sales[min]) {
                min = i;
            }
            sum += sales[i];
        }
        
        System.out.println("Maximum Sales: " + sales[max] + " (" + monthNames[max] + ")");
        System.out.println("Minimum Sales: " + sales[min] + " (" + monthNames[min] + ")");
        System.out.println("Average Sales: " +  sum / 12.0);
        
        // Q2
        int[] list = { 86, 35, 41, 49, 89, 51, 11, 71, 50, 75, 25, 58, 40, 14, 44, 3, 63, 81, 93, 79 };

        for (int i = 0; i < list.length - 1; i++) {
            for (int j = i + 1; j < list.length; j++) {
                if (list[i] < list[j]) {
                    int temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;

                    for (int k = 0; k < list.length; k++) {
                        System.out.print(list[k] + " ");
                    }
                    System.out.println();
                }
            }
        }
        
        // Q3
        int[][] marks = {
            {56, 84, 68, 29},
            {94, 73, 31, 96},
            {41, 63, 36, 90},
            {99, 9, 18, 17},
            {62, 3, 65, 75},
            {40, 96, 53, 23},
            {81, 15, 27, 30},
            {21, 70, 100, 22},
            {88, 50, 13, 12},
            {48, 54, 52, 78},
            {64, 71, 67, 25},
            {16, 93, 46, 72}
        };

        int[] total = new int[12];
        int[] sumPerSubject = new int[4];

        for (int row = 0; row < 12; row++) {
            for (int col = 0; col < 4; col++) {
                total[row] += marks[row][col];
                sumPerSubject[col] += marks[row][col];
            }
        }

        for (int row = 0; row < 12; row++) {
            System.out.println("Total marks for student " + row + ": " + total[row]);
        }

        double totalAvg = 0;

        for (int col = 0; col < 4; col++) {
            System.out.println("Avg marks for subject " + col + ": " + sumPerSubject[col] / 12.0);
            totalAvg += sumPerSubject[col] / 12.0;
        }

        System.out.println("Overall average: " + totalAvg / 4.0); // Overall average for all subjects
        
        in.close();
    }

}
