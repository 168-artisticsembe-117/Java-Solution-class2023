import java.util.Arrays;
import java.util.Scanner;

public class L02_PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] rowcol = Arrays.stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt).toArray();

        int[][] matrix = new int[rowcol[0]][rowcol[1]];
        for(int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" "))
                    .sequential().mapToInt(Integer::parseInt).toArray();
        }

        int number = Integer.parseInt(scanner.nextLine());
        boolean check = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == number) {
                    check = true;
                    System.out.println(i + " " + j);
                }
            }
        }
        if (!check) {
            System.out.println("not found");
        }
    }
}
