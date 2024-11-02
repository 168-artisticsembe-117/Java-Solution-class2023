import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class P10_Robotics {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);

        // Get robot data
        List<Robot> robots = new ArrayList<>();
        for (String entry : scanner.nextLine().split(";")) {
            String[] parts = entry.split("-");
            robots.add(new Robot(parts[0], Long.parseLong(parts[1])));
        }

        // Get starting time
        String startTimeString = scanner.nextLine();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date startTime = format.parse(startTimeString);
        long startMillis = startTime.getTime();

        // Get products until 'End'
        Queue<String> products = new LinkedList<>();
        String product;

        while (!(product = scanner.nextLine()).equals("End")) {
            products.offer(product);
        }

        // Process
        while (!products.isEmpty()) {
            // Check for the next product to process
            String currentProduct = products.poll();
            long currentTime = startMillis; // [start time + 1 second]

            // Find the first available robot
            Robot availableRobot = null;
            for (Robot robot : robots) {
                if (robot.nextFreeTime <= currentTime) {
                    availableRobot = robot;
                    break;
                }
            }

            // If no robot is available, requeue the product
            if (availableRobot == null) {
                products.offer(currentProduct);
            } else {
                // Schedule the robot for processing
                String formattedTime = format.format(new Date(currentTime + 1000L));
                System.out.printf("%s - %s [%s]%n", availableRobot.name, currentProduct, formattedTime);
                availableRobot.nextFreeTime = currentTime + availableRobot.processingTime * 1000L; // Update next free time
            }
            startMillis += 1000L;
        }
    }

    static class Robot {
        String name;
        Long processingTime;
        Long nextFreeTime;

        public Robot(String name, Long processingTime) {
            this.name = name;
            this.processingTime = processingTime;
            this.nextFreeTime = 0L;
        }
    }
}
