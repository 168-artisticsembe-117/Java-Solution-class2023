import java.util.*;

public class Main {

    public ArrayDeque<String> stack = new ArrayDeque<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main editor = new Main();
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            String[] commands = scanner.nextLine().split("\\s+");
            editor.process(commands);
        }

        scanner.close();
    }

    public void process(String[] commands) {
        StringBuilder text;
        if (!stack.isEmpty()) {
            text = new StringBuilder(stack.peek());
        } else {
            text = new StringBuilder();
        }

        switch (Integer.parseInt(commands[0])) {
            // case 1,2 -> stack nemne
            case 1:
                text.append(commands[1]);
                stack.push(text.toString());
                break;
            case 2:
                int count = Integer.parseInt(commands[1]);
                text.delete(text.length() - count, text.length());
                stack.push(text.toString());
                break;
            // print index
            case 3:
                int index = Integer.parseInt(commands[1]) - 1;
                if (index >= 0 && index < text.length()) {
                    System.out.println(text.charAt(index));
                }
                break;
            // case 4 -> stack delete :: undone
            case 4:
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                break;
        }
    }
}