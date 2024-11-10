import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UnaryOperator<Double> calcVat = x -> x * 1.2;
        Function<String, Double> parseDbl = Double::parseDouble;

        List<Double> prices = new ArrayList<>();
        for(String input : scanner.nextLine().split(", "))
            prices.add(parseDbl.apply(input));
        System.out.println("Prices with VAT:");
        for(Double price : prices) {
            System.out.printf("%.2f%n", calcVat.apply(price));
        }
    }
}
