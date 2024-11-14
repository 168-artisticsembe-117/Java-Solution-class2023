import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        String inputPath = "C:\\Users\\....\\input.txt";
        String outputPath = "C:\\Users\\....\\output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath))) {
            PrintWriter writer = new PrintWriter(new FileOutputStream(outputPath));

            String line;
            while ((line = reader.readLine()) != null) {
                writer.println(line.toUpperCase());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}