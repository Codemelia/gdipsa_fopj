import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {

        // init array
        int[] arr = { 5, 3, 2, 6, 1 };

        // print init array
        System.out.printf("Initial array: %s\n", Arrays.toString(arr));

        // array length
        int len = arr.length;

        // idea here is to do one primary loop to sort curr num against following nums
        // then nest primary loop in another loop to keep sorting across the array
        for (int i = 0; i < len - 1; i++) {

            // stop at len - 1 - i bc the largest number at current loop was already sorted to the last idx
            for (int j = 0; j < len - 1 - i; j++) {

                // if curr num larger then next num, swap the positions of both nums
                if (arr[j] > arr[j + 1]) {

                    // store curr num in temp var
                    int temp = arr[j];

                    // move num at next idx to curr idx
                    arr[j] = arr[j + 1];

                    // fill next idx with curr num
                    arr[j + 1] = temp;

                }

            }

        }

        System.out.printf("Sorted array: %s\n", Arrays.toString(arr));

    }

}