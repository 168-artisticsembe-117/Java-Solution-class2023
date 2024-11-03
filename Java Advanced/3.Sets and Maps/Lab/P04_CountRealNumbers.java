import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] values = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble).toArray();

        Map<Double, Integer> countingOccurences = new LinkedHashMap<>();

        for (double value : values) {
            if (countingOccurences.containsKey(value)) {
                countingOccurences.put(value, countingOccurences.get(value) + 1);
            } else {
                countingOccurences.put(value, 1);
            }
        }

        for (double key : countingOccurences.keySet()) {
            System.out.printf("%.1f -> %d%n", key, countingOccurences.get(key));
        }
    }
}