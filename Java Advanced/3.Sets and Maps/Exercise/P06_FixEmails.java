import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> map = new LinkedHashMap<>();
        while(true) {
            String name = scanner.nextLine();
            if(name.equals("stop"))
                break;
            String email = scanner.nextLine();
            if (!email.endsWith("us") &&
                !email.endsWith("uk") &&
                !email.endsWith("com"))
                map.put(name, email);
        }
        map.forEach((username, email) -> System.out.printf("%s -> %s%n", username, email));
    }
}
