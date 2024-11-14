import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    static String inputWords = "/Users/...../words.txt";
    static String inputPath = "/Users/...../text.txt";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReaderWords = new BufferedReader(new FileReader(inputWords));
        BufferedReader bufferedReader = new BufferedReader(new FileReader(inputPath));

        List<String> words = new ArrayList<>();
        String str[] = bufferedReaderWords.readLine().split(" ");
        words = Arrays.asList(str);

        int[] size = new int[words.size()];

        String line = bufferedReader.readLine();
        while (line != null) {
            for (int i = 0; i < words.size(); i++) {
                String word = words.get(i);
                int wordCount= countOccurrencesIgnoreCase(word, line);
                size[i] += wordCount;
            }
            line = bufferedReader.readLine();
        }
        for (int i = 0; i < words.size(); i++) {
            System.out.printf("%s - %d%n", words.get(i), size[i]);
        }
    }

    static int countOccurrencesIgnoreCase(String word, String line) {
        int count = 0;
        String[] totalWords = line.split(" ");
        for (String single : totalWords) {
            if (word.equals(single)) {
                count++;
            }
        }
        return count;
    }
}