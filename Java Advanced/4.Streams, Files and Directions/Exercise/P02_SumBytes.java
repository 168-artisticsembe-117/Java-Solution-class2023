import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    static String inputPath = "/Users/...../input.txt";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(inputPath));

        String line = bufferedReader.readLine();
        long sum = 0;
        while (line != null) {
            for (char c: line.toCharArray()) {
                sum += c;
            }
            line = bufferedReader.readLine();
        }
        System.out.println(sum);
    }
}