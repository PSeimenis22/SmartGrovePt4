package Polymorphism;

import java.time.LocalDate;
import java.time.Month;

public class OliveTree extends Tree implements Harvestable {
    private String oliveType;
    private double oilContent = 0.25;
    private double yieldAmount = 300.0;
    private boolean isAlternateBearing = true;

    public OliveTree(int id, LocalDate plantDate, String oliveType, double oilContent) {
        // Sends info to the parent tree class
        super(id, plantDate, "Olive Tree", "Olea europaea");
        this.oliveType = oliveType;
        this.oilContent = oilContent;
        // Gets the specific year from the plant date to calculate age later
        this.plantYear = plantDate.getYear();
        this.isAlternateBearing = true;

    }
    // Handles the harvest and checks for errors
    public double recordHarvest() throws LowYieldException {
        double result = harvestFruit();

        if (result < 50.0) {
            throw new LowYieldException("Warning: Yield is too low (" + result + " liters). Check soil moisture!");
        }
        return result;
    }
    // Overrides the Harvestable interface to provide rules for the harvest
    @Override
    public double harvestFruit() {
        double product = 0.0;
        int currentYear = LocalDate.now().getYear();
        int treeAge = currentYear - this.plantYear;
        Month month = LocalDate.now().getMonth();
        // I used november to may as harvest months
        boolean isHarvestSeason = (month == Month.NOVEMBER || month == Month.DECEMBER ||
                month == Month.JANUARY || month == Month.FEBRUARY ||
                month == Month.MARCH) || month ==Month.APRIL || month ==Month.MAY;
        // Tree must be older than 5 years and it must be the right season
        if (treeAge > 5 && isHarvestSeason) {
            product = calculateOilYield();
        }
        return product;
    }
    // Returns the total weight (kg) of olives
    @Override
    public double collectYield() {
        return this.yieldAmount;
    }
    // Method to calculate oil liters
    public double calculateOilYield() {
        return collectYield() * 0.25;
    }
    // Method to finish the harvest and reset the tree's cycle
    public double harvestOlives() {
        this.isAlternateBearing = !this.isAlternateBearing;
        return collectYield();
    }
    public int getPlantYear() {
        return this.plantYear;
    }

    public String getOliveType() {
        return this.oliveType;
    }

    public double getOilContent() {
        return this.oilContent;
    }

    public boolean isAlternateBearing() {
        return this.isAlternateBearing;
    }
}
