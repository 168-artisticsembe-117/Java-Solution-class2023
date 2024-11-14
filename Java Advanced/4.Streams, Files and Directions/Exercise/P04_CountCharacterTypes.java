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

        List<Character> symbols = new ArrayList<>();
        Collections.addAll(symbols, '.', ',', '!', '?');

        List<Character> vowels = new ArrayList<>();
        Collections.addAll(vowels, 'a', 'e', 'i', 'o', 'u');

        int countSymbols = 0;
        int countVowels = 0;
        int countOthers = 0;

        String line = bufferedReader.readLine();
        while (line != null) {
            for (char c : line.toCharArray()) {
                if (symbols.contains(c))
                    countSymbols++;
                else if (vowels.contains(c))
                    countVowels++;
                else {
                    if (c != 32)
                        countOthers++;
                }
            }
            line = bufferedReader.readLine();
        }
        System.out.println(countSymbols);
        System.out.println(countVowels);
        System.out.println(countOthers);
    }
}