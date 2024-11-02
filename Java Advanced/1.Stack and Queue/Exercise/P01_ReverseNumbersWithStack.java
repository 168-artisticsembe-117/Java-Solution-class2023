import java.util.ArrayDeque;
import java.util.Scanner;

public class P01_ReverseNumbersWithStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numbers = scanner.nextLine().split("\\s+");

        ArrayDeque<String> stack = new ArrayDeque<>();

        for (String num : numbers) {
            stack.push(num);
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }


    }
}