
/**
 * Class Name: TrackUniqueBogieIDs
 *
 * Description:
 * This program demonstrates how to track unique bogie IDs
 * using HashSet in Java. It ensures that duplicate bogie IDs
 * are not added to the collection.
 *
 * Use Case:
 * UC3 - Track Unique Bogie IDs
 *
 * Key Concepts:
 * - Set Interface
 * - HashSet Class
 * - Automatic Duplicate Removal
 *
 * Author: Abishek JS
 * Version: 3.0
 */
import java.util.*;
public class TrainConsistManagementApp{
    public static void main(String[] args) {
        System.out.println("===================================");
        System.out.println("UC3 - Track Unique Bogie IDs");
        System.out.println("===================================");
        Set<String> bogies = new HashSet<>();
        bogies.add("BG101");
        bogies.add("BG102");
        bogies.add("BG103");
        bogies.add("BG101");
        bogies.add("BG104");
        bogies.add("BG102");
        System.out.println("\nBogie IDs After Insertion:");
        System.out.println(bogies);
        System.out.println("\nNote:");
        System.out.println("Duplicates are automatically ignored by HashSet.");
        System.out.println("UC3 uniqueness validation completed...");
    }
}
