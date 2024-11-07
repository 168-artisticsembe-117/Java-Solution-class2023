import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> elements = new TreeSet<>();
        int n = Integer.parseInt(scanner.nextLine());
        for(; n > 0; n--) {
            String[] els = scanner.nextLine().split(" ");
            for(String el : els)
                elements.add(el);
        }
        System.out.print(String.join(" ", elements));
    }
}
