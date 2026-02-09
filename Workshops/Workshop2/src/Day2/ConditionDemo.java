package Day2;

public class ConditionDemo {
    public static void main(String[] args) {
        int X = 3, Y = 5, Z = 6, A = 1;
        if (X < Y)
            if (X < Z)
                if (X < A) {
                    X = 0;
                    System.out.println(X);
                } else {
                    X = 1;
                    System.out.println(X);
                }
    }
}
