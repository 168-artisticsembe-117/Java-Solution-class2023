import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    static String input1 = "/Users/...../inputOne.txt";
    static String input2 = "/Users/...../inputTwo.txt";

    public static void main(String[] args) throws IOException {
        BufferedReader readerInput1 = new BufferedReader(new FileReader(input1));
        BufferedReader readerInput2 = new BufferedReader(new FileReader(input2));

        String lineInput1 = readerInput1.readLine();
        String lineInput2 = readerInput2.readLine();

        while(lineInput1 != null){
            System.out.println(lineInput1);
            lineInput1 = readerInput1.readLine();
        }
        while(lineInput2 != null){
            System.out.println(lineInput2);
            lineInput2 = readerInput2.readLine();
        }

    }
}