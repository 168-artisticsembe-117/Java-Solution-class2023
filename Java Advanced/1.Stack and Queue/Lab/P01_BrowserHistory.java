import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class P01_BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<String> browser = new ArrayDeque<>();

        String line = scanner.nextLine();

        String curretn = "";

        while(!line.equals("Home")){
            if(line.equals("back")){
                if(!browser.isEmpty()) {
                    curretn = browser.pop();
                }else{
                    System.out.println("no previous URLs");
                    line = scanner.nextLine();
                    continue;
                }
            }else {
                if(!curretn.equals("")) {
                    browser.push(curretn);
                }
                curretn = line;
            }
            System.out.println(curretn);
            line = scanner.nextLine();
        }

    }
}
