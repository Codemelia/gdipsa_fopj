package day1;

import java.util.Scanner;

public class program3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Please enter your name: ");
		String userName = scanner.nextLine();

		System.out.print("Enter your age: ");
		int age = scanner.nextInt();

		System.out.println("Hi " + userName + "!");
		System.out.printf("Hi, %s! Your age is %d%n", userName, age);		
		
		scanner.close();

	}
}
