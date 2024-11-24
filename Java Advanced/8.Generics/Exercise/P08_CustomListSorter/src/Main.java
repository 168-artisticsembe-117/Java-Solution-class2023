import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
        CustomList<String> customList = new CustomList<>();

        String[] commandTokens = reader.readLine().split("\\s+");

        String command = commandTokens[0];

        while (!command.equals("END")) {
            switch (command) {
                case "Add":
                    customList.add(commandTokens[1]);
                    break;
                case "Remove":
                    customList.remove(Integer.valueOf(commandTokens[1]));
                    break;
                case "Contains":
                    System.out.println(customList.contains(commandTokens[1]));
                    break;
                case "Swap":
                    int firstIndex = Integer.valueOf(commandTokens[1]);
                    int secondIndex = Integer.valueOf(commandTokens[2]);
                    customList.swap(firstIndex, secondIndex);
                    break;
                case "Greater":
                    System.out.println(customList.getCountOfElementsGreaterThan(commandTokens[1]));
                    break;
                case "Max":
                    System.out.println(customList.getMax());
                    break;
                case "Min":
                    System.out.println(customList.getMin());
                    break;
                case "Print":
                    for (String str : customList) {
                        System.out.println(str);
                    }
                    break;
                case "Sort":
                    Sorter.sort(customList);
                    break;
                default:
                    System.out.println("Invalid command.");
                    break;
            }

            commandTokens = reader.readLine().split("\\s+");
            command = commandTokens[0];
        }
    }
}
