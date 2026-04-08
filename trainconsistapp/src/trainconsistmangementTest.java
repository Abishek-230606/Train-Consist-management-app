import java.util.*;
import java.util.stream.*;

public class trainconsistmangementTest {

    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    static int calculateTotalSeats(List<Bogie> bogies) {
        return bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);
    }

    public static void main(String[] args) {

        System.out.println("====== UC-10 TEST CASES ======\n");

        testReduce_TotalSeatCalculation();
        testReduce_MultipleBogiesAggregation();
        testReduce_SingleBogieCapacity();
        testReduce_EmptyBogieList();
        testReduce_AllBogiesIncluded();
        testReduce_OriginalListUnchanged();
    }

    // 1. Total calculation
    static void testReduce_TotalSeatCalculation() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("B1", 70),
                new Bogie("B2", 80)
        );

        int result = calculateTotalSeats(bogies);

        System.out.println("Test Total Calculation: " +
                (result == 150 ? "PASS" : "FAIL"));
    }

    // 2. Multiple bogies
    static void testReduce_MultipleBogiesAggregation() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("B1", 30),
                new Bogie("B2", 40),
                new Bogie("B3", 50)
        );

        int result = calculateTotalSeats(bogies);

        System.out.println("Test Multiple Bogies: " +
                (result == 120 ? "PASS" : "FAIL"));
    }

    // 3. Single bogie
    static void testReduce_SingleBogieCapacity() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("B1", 60)
        );

        int result = calculateTotalSeats(bogies);

        System.out.println("Test Single Bogie: " +
                (result == 60 ? "PASS" : "FAIL"));
    }

    // 4. Empty list
    static void testReduce_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();

        int result = calculateTotalSeats(bogies);

        System.out.println("Test Empty List: " +
                (result == 0 ? "PASS" : "FAIL"));
    }

    // 5. All bogies included
    static void testReduce_AllBogiesIncluded() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("B1", 10),
                new Bogie("B2", 20),
                new Bogie("B3", 30)
        );

        int result = calculateTotalSeats(bogies);

        System.out.println("Test All Included: " +
                (result == 60 ? "PASS" : "FAIL"));
    }

    // 6. Original list unchanged
    static void testReduce_OriginalListUnchanged() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("B1", 50));

        int originalSize = bogies.size();

        calculateTotalSeats(bogies);

        System.out.println("Test Original List Unchanged: " +
                (bogies.size() == originalSize ? "PASS" : "FAIL"));
    }
}