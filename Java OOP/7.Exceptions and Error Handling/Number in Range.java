import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        String[] infos = scanner.nextLine().split(" ");
        int start = Integer.parseInt(infos[0]);
        int end = Integer.parseInt(infos[1]);
        System.out.printf("Range: [%d...%d]%n", start, end);

        boolean notStop = true;
        String value = scanner.nextLine();

        while (notStop) {
            try {
                checkNumber(start, end, value);
                notStop = false;
                System.out.printf("Valid number: %s%n", value);
            } catch (Exception e) {
                System.out.printf("Invalid number: %s%n", value);
                value = scanner.nextLine();
            }
        }

    }

    public static void checkNumber(int start, int end, String value) throws Exception {
        int number = Integer.parseInt(value);
        if (number < start || number > end) {
            throw new IllegalArgumentException();
        }
    }

}