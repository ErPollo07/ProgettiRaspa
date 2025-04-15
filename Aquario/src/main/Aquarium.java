package main;

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

  public Aquarium(WaterType type) {
    this.type = type;
  }

  /**
   * This method check if peaceful animal are more than 75%.
   *
   * @param a animal that needs to be added
   * @return true if the animal can be added
   */
  public boolean checkCompatibility(Animal a) {
    ArrayList<Animal> controlList = (ArrayList<Animal>) this.animals.clone();

    int peacefulCount = (int) controlList.stream().map(animal -> animal.getBehavior().equals(Behavior.PEACEFUL)).count();

    return ((double) peacefulCount / animals.size()) <= 0.75;
  }

  public boolean addAnimal(Animal a) {
    if (checkCompatibility(a)) {
      return animals.add(a);
    }

    return false;
  }

  public String getCode() { return code; }
  public double getVolume() { return volume; }
  public WaterType getType() { return type; }
  public ArrayList<Animal> getAnimals() { return animals; }


}
