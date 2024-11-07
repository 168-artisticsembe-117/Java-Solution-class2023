import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Map<String, Integer>> users = new TreeMap<>();
        while(!"end".equals(input)) {
            String[] inputArr = input.split(" ");
            String ip = inputArr[0].split("=")[1];
            String user = inputArr[2].split("=")[1];
            if(!users.containsKey(user)) {
                Map<String, Integer> countMap = new LinkedHashMap<>();
                countMap.put(ip, 1);
                users.put(user, countMap);
            } else {
                Map<String, Integer> countMap = users.get(user);
                if(countMap.containsKey(ip))
                    countMap.put(ip, countMap.get(ip) + 1);
                else
                    countMap.put(ip, 1);
            }
            input = scanner.nextLine();
        }

        users.forEach((user, ips) -> {
            System.out.println(user + ":");
            List<String> printList = new ArrayList<>();
            ips.forEach((ip, count) -> {
                printList.add(String.format("%s => %d", ip, count));
            });
            System.out.println(String.join(", ", printList) + ".");
        });
    }
}
