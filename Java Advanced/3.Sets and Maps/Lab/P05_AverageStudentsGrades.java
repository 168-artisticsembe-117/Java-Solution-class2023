import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> students = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] infos = scanner.nextLine().split("\\s+");

            if (!students.containsKey(infos[0])) {
                students.put(infos[0], new ArrayList<>(List.of(Double.parseDouble(infos[1]))));
            } else {
                List<Double> grades = students.get(infos[0]);
                grades.add(Double.parseDouble(infos[1]));
                students.put(infos[0], grades);
            }
        }

        for (String key : students.keySet()) {
            Double total = 0.0;
            StringBuilder stringBuilder = new StringBuilder();
            for (Double grade : students.get(key)) {
                stringBuilder.append(String.format("%.2f ", grade));
                total += grade;
            }
            System.out.printf("%s -> %s(avg: %.2f)%n", key, stringBuilder.toString(), total / students.get(key).size());
        }
    }
}