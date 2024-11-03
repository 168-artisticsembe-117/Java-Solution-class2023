import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> parking = new LinkedHashSet<>();
        while (true) {
            String command = scanner.nextLine();
            if (command.equals("END")) {
                break;
            } else {
                String[] details = command.split(", ");

                if (details[0].equals("IN")) {
                    parking.add(details[1]);
                } else {
                    parking.remove(details[1]);
                }
            }
        }

        if (parking.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String car : parking) {
                System.out.println(car);
            }
        }

    }
}