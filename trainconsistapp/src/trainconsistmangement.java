/**
 * ============================================================
 * MAIN CLASS - UseCase12SafetyCheck
 * ============================================================
 *
 * Use Case 12: Safety Compliance Check for Goods Bogies
 *
 * @author Abishek JS
 * @version 12.0
 */

import java.util.*;
import java.util.regex.*;

public class trainconsistmangement  {
    static class Bogie {
        String type;   // Cylindrical, Open, Box
        String cargo;  // Petroleum, Coal, Grain

        Bogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }
    }

    public static void main(String[] args) {

        System.out.println("===== UC12 - Safety Compliance Check =====\n");

        List<Bogie> bogies = Arrays.asList(
                new Bogie("Cylindrical", "Petroleum"),
                new Bogie("Open", "Coal"),
                new Bogie("Box", "Grain")
        );

        // Safety Rule using Stream
        boolean isSafe = bogies.stream()
                .allMatch(b ->
                        !b.type.equals("Cylindrical") ||
                                b.cargo.equals("Petroleum")
                );

        // Output
        System.out.println("Train Safety Status: " +
                (isSafe ? "SAFE ✅" : "UNSAFE ❌"));
    }
}