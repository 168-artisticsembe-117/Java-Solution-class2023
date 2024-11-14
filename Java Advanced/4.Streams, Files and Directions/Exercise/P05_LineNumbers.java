import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static String inputPath = "/Users/...../input.txt";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(inputPath));

        String line = bufferedReader.readLine();
        var count = 1;
        while (line != null) {
            System.out.printf("%d. %s%n",count, line);
            count++;
            line = bufferedReader.readLine();
        }
    }
}