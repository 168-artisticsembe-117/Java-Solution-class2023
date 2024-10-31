import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<String> history = new ArrayDeque<>();
        Deque<String> forward = new ArrayDeque<>();
        String line = scanner.nextLine();
        String current = "";

        while (!line.equals("Home")) {
            if (line.equals("back")) {
                if (!history.isEmpty()) {
                    forward.push(current);
                    current = history.pop();
                } else {
                    System.out.println("no previous URLs");
                    line = scanner.nextLine();
                    continue;
                }
            } else if (line.equals("forward")) {
                if (!forward.isEmpty()) {
                    history.push(current);
                    current = forward.pop();
                } else {
                    System.out.println("no next URLs");
                    line = scanner.nextLine();
                    continue;
                }
            } else {
                if (!current.equals("")) {
                    history.push(current);
                }
                forward.clear();
                current = line;
            }
            System.out.println(current);
            line = scanner.nextLine();
        }

    }
}