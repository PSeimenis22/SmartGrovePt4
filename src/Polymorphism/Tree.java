package Polymorphism;
import java.time.LocalDate;

public class Tree {
    // Physical Dimensions Attributes.
    protected double height;
    protected double trunkDiameter;
    protected double canopyRadius;
    protected double rootDepth;
    // Biological Identity Attributes.
    protected String species;
    protected String scientificName;
    protected boolean isDeciduous;
    protected int plantYear;
    protected int maxAge;
    // State And Health Attributes.
    protected double healthStatus;
    protected boolean isFlowering;
    protected double foliageDensity;
    protected double waterLevel;
    // Basic Attributes.
    protected int id;
    protected LocalDate plantDate;

    public Tree(int id, LocalDate plantDate, String species, String scientificName) {
        this.id = id; // Storing the tree's unique ID.
        this.plantDate = plantDate; // Storing the permanent plant record/date.
        this.species = species;
        this.scientificName = scientificName;
        this.healthStatus = 1.0; // Default new trees to full health.
    }

    public int getId() {
        return id;
    }

    public LocalDate getPlantDate() {
        return plantDate;
    }


}
