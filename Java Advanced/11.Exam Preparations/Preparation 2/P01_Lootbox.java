import java.util.*;

public class Main {
    public static void main(String[] args) {

        // 1. input
        Scanner scanner = new Scanner(System.in);

        //queue -> add() || offer()
        ArrayDeque<Integer> firstBox = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(firstBox::offer);

        // stack -> push()
        ArrayDeque<Integer> secondBox = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(secondBox::push);

        List<Integer> items = new ArrayList<>();

        // 2. process

        while (!firstBox.isEmpty() && !secondBox.isEmpty()) {
            int miniSum = firstBox.peek() + secondBox.peek();

            if (miniSum % 2 == 0) {
                items.add(miniSum);
                firstBox.poll();
                secondBox.pop();
            } else {
                firstBox.offer(secondBox.pop());
            }
        }


        // 3. output
        if (firstBox.isEmpty()) {
            System.out.println("First lootbox is empty");
        } else if (secondBox.isEmpty()) {
            System.out.println("Second lootbox is empty");
        }

        int sum = 0;
        for (int item : items) {
            sum += item;
        }

        if (sum >= 100) {
            System.out.printf("Your loot was epic! Value: %d", sum);
        } else {
            System.out.printf("Your loot was poor... Value: %d", sum);
        }
    }
}