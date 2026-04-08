/**
 *   ============================================================
 *  * MAIN CLASS - UseCase15SafeCargoAssignment
 *  * ============================================================
 *  *
 *  * Use Case 15: Safe Cargo Assignment using try-catch-finally
 *
 * @author Abishek JS
 * @version 15.0
 */

import java.util.*;
import java.util.stream.*;

class CargoSafetyException extends RuntimeException {
    CargoSafetyException(String message) {
        super(message);
    }
}

// Bogie class
class Bogie {
    String shape;  // Cylindrical, Rectangular
    String cargo;

    Bogie(String shape) {
        this.shape = shape;
    }

    // Assign cargo with safety check
    void assignCargo(String cargo) {
        try {
            // Rule: Rectangular cannot carry Petroleum
            if (shape.equals("Rectangular") && cargo.equals("Petroleum")) {
                throw new CargoSafetyException("Unsafe cargo assignment!");
            }

            this.cargo = cargo;
            System.out.println("Cargo assigned successfully: " + cargo);

        } catch (CargoSafetyException e) {
            System.out.println("Error: " + e.getMessage());

        } finally {
            System.out.println("Assignment attempt completed.\n");
        }
    }
}

public class trainconsistmangement {

    public static void main(String[] args) {

        System.out.println("===== UC15 - Safe Cargo Assignment =====\n");

        Bogie b1 = new Bogie("Cylindrical");
        Bogie b2 = new Bogie("Rectangular");

        // Safe assignment
        b1.assignCargo("Petroleum");

        // Unsafe assignment
        b2.assignCargo("Petroleum");

        // Program continues
        b2.assignCargo("Coal");
    }
}