import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // 1. get user info

        Scanner scanner = new Scanner(System.in);
        // tasks(stack)
        Deque<Integer> tasks = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(tasks::push);

        // threads(queue)
        Deque<Integer> threads = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).forEach(threads::add);

        // killTask(int)
        int num = Integer.parseInt(scanner.nextLine());

        // 2. Calculation
        int thread = 0;
        int task = 0;

        while (true) {
            thread = threads.peek();
            task = tasks.peek();

            if (task == num) {
                break;
            } else {
                if (thread >= task) {
                    threads.poll();
                    tasks.pop();
                } else if (thread < task) {
                    threads.poll();
                }
            }
        }

        // 3. Print result {thread kiiled task} {left threads}
        System.out.printf("Thread with value %d killed task %d%n", thread, task);
        for (Integer element : threads) {
            System.out.print(element + " ");
        }
    }
}