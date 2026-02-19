import java.util.Arrays;
import java.util.Scanner;

public class CaesarCipherEncryption {
	
	private final static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		
		String upperPlainText = returnUpperInputSentence();
		String encryptedText = encryptSentence(upperPlainText);
		printEncryptedSentence(encryptedText);
		
		String decryptedText = decryptSentence(encryptedText);
		printDecryptedSentence(decryptedText);
		System.out.println("\nType any key to exit.");
		in.nextLine();
		in.close();
	}
	
	// MY CODE
	static String returnUpperInputSentence() {
		System.out.println(">>> Please enter the sentence: "); // prompt
		return in.nextLine().toUpperCase(); // input
	}
	
	static String encryptSentence(String text) {
		// conv to char array
		char[] arr = text.toCharArray();
		
		// loop arr
		for (int i = 0; i < arr.length; i++) {
			// handle non letter
			if (!Character.isLetter(arr[i])) continue;
			
			// get int form of letter
			int num = (int) arr[i];
			
			// if int >= 88 (X - Z), -26 to ensure wrap
			if (num >= 88) num -= 26;
			
			// shift letter by three letters forward
			arr[i] = (char) (num + 3);
		}
		
		return String.valueOf(arr); // return new string
	}
	
	static void printEncryptedSentence(String sentence) {
		System.out.printf(">>> The encrypted sentence is: %s%n", sentence);
	}
	
	static String decryptSentence(String inEncryptedText) {
		// conv to char array
		char[] arr = inEncryptedText.toCharArray();
		
		// loop arr
		for (int i = 0; i < arr.length; i++) {
			// handle non letter
			if (!Character.isLetter(arr[i])) continue;
			
			// get int form of letter
			int num = (int) arr[i];
			
			// if int < 68 (A - B), +26 to reverse wrap
			if (num < 68) num += 26;
			
			// shift letter by three letters backward
			arr[i] = (char) (num - 3);
		}
		
		return String.valueOf(arr); // return new string
	}
	
	static void printDecryptedSentence(String sentence) {
		System.out.printf(">>> The decrypted sentence is: %s%n", sentence);
	}

}
