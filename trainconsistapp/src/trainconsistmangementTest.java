import java.util.*;
import java.util.regex.*;

public class trainconsistmangementTest {

    public static void main(String[] args) {

        System.out.println("===== UC11 - Regex Validation =====\n");

        // Sample Inputs
        String trainId = "TRN-1234";
        String cargoCode = "PET-AB";

        // Regex Patterns
        String trainPattern = "TRN-\\d{4}";
        String cargoPattern = "PET-[A-Z]{2}";

        // Compile patterns
        Pattern p1 = Pattern.compile(trainPattern);
        Pattern p2 = Pattern.compile(cargoPattern);

        // Match input
        Matcher m1 = p1.matcher(trainId);
        Matcher m2 = p2.matcher(cargoCode);

        // Validate
        boolean isTrainValid = m1.matches();
        boolean isCargoValid = m2.matches();

        // Output
        System.out.println("Train ID: " + trainId + " -> " + (isTrainValid ? "Valid" : "Invalid"));
        System.out.println("Cargo Code: " + cargoCode + " -> " + (isCargoValid ? "Valid" : "Invalid"));
    }
}