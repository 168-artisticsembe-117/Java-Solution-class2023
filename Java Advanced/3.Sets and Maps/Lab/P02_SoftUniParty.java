import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    static Set<String> vipMembers = new TreeSet<>();
    static Set<String> regularMembers = new TreeSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean started = false;

        while (true) {
            String command = scanner.nextLine();
            if (command.equals("END")) {
                break;
            } else {
                if (command.equals("PARTY")) {
                    started = true;
                } else {
                    process(command, started);
                }
            }
        }
        System.out.println(vipMembers.size() + regularMembers.size());
        vipMembers.forEach(System.out::println);
        regularMembers.forEach(System.out::println);
    }

    public static void process(String member, boolean operation) {
        if (Character.isDigit(member.charAt(0))) {
            boolean b = operation ? vipMembers.remove(member) : vipMembers.add(member);
        } else {
            boolean b = operation ? regularMembers.remove(member) : regularMembers.add(member);
        }
    }
}