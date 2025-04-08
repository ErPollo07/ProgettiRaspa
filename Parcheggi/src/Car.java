public class Car implements Comparable<Car> {
  private double power;
  private double cost;
  private boolean isGPL;
  private boolean isVip;

  public Car(double power, double cost, boolean isGPL, boolean isVip) {
    this.power = power;
    this.cost = cost;
    this.isGPL = isGPL;
    this.isVip = isVip;
  }

  public double getkilowatt() {
    return power * 0.735499;
  }

  public double getPower() {
    return power;
  }

  public double getCost() {
    return cost;
  }

  public boolean isGPL() {
    return isGPL;
  }

  public boolean isVip() {
    return isVip;
  }

  @Override
  public int compareTo(Car o) {
    if (this.isVip && !o.isVip()) return 1;
    if (!this.isVip && o.isVip()) return -1;

    return Double.compare(this.power, o.getPower());
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Car c) {
      return power == c.power;
    }

    return false;
  }

  @Override
  public String toString() {
    return String.format("Car { Power: %.2f, Cost: %.2f, IsVip: %s, IsGpl: %s", power, cost, isVip, isGPL);
  }
}
