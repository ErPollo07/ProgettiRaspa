package main;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // Create customer
    Customer nicola = new Customer("001", "Nicola", "Student", "nicola@example.com");

    // Create animals
    Animal fish1 = new Animal("Goldfish", WaterType.FRESHWATER, Behavior.PEACEFUL, 5, 10.0, true);
    Animal fish2 = new Animal("Tetra", WaterType.FRESHWATER, Behavior.PEACEFUL, 3, 8.0, true);
    Animal fish3 = new Animal("Angelfish", WaterType.FRESHWATER, Behavior.PEACEFUL, 6, 12.0, true);
    Animal fish4 = new Animal("Piranha", WaterType.FRESHWATER, Behavior.AGGRESSIVE, 8, 20.0, true);
    Animal fish5 = new Animal("Clownfish", WaterType.SALTWATER, Behavior.PEACEFUL, 4, 11.0, true);

    // Create sale
    Sale sale = new Sale(nicola, LocalDate.now());

    sale.addAnimal(fish1);
    sale.addAnimal(fish2);
    sale.addAnimal(fish3);
    sale.addAnimal(fish4);
    sale.addAnimal(fish5); // Fail

    // Test check out
    nicola.checkOut(sale);

    // Print results
    System.out.println("Numero acquari dopo il checkout: " + nicola.getAquariums().size());

    for (Aquarium a : nicola.getAquariums()) {
      System.out.println("Acquario (" + a.getType() + "): " + a.getAnimals().size() + " animali");
      for (Animal an : a.getAnimals()) {
        System.out.println("- " + an.getSpecies() + " (" + an.getBehavior() + ")");
      }
    }
  }
}
