import java.util.ArrayList;

public class Aquarium {
    private String code;
    private double volume;
    private WaterType type;
    private ArrayList<Animal> animals;

    public Aquarium(String code, double volume, WaterType type) {
        this.code = code;
        this.volume = volume;
        this.type = type;
        this.animals = new ArrayList<>();
    }

    public String getCode() { return code; }
    public double getVolume() { return volume; }
    public WaterType getType() { return type; }
    public ArrayList<Animal> getAnimals() { return animals; }

    public boolean checkCompatibility(Animal a) {
        for (Animal existing : animals) {
            if (!existing.isCompatible() || !a.isCompatible()) return false;
        }
        return true;
    }

    public boolean addAnimal(Animal a) {
        if (checkCompatibility(a)) {
            animals.add(a);
            return true;
        }
        return false;
    }
}
