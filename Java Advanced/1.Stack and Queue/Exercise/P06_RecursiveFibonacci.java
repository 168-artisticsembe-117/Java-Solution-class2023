import java.util.*;

public class P06_RecursiveFibonacci {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int index = Integer.parseInt(scanner.nextLine());

        if (index < 1 || index > 49) {
            return;
        }

        long result = getFibonacci(index);
        System.out.println(result);
    }

    public static Map<Integer, Long> memoizatoin = new HashMap<>(); // <K, V> == <Index, Fibo number>

    public static long getFibonacci(int index) {
        // bottom, no calculation
        if (index == 0 || index == 1) {
            return 1;
        }

        if(memoizatoin.containsKey(index)){
            return memoizatoin.get(index);
        }

        // recursive
        long result = getFibonacci(index - 1 ) + getFibonacci(index- 2);
        memoizatoin.put(index, result);
        return result;

    }
}