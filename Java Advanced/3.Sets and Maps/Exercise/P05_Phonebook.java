import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, String> map = new HashMap<>();
        while(!"search".equals(input)) {
            String[] arr = input.split("-");
            map.put(arr[0], arr[1]);
            input = scanner.nextLine();
        }
        String name = scanner.nextLine();
        while (!"stop".equals(name)) {
            if(map.containsKey(name)) {
                System.out.printf("%s -> %s%n", name, map.get(name));
            } else
                System.out.printf("Contact %s does not exist.%n", name);
            name = scanner.nextLine();
        }
    }
}
