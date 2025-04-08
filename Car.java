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
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Car c) {
            return power == c.power;
        }

        return false;
    }
}
