import java.util.Arrays;
import java.util.Scanner;

public class L05_Biggest2X2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] rowcol = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[][] matrix = new int[rowcol[0]][rowcol[1]];
        for(int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(", "))
                    .sequential().mapToInt(Integer::parseInt).toArray();
        }
        int largestSum = Integer.MIN_VALUE;
        int rowIndex = 0;
        int colIndex = 0;
//        0,0  0,1
//        1,0  1,1
        for(int i = 0; i < matrix.length -1; i++) {
            for(int j = 0; j < matrix[i].length - 1; j++) {
                int sum = matrix[i][j] + matrix[i][j+1] + matrix[i+1][j] + matrix[i+1][j+1];
                if(sum > largestSum) {
                    largestSum = sum;
                    rowIndex = i;
                    colIndex = j;
                }
            }
        }
        System.out.println(matrix[rowIndex][colIndex] + " " + matrix[rowIndex][colIndex + 1]);
        System.out.println(matrix[rowIndex + 1][colIndex] + " " + matrix[rowIndex + 1][colIndex + 1]);
        System.out.println(largestSum);
    }
}
