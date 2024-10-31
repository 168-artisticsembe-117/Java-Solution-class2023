import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] infos = scanner.nextLine().split("\\s+");

        int n = Integer.parseInt(infos[0]);
        int s = Integer.parseInt(infos[1]);
        int x = Integer.parseInt(infos[2]);

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        String[] values = scanner.nextLine().split("\\s+");
        for (String value : values) {
            queue.add(Integer.parseInt(value));
        }

        for (int i = 0; i < s; i++) {
            queue.remove();
        }

        if (!queue.isEmpty()) {
            if (queue.contains(x)) {
                System.out.println("true");
            } else {
                int min = Integer.MAX_VALUE;
                while (!queue.isEmpty()) {
                    min = Integer.min(queue.remove(), min);
                }
                System.out.println(min);
            }
        } else {
            System.out.println(0);
        }

    }
}