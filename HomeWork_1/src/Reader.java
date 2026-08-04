import java.util.Scanner;

public class Reader {
    public int readNumber(){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            try {
                int number = Integer.parseInt(input);
                if (number > 0) {
                    return number;
                }
                System.out.println("Invalid input. The number must be greater than zero.");
            } catch (NumberFormatException exception) {
                System.out.println("Invalid input. You must enter a positive integer.");
            }
        }
    }
}
