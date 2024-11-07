import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Set<String>> cards = new LinkedHashMap<>();
        while (true) {
            String input = scanner.nextLine();
            if(input.equals("JOKER"))
                break;
            String[] inputArray = input.split(": ");
            for(String card : inputArray[1].split(", ")) {
                if(cards.containsKey(inputArray[0])) {
                    cards.get(inputArray[0]).add(card);
                } else {
                    Set<String> cardSet = new HashSet<>();
                    cardSet.add(card);
                    cards.put(inputArray[0], cardSet);
                }
            }
        }
        cards.forEach((name, cardSet) ->
            System.out.printf("%s: %d%n", name, calculate(cardSet))
        );
    }

    private static int calculate(Set<String> cards) {
        int sum = 0;
        for(String card : cards) {
            char[] arr = card.toCharArray();
            if(Character.isDigit(arr[0]) &&  arr[1] != '0') {
                sum += getTypeAsNumber(arr[1]) * Integer.parseInt(arr[0] + "");
            } else {
                switch (arr[0]) {
                    case 'J': sum += getTypeAsNumber(arr[1]) * 11; break;
                    case 'Q': sum += getTypeAsNumber(arr[1]) * 12; break;
                    case 'K': sum += getTypeAsNumber(arr[1]) * 13; break;
                    case 'A': sum += getTypeAsNumber(arr[1]) * 14; break;
                    default: sum += getTypeAsNumber(arr[2]) * 10; break;
                }
            }
        }
        return sum;
    }

    private static int getTypeAsNumber(char type) {
        return type == 'S' ? 4 : type == 'H' ? 3 : type == 'D' ? 2 : 1;
    }
}
