import java.util.ArrayDeque;
import java.util.Scanner;

public class P02_BasicStackOperation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] infos = scanner.nextLine().split("\\s+");

        int n = Integer.parseInt(infos[0]);
        int s = Integer.parseInt(infos[1]);
        int x = Integer.parseInt(infos[2]);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        String[] values = scanner.nextLine().split("\\s+");
        for (String value : values) {
            stack.push(Integer.parseInt(value));
        }

        for (int i = 0; i < s; i++) {
            stack.pop();
        }

        if (!stack.isEmpty()) {
            if (stack.contains(x)) {
                System.out.println("true");
            } else {
                int min = Integer.MAX_VALUE;
                while (!stack.isEmpty()) {
                    min = Integer.min(stack.pop(), min);
                }
                System.out.println(min);
            }
        } else {
            System.out.println(0);
        }

    }
}