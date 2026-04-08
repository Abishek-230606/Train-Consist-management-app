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

    // Filter method
    static List<Bogie> filterBogies(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        System.out.println("====== UC-8 TEST CASES ======\n");

        testFilter_CapacityGreaterThanThreshold();
        testFilter_CapacityEqualToThreshold();
        testFilter_CapacityLessThanThreshold();
        testFilter_MultipleBogiesMatching();
        testFilter_NoBogiesMatching();
        testFilter_AllBogiesMatching();
        testFilter_EmptyBogieList();
        testFilter_OriginalListUnchanged();
    }

    // 1. Greater than threshold
    static void testFilter_CapacityGreaterThanThreshold() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("B1", 60),
                new Bogie("B2", 80)
        );

        List<Bogie> result = filterBogies(bogies, 70);

        System.out.println("Test Greater Than Threshold: " +
                (result.size() == 1 && result.get(0).name.equals("B2") ? "PASS" : "FAIL"));
    }

    // 2. Equal to threshold
    static void testFilter_CapacityEqualToThreshold() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("B1", 70)
        );

        List<Bogie> result = filterBogies(bogies, 70);

        System.out.println("Test Equal To Threshold: " +
                (result.isEmpty() ? "PASS" : "FAIL"));
    }

    // 3. Less than threshold
    static void testFilter_CapacityLessThanThreshold() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("B1", 50)
        );

        List<Bogie> result = filterBogies(bogies, 70);

        System.out.println("Test Less Than Threshold: " +
                (result.isEmpty() ? "PASS" : "FAIL"));
    }

    // 4. Multiple matching
    static void testFilter_MultipleBogiesMatching() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("B1", 80),
                new Bogie("B2", 90)
        );

        List<Bogie> result = filterBogies(bogies, 70);

        System.out.println("Test Multiple Matching: " +
                (result.size() == 2 ? "PASS" : "FAIL"));
    }

    // 5. No matching
    static void testFilter_NoBogiesMatching() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("B1", 40),
                new Bogie("B2", 50)
        );

        List<Bogie> result = filterBogies(bogies, 70);

        System.out.println("Test No Matching: " +
                (result.isEmpty() ? "PASS" : "FAIL"));
    }

    // 6. All matching
    static void testFilter_AllBogiesMatching() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("B1", 80),
                new Bogie("B2", 90)
        );

        List<Bogie> result = filterBogies(bogies, 70);

        System.out.println("Test All Matching: " +
                (result.size() == bogies.size() ? "PASS" : "FAIL"));
    }

    // 7. Empty list
    static void testFilter_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();

        List<Bogie> result = filterBogies(bogies, 70);

        System.out.println("Test Empty List: " +
                (result.isEmpty() ? "PASS" : "FAIL"));
    }

    // 8. Original list unchanged
    static void testFilter_OriginalListUnchanged() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("B1", 80));

        int originalSize = bogies.size();

        filterBogies(bogies, 70);

        System.out.println("Test Original List Unchanged: " +
                (bogies.size() == originalSize ? "PASS" : "FAIL"));
    }
}