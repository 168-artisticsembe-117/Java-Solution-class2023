import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> attendees = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());
        String input = scanner.nextLine();
        while (!"Party!".equals(input)) {
            String[] arr = input.split("\\s+");
            String command = arr[0];
            String filter = arr[1];
            String filterValue = arr[2];
            Predicate<String> predicate = getPredicate(filter, filterValue);
            if (command.equals("Remove")) {
                attendees = attendees.stream().filter(predicate.negate())
                        .collect(Collectors.toList());
            } else  {
                List<String> newList = new ArrayList<>();
                for(String attendee : attendees) {
                    newList.add(attendee);
                    if (predicate.test(attendee)) {
                        newList.add(attendee);
                    }
                }
                attendees = newList;
            }
            input = scanner.nextLine();
        }
        Collections.sort(attendees);
        if(attendees.isEmpty())
            System.out.println("Nobody is going to the party!");
        else
            System.out.println(String.join(", ", attendees) + " are going to the party!");
    }

    private static Predicate<String> getPredicate(String filter, String value) {
        switch (filter) {
            case "StartsWith":
                return x -> x.startsWith(value);
            case "EndsWith":
                return x -> x.endsWith(value);
            case "Length":
                return x -> x.length() == Integer.parseInt(value);
            default: return null;
        }
    }
}
