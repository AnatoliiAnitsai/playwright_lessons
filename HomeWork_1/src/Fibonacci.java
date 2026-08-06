public class Fibonacci {
    public int[] getFibonacciByLength(int fibonacciLength){
        int[] fibonacciNumbers = new int[fibonacciLength];
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
