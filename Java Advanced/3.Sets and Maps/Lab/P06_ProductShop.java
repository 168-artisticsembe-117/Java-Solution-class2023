import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, LinkedHashMap<String, Double>> stores = new TreeMap<>();

        while (true) {
            String command = scanner.nextLine();
            if (command.equals("Revision")) {
                break;
            } else {
                String[] infos = command.split(", ");

                if (!stores.containsKey(infos[0])) {
                    LinkedHashMap<String, Double> products = new LinkedHashMap<>();
                    products.put(infos[1], Double.parseDouble(infos[2]));
                    stores.put(infos[0], products);
                } else {
                    LinkedHashMap<String, Double> products = stores.get(infos[0]);
                    products.put(infos[1], Double.parseDouble(infos[2]));
                    stores.put(infos[0], products);
                }
            }
        }

        for (String key : stores.keySet()) {
            System.out.printf("%s->%n", key);
            for (String product : stores.get(key).keySet()) {
                System.out.printf("Product: %s, Price: %.1f%n", product, stores.get(key).get(product));
            }
        }
    }
}