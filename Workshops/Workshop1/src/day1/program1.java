package day1;

import java.util.Scanner;

public class program1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("hello world!");
		System.out.println("***********");
		System.out.println("*         *");
		System.out.println("***********");
		System.out.print("Please enter a number: ");
		int number = in.nextInt();
		System.out.println("Welcome to ISS");
		System.out.printf("%d+1 = %d%n", number, number + 1);

		in.close();
	}
}
