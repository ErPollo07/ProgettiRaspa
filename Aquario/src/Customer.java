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
