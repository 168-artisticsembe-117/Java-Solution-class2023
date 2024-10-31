import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] expressions = scanner.nextLine().split("\\s+");
        StringBuilder result = new StringBuilder();
        ArrayDeque<String> operatorStack = new ArrayDeque<>();

        for (String expression : expressions) {
            if (isNumberOrVar(expression)) { // number or operator
                result.append(expression).append(" ");
            } else if (expression.equals("(")) {
                operatorStack.push(expression);
            } else if (expression.equals(")")) {

                while (!operatorStack.isEmpty() && !operatorStack.peek().equals("(")) {
                    result.append(operatorStack.pop()).append(" ");
                }
                operatorStack.pop();

            } else { // operator

                if (!operatorStack.isEmpty() && checkOperator(expression) <= checkOperator(operatorStack.peek())) {
                    result.append(operatorStack.pop()).append(" ");
                }
                operatorStack.push(expression);
            }

        }

        while (!operatorStack.isEmpty()) {
            result.append(operatorStack.pop()).append(" ");
        }

        System.out.println(result.toString().trim());
    }

    private static boolean isNumberOrVar(String expression) {
        return expression.matches("\\d+") || expression.matches("[a-z]");
    }

    private static int checkOperator(String operator) {
        switch (operator) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            default:
                return 0;
        }
    }
}