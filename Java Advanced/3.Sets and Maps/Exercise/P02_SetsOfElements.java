import java.util.LinkedHashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        LinkedHashSet<Integer> setN = new LinkedHashSet<>();
        LinkedHashSet<Integer> setM = new LinkedHashSet<>();
        for (; n > 0; n--)
            setN.add(scanner.nextInt());
        for (; m > 0; m--)
            setM.add(scanner.nextInt());

        setN.retainAll(setM);

        for (Integer number : setN) {
            System.out.print(number + " ");
        }
    }
}
