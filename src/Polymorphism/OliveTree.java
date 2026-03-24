package Polymorphism;

import java.time.LocalDate;
import java.time.Month;

// This subclass is specialized for olive production and separates it from general greenery.
public class OliveTree extends Tree implements Harvestable {
    public OliveTree(int id, LocalDate plantDate, String species, String scientificName) {
        super(id, plantDate, species, scientificName);
        this.plantYear = 2000; // 1st requirement: set plantYear to 2000
    }

    @Override
    public double collectYield() {
        return 300.0; // 2nd requirement: 300kgr collected
    }

    @Override
    public double harvestFruit() {
        double product = 0.0; // 3rd requirement: return a double named product
        int currentYear = LocalDate.now().getYear();
        int treeAge = currentYear - this.plantYear;
        Month month = LocalDate.now().getMonth();
        // 4th requirement: Age > 5 and the season must be november, december, january, february or march
        boolean isHarvestSeason = (month == Month.NOVEMBER || month == Month.DECEMBER || month == Month.JANUARY || month == Month.FEBRUARY || month == Month.MARCH);

        if (treeAge > 5 && isHarvestSeason) {
            double kgr = collectYield();
            double oilContent = 0.25; // 5th requirement: 25% oil content
            product = kgr * oilContent; // Calculates the product double

        }
        return product;
    }

}
