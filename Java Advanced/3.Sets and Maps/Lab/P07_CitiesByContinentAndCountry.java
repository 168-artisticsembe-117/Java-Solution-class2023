import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, LinkedHashMap<String, ArrayList<String>>> continents = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] infos = scanner.nextLine().split("\\s+");

            if (!continents.containsKey(infos[0])) {
                // if continent is empty, add new continent
                LinkedHashMap<String, ArrayList<String>> countries = new LinkedHashMap<>();
                countries.put(infos[1], new ArrayList<>(List.of(infos[2])));
                continents.put(infos[0], countries);
            } else {
                // continent exists, get countries
                LinkedHashMap<String, ArrayList<String>> countries = continents.get(infos[0]);

                if (!countries.containsKey(infos[1])) {
                    // if country is empty, add new country
                    countries.put(infos[1], new ArrayList<>(List.of(infos[2])));
                } else {
                    // country exists, add city
                    List<String> cities = countries.get(infos[1]);
                    cities.add(infos[2]);
                }
            }
        }

        for (String continent : continents.keySet()) {
            System.out.printf("%s:%n", continent);
            for (String country : continents.get(continent).keySet()) {
                StringBuilder stringBuilder = new StringBuilder();
                for (String city : continents.get(continent).get(country)) {
                    stringBuilder.append(city).append(", ");
                }
                stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
                System.out.printf("  %s -> %s%n", country, stringBuilder.toString());
            }
        }
    }
}