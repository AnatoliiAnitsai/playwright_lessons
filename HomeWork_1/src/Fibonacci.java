public class Fibonacci {
    public long[] getFibonacciByLength(int fibonacciLength){
        if (fibonacciLength <= 0) {
            throw new IllegalArgumentException(
                    "Fibonacci length must be greater than zero."
            );
        }
        long[] fibonacciNumbers = new long[fibonacciLength];
        if (fibonacciLength <= 2){
            for (int i = 0; i < fibonacciLength; i++)
                fibonacciNumbers[i] = i;
        } else {
            fibonacciNumbers[0] = 0;
            fibonacciNumbers[1] = 1;
            for (int i = 2; i < fibonacciLength; i++) {
                fibonacciNumbers[i] = fibonacciNumbers[i - 1] + fibonacciNumbers[i - 2];
            }
        }
        return fibonacciNumbers;
    }
}
