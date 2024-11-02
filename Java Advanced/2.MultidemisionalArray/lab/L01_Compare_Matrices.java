import java.util.Arrays;
import java.util.Scanner;

public class L01_Compare_Matrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] firstInput =
                Arrays.stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt).toArray();
        int[][] matrix1 = new int[firstInput[0]][firstInput[1]];

        for(int i = 0; i < matrix1.length; i++) {
            matrix1[i] = Arrays.stream(scanner.nextLine().split(" "))
                    .sequential().mapToInt(Integer::parseInt).toArray();
        }

        int[] secondInput =
                Arrays.stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt).toArray();
        int[][] matrix2 = new int[secondInput[0]][secondInput[1]];
        for(int i = 0; i < matrix2.length; i++) {
            matrix2[i] = Arrays.stream(scanner.nextLine().split(" "))
                    .sequential().mapToInt(Integer::parseInt).toArray();
        }
        boolean check = compare(matrix1, matrix2);
        if (check) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }

    static boolean compare(int[][] matrix1, int[][] matrix2) {
        if(matrix1.length != matrix2.length) {
            return false;
        }
        for(int i = 0; i < matrix2.length; i++) {
            if(matrix1[i].length != matrix2[i].length)
                return false;
            for(int j = 0; j < matrix2[i].length; j++) {
                if(matrix1[i][j] != matrix2[i][j])
                    return false;
            }
        }
        return true;
    }
}
