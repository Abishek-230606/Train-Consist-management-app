/**
 *  ============================================================
 *  * MAIN CLASS - UseCase13PerformanceComparison
 *  * ============================================================
 *  *
 *  * Use Case 13: Compare Loop vs Stream Performance
 *
 * @author Abishek JS
 * @version 13.0
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

        System.out.println("===== UC13 - Performance Comparison =====\n");

        // Create large dataset
        List<Bogie> bogies = new ArrayList<>();
        for (int i = 1; i <= 10000; i++) {
            bogies.add(new Bogie("B" + i, i % 100)); // varying capacity
        }

        // -------- LOOP APPROACH --------
        long startLoop = System.nanoTime();

        List<Bogie> loopResult = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > 60) {
                loopResult.add(b);
            }
        }

        long endLoop = System.nanoTime();
        long loopTime = endLoop - startLoop;

        // -------- STREAM APPROACH --------
        long startStream = System.nanoTime();

        List<Bogie> streamResult = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        long endStream = System.nanoTime();
        long streamTime = endStream - startStream;

        // Output
        System.out.println("Loop Time (ns): " + loopTime);
        System.out.println("Stream Time (ns): " + streamTime);
        System.out.println("Results Equal Size: " +
                (loopResult.size() == streamResult.size()));
    }
}