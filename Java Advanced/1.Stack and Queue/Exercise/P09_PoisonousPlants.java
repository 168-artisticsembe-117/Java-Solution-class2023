import java.util.*;

public class P09_PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] pesticides = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        System.out.println(calculateDays(pesticides));
    }

    private static int calculateDays(int[] pesticides) {
        ArrayDeque<Integer> removeIndex = new ArrayDeque<>();
        int result = 0;
        int[] newPesticides = pesticides;

        while (true) {
            while (!removeIndex.isEmpty()) {
                int[] temp = new int[newPesticides.length - removeIndex.size()];
                for (int i = 0, k = 0; i < newPesticides.length; i++) {
                    if (removeIndex.contains(i)) {
                        continue;
                    }
                    temp[k++] = newPesticides[i];
                }
                newPesticides = temp;
                removeIndex = new ArrayDeque<>();
            }
            // collect removeIndex pesticides
            for (int i = 0; i < newPesticides.length - 1; i++) {
                int first = newPesticides[i];
                int second = newPesticides[i + 1];

                if (first < second) { // lower = stay pesticide
                    removeIndex.add(i + 1);
                }
            }
            if (removeIndex.isEmpty()) {
                break;
            }
            result++;
        }
        return result;
    }
}
