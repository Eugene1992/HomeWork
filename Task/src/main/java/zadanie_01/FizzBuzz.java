package zadanie_01;

/**
 * Created by Sviatoslav on 15.03.2017.
 */
public class FizzBuzz {
    public static void main(String[] args) {
        numWriter();
    }

    public static void numWriter() {
        for (int i = 1; i < 100; i++) {
            if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else {
                System.out.println(i);
            }
        }
    }
}
