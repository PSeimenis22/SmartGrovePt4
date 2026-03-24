package Polymorphism;

import java.time.LocalDate;

public class OliveGrove {
    public static void main(String[] args) {
        OliveTree myTree = new OliveTree(1, LocalDate.of(2000, 1, 1), "Olive Tree", "Olea europaea");
        // created the olive tree planted in 2000
        double oilAmount = myTree.harvestFruit();
        System.out.println("The calculated oil amount is: " + oilAmount + " liters.");
    }
}
