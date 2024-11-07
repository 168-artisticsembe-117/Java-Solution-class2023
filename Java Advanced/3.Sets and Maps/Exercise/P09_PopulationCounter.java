import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Map<String, Long>> countries = new LinkedHashMap<>();
        Map<String, Long> countryTotal = new LinkedHashMap<>();
        while (!"report".equals(input)) {
            String[] array = input.split("\\|");
            if(!countries.containsKey(array[1])) {
                Map<String, Long> cities = new LinkedHashMap<>();
                cities.put(array[0], Long.parseLong(array[2]));
                countries.put(array[1], cities);
                countryTotal.put(array[1], Long.parseLong(array[2]));
            } else {
                Map<String, Long> cities = countries.get(array[1]);
                if(cities.containsKey(array[0])){
                    cities.put(array[0], cities.get(array[0]) + Long.parseLong(array[2]));
                } else {
                    cities.put(array[0], Long.parseLong(array[2]));
                }
                countryTotal.put(array[1], countryTotal.get(array[1]) + Long.parseLong(array[2]));
            }
            input = scanner.nextLine();
        }

        countryTotal.entrySet().stream()
                .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                .forEach(conTotal -> {
                        System.out.printf("%s (total population: %d)%n", conTotal.getKey(), conTotal.getValue());
                        Map<String, Long> cities = countries.get(conTotal.getKey());
                        cities.entrySet().stream()
                                .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                                .forEach(cityTotal -> {
                                    System.out.printf("=>%s: %d%n", cityTotal.getKey(), cityTotal.getValue());
                                });
                });
    }
}
