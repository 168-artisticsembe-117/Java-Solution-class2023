import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();

        try{
            int num = Integer.parseInt(value);

            if(num < 0){
                throw new Exception();
            }

            double result = Math.sqrt(num);
            System.out.printf("%.2f%n", result);

        } catch (Exception e){
            System.out.println("Invalid");
        } finally {
            System.out.println("Goodbye");
        }

    }

}