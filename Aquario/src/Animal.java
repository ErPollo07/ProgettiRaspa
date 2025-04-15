public class Animal {
    private String species;
    private WaterType type;
    private Behavior behavior;
    private double size;
    private double price;
    private boolean isCompatible;

    public Animal(String species, WaterType type, Behavior behavior, double size, double price, boolean isCompatible) {
        this.species = species;
        this.type = type;
        this.behavior = behavior;
        this.size = size;
        this.price = price;
        this.isCompatible = isCompatible;
    }

    public String getSpecies() { return species; }
    public WaterType getType() { return type; }
    public Behavior getBehavior() { return behavior; }
    public double getSize() { return size; }
    public double getPrice() { return price; }
    public boolean isCompatible() { return isCompatible; }
}
