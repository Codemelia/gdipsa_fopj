package q2;

import java.util.Scanner;

public class Q2 {
	
	final static Scanner in = new Scanner(System.in);
	
	static String[][] stringArr = {
			{ "000", "FOPJ" }, 
			{ "001", "OOPJ" }, 
			{ "002", "ANDROID" }, 
			{ "003", ".NET" }
		};

	public static void main(String[] args) {
		
		// Part 1
		int[] intArr = { 1, 2, 3, 4, 5 };
		printIntArray(intArr);
		
		// Part 2 (A)
		printStringArray2(stringArr);
		
		// Part 3 (B)
		System.out.println(">>> Enter the Row ID: "); // add-on user input
		String rowID = in.nextLine();
		
		String[] findArr = getArray(rowID);
		if (findArr != null) printStringArray(findArr);
		else System.out.println(">>> Row ID not found");
		
		// Part 4 (C)
		System.out.println(">>> Enter the Row Value: "); // add-on user input
		String rowValue = in.nextLine();
		
		String[] findArr2 = getArray2(rowValue);
		if (findArr2 != null) printStringArray(findArr2);
		else System.out.println(">>> Row Value not found");
	}
	
	public static void printIntArray(int[] arr) {
		System.out.print("{");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if (i < arr.length -1) System.out.print(", ");
		}
		System.out.println("}");
	}
	
	public static void printStringArray(String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if (i < arr.length - 1) System.out.print("\t"); // print tab for non last idx
		}
		System.out.println(); // new line once done
	}
	
	public static void printStringArray2(String[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j]);
				if (j < arr[0].length - 1) System.out.print("\t"); // print tab for non last idx
			}
			System.out.println(); // new line per row
		}
	}
	
	public static String[] getArray(String rowID) {
		for (String[] arr : stringArr) {
			if (rowID.equals(arr[0])) {
				return arr;
			}
		}
		return null; // return null if arr not found
	}
	
	public static String[] getArray2(String rowValue) {
		for (String[] arr : stringArr) {
			if (rowValue.equals(arr[arr.length - 1])) {
				return arr;
			}
		}
		return null; // return null if arr not found
	}

}
