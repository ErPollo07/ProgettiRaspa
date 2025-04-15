package main;

import java.util.ArrayList;

public class Customer {
  private String customerCode;
  private String firstName;
  private String lastName;
  private String email;
  private ArrayList<Aquarium> aquariums;
  private ArrayList<Sale> sales;
  private boolean isPremium;

  public Customer(String customerCode, String firstName, String lastName, String email) {
    this.customerCode = customerCode;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.aquariums = new ArrayList<>();
    this.sales = new ArrayList<>();
  }

  public void addAquarium(Aquarium a) {
    aquariums.add(a);
  }

  public void addSale(Sale s) {
    sales.add(s);
  }

  public void checkOut(Sale sale) {
    for (Animal animal : sale.getAnimals()) {
      Aquarium bestFit = null;

      // Trova l'acquario compatibile
      for (Aquarium a : aquariums) {
        if (a.addAnimal(animal)) {
          bestFit = a;
          break;
        }
      }

      // Se nessun acquario è adatto, creane uno nuovo
      if (bestFit == null) {
        bestFit = new Aquarium(animal.getType()); // Crea nuovo acquario con il tipo d'acqua dell'animale
        bestFit.addAnimal(animal);                      // Aggiungi l'animale
        addAquarium(bestFit);                           // Aggiungi l'acquario al cliente
      }
    }
  }

  // =====================
  // ==       GET       ==
  // =====================

  public String getCustomerCode() {
    return customerCode;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getEmail() {
    return email;
  }

  public ArrayList<Aquarium> getAquariums() {
    return aquariums;
  }

  public ArrayList<Sale> getSales() {
    return sales;
  }

  public boolean isPremium() {
    return isPremium;
  }


}
