import java.io.PrintWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        // 1. input
        Scanner scanner = new Scanner(System.in);

        // n matrix
        int n = Integer.parseInt(scanner.nextLine());

        // n row data
        char[][] matrix = new char[n][n];
        int beeRow = 0;
        int beeCol = 0;

        boolean isLost = false;
        int pollinatedCount = 0;

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < n; j++) {
                matrix[i][j] = line.charAt(j);
                if (matrix[i][j] == 'B') {
                    beeRow = i;
                    beeCol = j;
                }

            }
        }

        // 2. process
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            // Bee old position -> '.'
            matrix[beeRow][beeCol] = '.';

            // Bee new position
            switch (command) {
                case "up":
                    beeRow--;
                    break;
                case "down":
                    beeRow++;
                    break;
                case "left":
                    beeCol--;
                    break;
                case "right":
                    beeCol++;
                    break;
                default:
                    break;
            }

            // isLost
            if (beeRow < 0 || beeRow >= n || beeCol < 0 || beeCol >= n) {
                isLost = true;
                break;
            }

            // check 'f' || 'O'
            char newPosition = matrix[beeRow][beeCol];
            if (newPosition == 'f') {
                pollinatedCount++;
            } else if (newPosition == 'O') {
                // delete 'O'
                matrix[beeRow][beeCol] = '.';
                // Repeat move
                // Bee new position
                switch (command) {
                    case "up":
                        beeRow--;
                        break;
                    case "down":
                        beeRow++;
                        break;
                    case "left":
                        beeCol--;
                        break;
                    case "right":
                        beeCol++;
                        break;
                    default:
                        break;
                }

                // isLost
                if (beeRow < 0 || beeRow >= n || beeCol < 0 || beeCol >= n) {
                    isLost = true;
                    break;
                }
                if (matrix[beeRow][beeCol] == 'f') {
                    pollinatedCount++;
                }
            }
            matrix[beeRow][beeCol] = 'B';
            command = scanner.nextLine();
        }


        // 3. output
        if (isLost) {
            System.out.println("The bee got lost!");
        }

        if (pollinatedCount >= 5) {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", pollinatedCount);
        } else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - pollinatedCount);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}