package Polymorphism;
import java.util.ArrayList;
import java.time.LocalDate;

public class GroveManager {
    public static void main(String[] args) {
        // Create a list to hold all olive tree objects
        ArrayList<OliveTree> myGrove = new ArrayList<>();
        // Add 8 different trees with various planting dates to test logic
        myGrove.add(new OliveTree(1, LocalDate.of(2000, 1, 1), "Koropi", 25.0));
        myGrove.add(new OliveTree(2, LocalDate.of(2015, 5, 10), "Koropi", 25.0));
        myGrove.add(new OliveTree(3, LocalDate.of(2024, 1, 1), "Koropi", 25.0));
        myGrove.add(new OliveTree(4, LocalDate.of(2025, 1, 1), "Koropi", 25.0));
        myGrove.add(new OliveTree(5, LocalDate.of(1950, 5, 20), "Koropi", 25.0));
        myGrove.add(new OliveTree(6, LocalDate.of(2021, 4, 21), "Koropi", 25.0));
        myGrove.add(new OliveTree(7, LocalDate.of(2020, 1, 1), "Koropi", 25.0));
        myGrove.add(new OliveTree(8, LocalDate.of(2027, 12, 25), "Koropi", 25.0));

        System.out.println("Processing Grove Harvest...");

        DatabaseManager myDatabase = new DatabaseManager();

        for (OliveTree tree : myGrove) {
            try {
                double oil = tree.recordHarvest();
                System.out.println("Tree ID " + tree.getId() + " produced: " + oil + " liters.");
                myDatabase.saveTreeToDatabase(tree);
            } catch (LowYieldException e) { // If the harvest fails (yield < 50), catch the error here
                System.out.println("ALERT for Tree ID " + tree.getId() + ": " + e.getMessage());
            }
        }
    }
}
