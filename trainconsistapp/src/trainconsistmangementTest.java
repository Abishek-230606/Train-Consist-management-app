import java.util.*;
import java.util.stream.*;

public class trainconsistmangementTest {

    static class InvalidCapacityException extends Exception {
        InvalidCapacityException(String message) {
            super(message);
        }
    }

    static class Bogie {
        int capacity;

        Bogie(int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
            this.capacity = capacity;
        }
    }

    public static void main(String[] args) {

        System.out.println("====== UC-14 TEST CASES ======\n");

        testException_ValidCapacityCreation();
        testException_NegativeCapacityThrowsException();
        testException_ZeroCapacityThrowsException();
        testException_ExceptionMessageValidation();
        testException_ObjectIntegrityAfterCreation();
        testException_MultipleValidBogiesCreation();
    }

    // 1. Valid capacity
    static void testException_ValidCapacityCreation() {
        try {
            Bogie b = new Bogie(50);
            System.out.println("Valid Capacity: PASS");
        } catch (Exception e) {
            System.out.println("Valid Capacity: FAIL");
        }
    }

    // 2. Negative capacity
    static void testException_NegativeCapacityThrowsException() {
        try {
            new Bogie(-10);
            System.out.println("Negative Capacity: FAIL");
        } catch (InvalidCapacityException e) {
            System.out.println("Negative Capacity: PASS");
        }
    }

    // 3. Zero capacity
    static void testException_ZeroCapacityThrowsException() {
        try {
            new Bogie(0);
            System.out.println("Zero Capacity: FAIL");
        } catch (InvalidCapacityException e) {
            System.out.println("Zero Capacity: PASS");
        }
    }

    // 4. Exception message
    static void testException_ExceptionMessageValidation() {
        try {
            new Bogie(-5);
        } catch (InvalidCapacityException e) {
            System.out.println("Exception Message: " +
                    (e.getMessage().equals("Capacity must be greater than zero") ? "PASS" : "FAIL"));
        }
    }

    // 5. Object integrity
    static void testException_ObjectIntegrityAfterCreation() {
        try {
            Bogie b = new Bogie(100);
            System.out.println("Object Integrity: " +
                    (b.capacity == 100 ? "PASS" : "FAIL"));
        } catch (Exception e) {
            System.out.println("Object Integrity: FAIL");
        }
    }

    // 6. Multiple valid bogies
    static void testException_MultipleValidBogiesCreation() {
        try {
            Bogie b1 = new Bogie(50);
            Bogie b2 = new Bogie(60);
            System.out.println("Multiple Bogies: PASS");
        } catch (Exception e) {
            System.out.println("Multiple Bogies: FAIL");
        }
    }
}