import java.util.Arrays;
import java.util.Scanner;

public class L08_WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][];
        for (int i = 0; i < n; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }
        int[] indeces = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int wrongValue = matrix[indeces[0]][indeces[1]];
        int[][] result = new int[n][matrix[0].length];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == wrongValue) {
                    int sum = 0;
                    if(j - 1 >= 0 && matrix[i][j - 1] != wrongValue) {
                        sum += matrix[i][j - 1];
                    }
                    if(j + 1 < matrix[i].length && matrix[i][j + 1] != wrongValue) {
                        sum += matrix[i][j + 1];
                    }
                    if(i - 1 >= 0 && matrix[i - 1][j] != wrongValue) {
                        sum += matrix[i - 1][j];
                    }
                    if(i + 1 < n && matrix[i + 1][j] != wrongValue) {
                        sum += matrix[i + 1][j];
                    }
                    result[i][j] = sum;
                } else
                    result[i][j] = matrix[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
