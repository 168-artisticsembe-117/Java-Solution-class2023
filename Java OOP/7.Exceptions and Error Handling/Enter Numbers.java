import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    private static int START = 1;
    private static final int END = 100;
    private static final List<Integer> values = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        while (values.size() < 10) {
            try {
                readNumber(START, END);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        String result = values.stream().map(String::valueOf).collect(Collectors.joining(", "));
        System.out.println(result);


    }

    public static void readNumber(int start, int end) throws Exception {
        String info = scanner.nextLine();

        try {
            int num = Integer.parseInt(info);
            if (num <= start || num >= end) {
                System.out.printf("Your number is not in range %d - %d!%n", start, end);
            } else {
                START = num;
                values.add(num);
            }
        } catch (Exception e) {
            throw new Exception("Invalid Number!");
        }

    }

}