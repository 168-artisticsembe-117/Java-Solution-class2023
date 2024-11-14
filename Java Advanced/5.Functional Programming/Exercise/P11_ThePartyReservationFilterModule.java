import java.util.*;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] people = scanner.nextLine().split("\\s+");
        String input = scanner.nextLine();
        Map<String, List<String>> filterMap = new LinkedHashMap<>();
        while(!input.equals("Print")) {
            String[] inputs = input.split(";");
            String command = inputs[0];
            String filterType = inputs[1];
            String filterParam = inputs[2];
            switch (command) {
                case "Add filter":
                    if(!filterMap.containsKey(filterType)) {
                        filterMap.put(filterType, new ArrayList<>());
                    }
                    filterMap.get(filterType).add(filterParam);
                    break;
                case "Remove filter":
                    List<String> params = filterMap.get(filterType);
                    if(params != null)
                        params.remove(filterParam);
                    break;
            }
            input = scanner.nextLine();
        }

        List<String> result = new ArrayList<>();
        for(String person : people ) {
            if(!check(person, filterMap))
                result.add(person);
        }

        System.out.println(String.join(" ", result));
    }

    private static boolean check(String person, Map<String, List<String>> map) {
        for(Map.Entry<String, List<String>> entry : map.entrySet()) {
            Predicate<String> predicate = getPredicate(entry.getValue(), entry.getKey());
            if(predicate.test(person))
                return true;
        }
        return false;
    }

    private  static Predicate<String> getPredicate(List<String> list, String type) {
        switch (type) {
            case "Starts with":
                return x -> {
                    for(String el : list) {
                        if (x.startsWith(el))
                            return true;
                    }
                    return false;
                };
            case "Ends with":
                return x -> {
                    for(String el : list) {
                        if (x.endsWith(el))
                            return true;
                    }
                    return false;
                };
            case "Length":
                return x -> {
                    for (String el : list) {
                        if(x.length() == Integer.parseInt(el))
                            return true;
                    }
                    return false;
                };
            case "Contains":
                return x -> {
                    for(String el : list) {
                        if (x.contains(el))
                            return true;
                    }
                    return false;
                };
            default: return null;
        }
    }
}
