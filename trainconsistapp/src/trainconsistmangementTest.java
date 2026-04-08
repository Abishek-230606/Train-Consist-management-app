import java.util.*;
import java.util.stream.*;

public class trainconsistmangementTest {

    static class CargoSafetyException extends RuntimeException {
        CargoSafetyException(String message) {
            super(message);
        }
    }

    static class Bogie {
        String shape;
        String cargo;

        Bogie(String shape) {
            this.shape = shape;
        }

        boolean assignCargo(String cargo) {
            try {
                if (shape.equals("Rectangular") && cargo.equals("Petroleum")) {
                    throw new CargoSafetyException("Unsafe cargo");
                }
                this.cargo = cargo;
                return true;

            } catch (CargoSafetyException e) {
                return false;

            } finally {
                System.out.println("Finally block executed");
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("====== UC-15 TEST CASES ======\n");

        testCargo_SafeAssignment();
        testCargo_UnsafeAssignmentHandled();
        testCargo_CargoNotAssignedAfterFailure();
        testCargo_ProgramContinuesAfterException();
        testCargo_FinallyBlockExecution();
    }

    // 1. Safe assignment
    static void testCargo_SafeAssignment() {
        Bogie b = new Bogie("Cylindrical");

        System.out.println("Safe Assignment: " +
                (b.assignCargo("Petroleum") ? "PASS" : "FAIL"));
    }

    // 2. Unsafe assignment
    static void testCargo_UnsafeAssignmentHandled() {
        Bogie b = new Bogie("Rectangular");

        System.out.println("Unsafe Assignment: " +
                (!b.assignCargo("Petroleum") ? "PASS" : "FAIL"));
    }

    // 3. Cargo not assigned after failure
    static void testCargo_CargoNotAssignedAfterFailure() {
        Bogie b = new Bogie("Rectangular");
        b.assignCargo("Petroleum");

        System.out.println("Cargo Not Assigned: " +
                (b.cargo == null ? "PASS" : "FAIL"));
    }

    // 4. Program continues
    static void testCargo_ProgramContinuesAfterException() {
        Bogie b = new Bogie("Rectangular");

        boolean first = b.assignCargo("Petroleum"); // fail
        boolean second = b.assignCargo("Coal");     // success

        System.out.println("Program Continues: " +
                (!first && second ? "PASS" : "FAIL"));
    }

    // 5. Finally execution (manual observation)
    static void testCargo_FinallyBlockExecution() {
        Bogie b = new Bogie("Rectangular");
        b.assignCargo("Petroleum");

        System.out.println("Finally Executed: CHECK OUTPUT ABOVE");
    }
}