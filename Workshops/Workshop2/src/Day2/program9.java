package Day2;

public class program9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char letter = 'a';                 // Same as 97
		char anotherLetter = 98;           // Same as the letter 'b'
		                             // You can assign an integer in the range of [0, 65535] to char
		System.out.println(letter);        // 'a' printed
		System.out.println(anotherLetter);  // 'b' printed instead of the number, because the type is char
		anotherLetter += 2;                // 100 or 'd'
		System.out.println(anotherLetter); // 'd' printed

	}

}
