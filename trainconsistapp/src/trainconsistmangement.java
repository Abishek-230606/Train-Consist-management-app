/**
 *  ============================================================
 *  * MAIN CLASS - UseCase10TrainConsistMgmt
 *  * ============================================================
 *  *
 *  * Use Case 10: Count Total Seats using reduce()
 *
 * @author Abishek JS
 * @version 9.0
 */

import java.util.*;
import java.util.stream.*;

public class trainconsistmangement  {

    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    public static void main(String[] args) {

        System.out.println("===== UC10 - Total Seating Capacity =====\n");

        List<Bogie> bogies = Arrays.asList(
                new Bogie("B1", 72),
                new Bogie("B2", 50),
                new Bogie("B3", 80)
        );

        // Stream + map + reduce
        int totalSeats = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        System.out.println("Total Seating Capacity: " + totalSeats);
    }
}