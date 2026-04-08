import java.util.*;
import java.util.regex.*;

public class trainconsistmangementTest {


    static class Bogie {
        String type;
        String cargo;

        Bogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }
    }

    static boolean checkSafety(List<Bogie> bogies) {
        return bogies.stream()
                .allMatch(b ->
                        !b.type.equals("Cylindrical") ||
                                b.cargo.equals("Petroleum")
                );
    }

    public static void main(String[] args) {

        System.out.println("====== UC-12 TEST CASES ======\n");

        testSafety_AllBogiesValid();
        testSafety_CylindricalWithInvalidCargo();
        testSafety_NonCylindricalBogiesAllowed();
        testSafety_MixedBogiesWithViolation();
        testSafety_EmptyBogieList();
    }

    // 1. All valid
    static void testSafety_AllBogiesValid() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Cylindrical", "Petroleum"),
                new Bogie("Open", "Coal")
        );

        System.out.println("Test All Valid: " +
                (checkSafety(bogies) ? "PASS" : "FAIL"));
    }

    // 2. Cylindrical with wrong cargo
    static void testSafety_CylindricalWithInvalidCargo() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Cylindrical", "Coal")
        );

        System.out.println("Test Cylindrical Wrong Cargo: " +
                (!checkSafety(bogies) ? "PASS" : "FAIL"));
    }

    // 3. Non-cylindrical allowed
    static void testSafety_NonCylindricalBogiesAllowed() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Open", "Coal"),
                new Bogie("Box", "Grain")
        );

        System.out.println("Test Non-Cylindrical: " +
                (checkSafety(bogies) ? "PASS" : "FAIL"));
    }

    // 4. Mixed violation
    static void testSafety_MixedBogiesWithViolation() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Cylindrical", "Petroleum"),
                new Bogie("Cylindrical", "Coal") // invalid
        );

        System.out.println("Test Mixed Violation: " +
                (!checkSafety(bogies) ? "PASS" : "FAIL"));
    }

    // 5. Empty list
    static void testSafety_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();

        System.out.println("Test Empty List: " +
                (checkSafety(bogies) ? "PASS" : "FAIL"));
    }
}