import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        Map<Character, Integer> map = new TreeMap<>();
        for(Character ch : text.toCharArray()) {
            if(map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            }  else {
                map.put(ch, 1);
            }
        }
        map.forEach((ch, count) -> System.out.printf("%c: %d time/s%n", ch, count));
    }
}
