import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String inputPath = "C:\\Users\\......\\Exercises Resources";
        File folder = new File(inputPath);
        File[] files = folder.listFiles();
        long size = 0;

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    size += file.length(); // Add file size
                }
            }
        }

        System.out.printf("Folder size: %d", size);
    }
}