import java.util.Scanner;

public class L07_FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] board = new char[8][8];
        for (int i = 0; i < 8; i++) {
            String[] arr = scanner.nextLine().split(" ");
            for (int j = 0; j < 8; j++) {
                board[i][j] = arr[j].charAt(0);
            }
        }
        boolean found = false;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'q') {
                    boolean isValid = true;
                    for(int k = 0; k < 8; k++) {
                        if(i != k && board[k][j] == 'q') {
                            isValid = false;
                            break;
                        }
                    }
                    for(int k = 0; k < 8; k++) {
                        if(j != k && board[i][k] == 'q') {
                            isValid = false;
                            break;
                        }
                    }
                    for(int k = i - 1, m = j - 1; k >= 0 && m >= 0; k--, m--) {
                        if(board[k][m] == 'q') {
                            isValid = false;
                            break;
                        }
                    }
                    for(int k = i + 1, m = j + 1; k < 8 && m < 8; k ++, m ++) {
                        if(board[k][m] == 'q') {
                            isValid = false;
                            break;
                        }
                    }
                    for(int k = i + 1, m = j - 1; k < 8 && m >= 0; k++, m--) {
                        if(board[k][m] == 'q') {
                            isValid = false;
                            break;
                        }
                    }
                    for(int k = i - 1, m = j + 1; k >= 0 && m < 8; k--, m++) {
                        if(board[k][m] == 'q') {
                            isValid = false;
                            break;
                        }
                    }
                    if(isValid) {
                        System.out.println(i + " " + j);
                        found = true;
                        break;
                    }
                }
            }
            if(found) {
               break;
            }
        }
    }
}
