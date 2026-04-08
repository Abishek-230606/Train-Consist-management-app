/**
 *  ============================================================
 *  * MAIN CLASS - UseCase14CustomException
 *  * ============================================================
 *  *
 *  * Use Case 14: Handle Invalid Bogie Capacity
 *
 * @author Abishek JS
 * @version 14.0
 */

import java.util.*;
import java.util.stream.*;

class InvalidCapacityException extends Exception {
    InvalidCapacityException(String message) {
        super(message);
    }
}


class Bogie {
    String name;
    int capacity;

    // Constructor with validation
    Bogie(String name, int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than zero");
        }
        this.name = name;
        this.capacity = capacity;
    }
}


public class trainconsistmangement  {

    public static void main(String[] args) {

        System.out.println("===== UC14 - Custom Exception =====\n");

        try {
            Bogie b1 = new Bogie("B1", 70);  // valid
            System.out.println("Created: " + b1.name);

            Bogie b2 = new Bogie("B2", -10); // invalid
            System.out.println("Created: " + b2.name);

        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}