package main;

import java.time.LocalDate;
import java.util.ArrayList;

public class Sale {
  private Customer customer;
  private LocalDate date;
  private ArrayList<Animal> animals;

  public Sale(Customer customer, LocalDate date) {
    this.customer = customer;
    this.date = date;
    this.animals = new ArrayList<>();
  }

  public Customer getCustomer() { return customer; }
  public LocalDate getDate() { return date; }
  public ArrayList<Animal> getAnimals() { return animals; }

  public boolean addAnimal(Animal a) {
    // count the number of aggressive and peaceful animal in the order with the new animal
    int aggressive = (int) animals.stream().map(animal -> animal.getBehavior().equals(Behavior.AGGRESSIVE)).count();
    int peaceful = (int) animals.stream().map(animal -> animal.getBehavior().equals(Behavior.PEACEFUL)).count();

    // list full
    if (aggressive == Settings.MAX_AGGRESSIVE_IN_SALE && peaceful == Settings.MAX_PEACEFUL_IN_SALE) {
      return false;
    }

    if (checkCount(a)) {
      animals.add(a);
      return true;
    }

    return false;
  }

  public boolean checkCount(Animal a) {
    ArrayList<Animal> controlList = (ArrayList<Animal>) this.animals.clone();

    controlList.add(a);

    // count the number of aggressive and peaceful animal in the order with the new animal
    int aggressive = (int) controlList.stream().map(animal -> animal.getBehavior().equals(Behavior.AGGRESSIVE)).count();
    int peaceful = (int) controlList.stream().map(animal -> animal.getBehavior().equals(Behavior.PEACEFUL)).count();

    // if the number of aggressive and peaceful animal are correct than the animal can be added
    if (aggressive <= Settings.MAX_AGGRESSIVE_IN_SALE && peaceful <= Settings.MAX_PEACEFUL_IN_SALE) {
      return true;
    }

    return false;
  }

  public void checkOut(ArrayList<Aquarium> list) {
    // implement checkout logic here
  }
}
