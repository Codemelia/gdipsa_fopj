package Day2;

public class program3 {    
	public static void main(String[] args) {
    int a = 1;

    System.out.println(a++); // write a, then increase a

    a = 1;
    System.out.println(++a); // increase a, then write a
        
    // round example
    double x = 3.5934723;
    System.out.println(Math.round(x * 100.0) / 100.0); // 3.59
    System.out.println(Math.round(x * 10.0) / 10.0); // 3.6
    System.out.println(Math.round(x)); // 4
    System.out.println(Math.round(x * 100000.0) / 100000.0); // 3.59347

    System.out.println(Math.floor(x)); // 3.0

    System.out.println(Math.max(1, 2)); // 2
    double dx = -12.534565;
    System.out.println("Rounded value of " + dx + " is " + Math.round(dx));
	}
}
