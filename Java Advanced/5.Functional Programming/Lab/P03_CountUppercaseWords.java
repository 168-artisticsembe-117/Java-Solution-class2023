import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Predicate<String> checkUpperCase = x -> Character.isUpperCase(x.charAt(0));

        List<String> upperCaseWords = new ArrayList<>();
        for(String str : scanner.nextLine().split(" ")) {
            if(checkUpperCase.test(str))
                upperCaseWords.add(str);
        }
        System.out.println(upperCaseWords.size());
        for(String word : upperCaseWords)
            System.out.println(word);
    }
}
