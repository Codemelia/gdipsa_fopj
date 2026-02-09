package Day2;

public class program10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Convert primitive to string
		// Using String concatenation operator '+' with an empty String (applicable to ALL primitive types)
		String str1 = 123 + "";    // int 123 -> String "123"
		String str2 = 12.34 + "";  // double 12.34 -> String "12.34"
		String str3 = 'c' + "";    // char 'c' -> String "c"
		String str4 = true + "";   // boolean true -> String "true"
		 
		// Using String.valueOf(aPrimitive) (applicable to ALL primitive types)
		String str5 = String.valueOf(12345);   // int 12345 -> String "12345"
		String str6 = String.valueOf(true);    // boolean true -> String "true"
		String str7 = String.valueOf(55.66);   // double 55.66 -> String "55.66"
		 
		// Using toString() for each primitive type
		String str8 = Integer.toString(1234);   // int 1234 -> String "1234"
		String str9 = Double.toString(1.23);    // double 1.23 -> String "1.23"
		String str10 = Character.toString('z'); // char 'z' -> String "z"
		
		// Print results
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		System.out.println(str4);
		System.out.println(str5);
		System.out.println(str6);
		System.out.println(str7);
		System.out.println(str8);
		System.out.println(str9);
		System.out.println(str10);
	}

}
