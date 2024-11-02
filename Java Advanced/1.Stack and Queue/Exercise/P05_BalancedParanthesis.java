import java.util.*;

class P05_BalancedParanthesis {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine(); // "xyz"
        ArrayDeque<Character> openings = new ArrayDeque<>();
        boolean balanced = true;

        for (char ch : expression.toCharArray()) { // expression.toCharArray() -> ['x','y','z']
            // ( { [ push to stack
            if (ch == '(' || ch == '[' || ch == '{') {
                openings.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                switch(ch){
                    case ')':
                        // stack latest element not matching UN-Balanced
                        if (openings.isEmpty() || openings.pop() != '(') {
                            balanced = false; // un-balanced
                        }
                        break;
                    case ']':
                        if (openings.isEmpty() || openings.pop() != '[') {
                            balanced = false; // un-balanced
                        }
                        break;
                    case '}':
                        if (openings.isEmpty() || openings.pop() != '{') {
                            balanced = false; // un-balanced
                        }
                        break;
                    default:
                        break;
                }
            }
        }

        System.out.println(balanced ? "YES" : "NO");
    }
}