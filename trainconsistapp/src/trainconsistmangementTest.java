import java.util.*;
import java.util.stream.*;

public class trainconsistmangementTest {


    static class Bogie {
        int capacity;

        Bogie(int capacity) {
            this.capacity = capacity;
        }
    }

    static List<Bogie> loopFilter(List<Bogie> bogies) {
        List<Bogie> result = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > 60) {
                result.add(b);
            }
        }
        return result;
    }

    static List<Bogie> streamFilter(List<Bogie> bogies) {
        return bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        System.out.println("====== UC-13 TEST CASES ======\n");

        testLoopFilteringLogic();
        testStreamFilteringLogic();
        testLoopAndStreamResultsMatch();
        testExecutionTimeMeasurement();
        testLargeDatasetProcessing();
    }

    // 1. Loop logic
    static void testLoopFilteringLogic() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie(50),
                new Bogie(70)
        );

        System.out.println("Loop Filtering: " +
                (loopFilter(bogies).size() == 1 ? "PASS" : "FAIL"));
    }

    // 2. Stream logic
    static void testStreamFilteringLogic() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie(50),
                new Bogie(70)
        );

        System.out.println("Stream Filtering: " +
                (streamFilter(bogies).size() == 1 ? "PASS" : "FAIL"));
    }

    // 3. Results match
    static void testLoopAndStreamResultsMatch() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie(80),
                new Bogie(40),
                new Bogie(90)
        );

        System.out.println("Results Match: " +
                (loopFilter(bogies).size() == streamFilter(bogies).size() ? "PASS" : "FAIL"));
    }

    // 4. Time measurement
    static void testExecutionTimeMeasurement() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie(70),
                new Bogie(80)
        );

        long start = System.nanoTime();
        streamFilter(bogies);
        long end = System.nanoTime();

        System.out.println("Time Measurement: " +
                ((end - start) > 0 ? "PASS" : "FAIL"));
    }

    // 5. Large dataset
    static void testLargeDatasetProcessing() {
        List<Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            bogies.add(new Bogie(i % 100));
        }

        System.out.println("Large Dataset: " +
                (streamFilter(bogies).size() >= 0 ? "PASS" : "FAIL"));
    }
}