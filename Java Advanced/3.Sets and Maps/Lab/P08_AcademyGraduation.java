import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        TreeMap<String, Double[]> graduationList = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            String[] scoresStrings = scanner.nextLine().split(" ");
            Double[] scores = new Double[scoresStrings.length];

            for (int j = 0; j < scoresStrings.length; j++) {
                scores[j] = Double.parseDouble(scoresStrings[j]);
            }
            graduationList.put(name, scores);
        }

        for (String key : graduationList.keySet()) {
            Double sum = 0.0;
            for (Double score : graduationList.get(key)) {
                sum += score;
            }
            System.out.printf("%s is graduated with %s%n", key, sum / graduationList.get(key).length);
        }
    }
}