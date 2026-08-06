import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Reader reader = new Reader();
        Fibonacci fibonacci = new Fibonacci();

        System.out.print("Enter the number of Fibonacci numbers: ");

        int fibonacciLength = reader.readNumber();
        int[] fibonacciNumbers = fibonacci.getFibonacciByLength(fibonacciLength);
        System.out.println(Arrays.toString(fibonacciNumbers));
    }
}