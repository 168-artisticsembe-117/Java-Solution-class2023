import java.util.Scanner;

public class L03_IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = Integer.parseInt(scanner.nextLine());
        int col = Integer.parseInt(scanner.nextLine());
        String[][] matrix1 = new String[row][col];
        String[][] matrix2 = new String[row][col];
        for (int i = 0; i < row; i++) {
            matrix1[i] = scanner.nextLine().split(" ");
        }
        for (int i = 0; i < row; i++) {
            matrix2[i] = scanner.nextLine().split(" ");
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(matrix1[i][j].equals(matrix2[i][j]))
                    System.out.print(matrix1[i][j] + " ");
                else
                    System.out.print("* ");
            }
            System.out.println();
        }
    }
}
