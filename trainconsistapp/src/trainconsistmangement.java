/**
 * ============================================================
 * MAIN CLASS - UseCase9TrainConsistMgmt
 * ============================================================
 *
 * Use Case 9: Group Bogies by Type using Collectors.groupingBy
 *
 * Description:
 * This class groups bogies based on their type (category)
 * such as Sleeper, AC, General using Stream API.
 *
 * At this stage, the application:
 * - Creates a list of bogies
 * - Uses groupingBy() to categorize bogies
 * - Displays grouped result
 *
 * @author Abishek JS
 * @version 9.0
 */

import java.util.*;
import java.util.stream.*;

public class trainconsistmangement  {

    // Bogie class
    static class Bogie {
        String name;
        String type;
        int capacity;

        Bogie(String name, String type, int capacity) {
            this.name = name;
            this.type = type;
            this.capacity = capacity;
        }
    }

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println(" UC9 - Group Bogies by Type ");
        System.out.println("========================================\n");

        // Create list of bogies
        List<Bogie> bogies = Arrays.asList(
                new Bogie("B1", "Sleeper", 72),
                new Bogie("B2", "AC", 50),
                new Bogie("B3", "Sleeper", 72),
                new Bogie("B4", "General", 90),
                new Bogie("B5", "AC", 50)
        );

        // Grouping using Stream API
        Map<String, List<Bogie>> groupedBogies = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.type));

        // Display grouped result
        for (String type : groupedBogies.keySet()) {
            System.out.println("Type: " + type);

            for (Bogie b : groupedBogies.get(type)) {
                System.out.println("  " + b.name + " - " + b.capacity);
            }
            System.out.println();
        }
    }
}