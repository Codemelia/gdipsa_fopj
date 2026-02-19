import java.util.Scanner;

public class ExerciseA {

    // scanner
    private static final Scanner scanner = new Scanner(System.in);

    // main
    public static void main(String[] args) {

        // conv input to number
        // throws exception if input is not number
        try {
            int loop = 1;

            while (loop == 1) {
                // prompt user to select question to run
                System.out.println(">>> Select the function you wish to run:\n1. Q1\n2. Q2\n3. Q3\n4. Q4\n5. Q5");
                int input = scanner.nextInt();
                scanner.nextLine(); // clears newline in buffer from nextInt()

                // run respective function based on input
                // invalid input is handled by throwing exception
                String output = selectFunction(input);
                System.out.printf(">>> Output:\n%s\n", output);

                // ask if user wishes to continue
                System.out.println(">>> Would you like to run another function? (Y/N)");
                String cont = scanner.nextLine().trim().toLowerCase();

                // if user does not want to continue, exit loop; else continue
                if (!cont.equals("yes") && !cont.equals("y")) { loop = 0; } 
            }
            
            // close scanner
            scanner.close();

        } catch (Exception ex) {
            System.out.println(">>> Invalid input! Please enter your input as instructed");
            scanner.close();
            return; // exit program
        }

    }

    // helper functions

    // select function based on input
    public static String selectFunction(int selected) {

        switch (selected) {
            case 1: return runQ1();
            case 2: return runQ2();
            case 3: return runQ3();
            case 4: return runQ4();
            case 5: return runQ5();

            default: throw new IllegalArgumentException("Input is out of range.");
        }

    }

    // respective question functions
    public static String runQ1() {
        String name = "Amelia";
        String email = "amelia.wong@u.nus.edu";
        return name + "\n" + email;
    }

    public static String runQ2() {
        System.out.println(">>> Enter your name");
        String name = scanner.nextLine();
        return "Good Morning" + name;
    }

    public static String runQ3() {
        System.out.println(">>> Enter an integer: ");
        int input = scanner.nextInt(); // does not register enter ("\n") so next input won't register
        scanner.nextLine(); // required to register next input
        return input * input + "";
    }

    public static String runQ4() {
        System.out.println(">>> Enter a double precision number: ");
        double input = scanner.nextDouble();
        scanner.nextLine();
        return input * input + "";
    }

    public static String runQ5() {
        System.out.println(">>> Enter a double precision number: ");
        double input = scanner.nextDouble();
        scanner.nextLine();
        return String.format("%.2f", input);
    }
    
}