import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // 1. user info
        Scanner scanner = new Scanner(System.in);

        // N matrix length
        int n = Integer.parseInt(scanner.nextLine());

        // M commands count
        int m = Integer.parseInt(scanner.nextLine());

        // N row matrix
        char[][] matrix = new char[n][n];
        int playerRow = 0;
        int playerCol = 0;

        // Fill the matrix
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            for (int j = 0; j < n; j++) {
                matrix[i][j] = input.charAt(j);
                if (input.charAt(j) == 'f') {
                    playerRow = i;
                    playerCol = j;
                }
            }
        }

        // 2. Calculation
        boolean isWon = false;

        int[][] directions = {
                {-1, 0},    // up
                {1, 0},     // down
                {0, -1},    // left
                {0, 1}      // right
        };

        for (int i = 0; i < m; i++) {
            String command = scanner.nextLine();
            int direction;
            switch (command) {
                case "up":
                    direction = 0;
                    break;
                case "down":
                    direction = 1;
                    break;
                case "left":
                    direction = 2;
                    break;
                case "right":
                    direction = 3;
                    break;
                default:
                    throw new IllegalArgumentException("Wrong command");
            }

            // get next position
            int nextRow = (playerRow + directions[direction][0] + n) % n;
            int nextCol = (playerCol + directions[direction][1] + n) % n;
            char nextChar = matrix[nextRow][nextCol];

            // update position
            matrix[playerRow][playerCol] = '-';
            playerRow = nextRow;
            playerCol = nextCol;

            // check
            if (nextChar == 'F') {
                isWon = true;
                matrix[playerRow][playerCol] = 'f';
                break;
            } else if (nextChar == 'B') {
                // same direction +1
                nextRow = (playerRow + directions[direction][0] + n) % n;
                nextCol = (playerCol + directions[direction][1] + n) % n;
                nextChar = matrix[nextRow][nextCol];

                matrix[playerRow][playerCol] = 'B';
                playerRow = nextRow;
                playerCol = nextCol;

                if (nextChar == 'F') {
                    isWon = true;
                    matrix[playerRow][playerCol] = 'f';
                    break;
                }

            } else if (nextChar == 'T') {
                // backward -> opposite position
                nextRow = (playerRow - directions[direction][0] + n) % n;
                nextCol = (playerCol - directions[direction][1] + n) % n;

                matrix[playerRow][playerCol] = 'T';
                playerRow = nextRow;
                playerCol = nextCol;
            }

            matrix[playerRow][playerCol] = 'f';
        }


        // 3. Print
        if (isWon) {
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }


    }
}