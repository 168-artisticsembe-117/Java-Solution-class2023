import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    static Function<Scanner, String> getString = Scanner::nextLine;
    static Function<Scanner, Integer> getInteger = x -> Integer.parseInt(x.nextLine());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = getInteger.apply(scanner);
        Map<String, Integer> people = new LinkedHashMap<>();
        for (; n > 0; n--) {
            String input = getString.apply(scanner);
            people.put(input.split(", ")[0], Integer.parseInt(input.split(", ")[1]));
        }
        String condition = getString.apply(scanner);
        Integer age = getInteger.apply(scanner);
        String format = getString.apply(scanner);

        Predicate<Map.Entry<String, Integer>> agePredicate = getCondition(condition, age);
        Consumer<Map.Entry<String, Integer>> print = getPrint(format);

        for(Map.Entry<String, Integer> person : people.entrySet()) {
            if(agePredicate.test(person)) {
                print.accept(person);
            }
        }
    }

    private static Predicate<Map.Entry<String, Integer>> getCondition(String condition, Integer age) {
        if (condition.equals("older"))
            return person -> person.getValue() >= age;
        else
            return person -> person.getValue() <= age;
    }

    private static Consumer<Map.Entry<String, Integer>> getPrint(String format) {
        if(format.equals("name"))
            return person -> System.out.println(person.getKey());
        else if(format.equals("age"))
            return person -> System.out.println(person.getValue());
        else
            return person -> System.out.println(person.getKey() + " - " + person.getValue());
    }
}
