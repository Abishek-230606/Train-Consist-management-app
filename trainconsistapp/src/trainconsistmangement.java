/**
 * ============================================================
 * MAIN CLASS - UseCase8TrainConsistMgmt
 * ============================================================
 *
 * Use Case 8: Filter Passenger Bogies Using Streams
 *
 * Description:
 * This class filters passenger bogies based on seating
 * capacity using Java Stream API.
 *
 * At this stage, the application:
 * - Creates a list of bogies
 * - Converts list into stream
 * - Applies filter condition
 * - Collects filtered result
 * - Displays qualifying bogies
 *
 * This maps functional filtering using Streams.
 *
 * @author Abishek JS
 * @version 8.0
 */

import java.util.*;
import java.util.stream.*;

public class trainconsistmangement {

    // Reusing Bogie model
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println(" UC8 - Filter Passenger Bogies Using Streams ");
        System.out.println("========================================\n");

        // Create list of passenger bogies
        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("B1", 40));
        bogies.add(new Bogie("B2", 60));
        bogies.add(new Bogie("B3", 30));
        bogies.add(new Bogie("B4", 80));

        // Apply filtering using Stream API
        List<Bogie> filteredBogies = bogies.stream()
                .filter(b -> b.capacity >= 50)
                .collect(Collectors.toList());

        // Display filtered bogies
        System.out.println("Filtered Bogies (Capacity >= 50):");

        for (Bogie b : filteredBogies) {
            System.out.println(b.name + " - " + b.capacity);
        }
    }
}