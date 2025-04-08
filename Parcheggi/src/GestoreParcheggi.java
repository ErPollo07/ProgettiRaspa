import java.util.ArrayList;

public class GestoreParcheggi {
  private Car[] parkIndoor;
  private ArrayList<Car> parkOutdoor;

  public GestoreParcheggi() {
    this.parkIndoor = new Car[3];
    this.parkOutdoor = new ArrayList<>();
  }

  public void add(Car car) {
    // All the car with gpl must be put in parkOutdoor
    if (car.isGPL()) {
      parkOutdoor.add(car);
      return;
    }

    // if car is vip
    // it has options
    if (car.isVip()) {
      // if the parkIndoor is full
      if (!parkIndoorIsFull()) {
        addParkIn(car);
        return;
      }

      // if the method canSwap identifies a car that is not a vip or have less
      // power of the current car
      if (canSwap(car)) {
        // then the program swap the car
        swap(car);
      } else {
        // else the program puts the car in the parkoutdoor
        parkOutdoor.add(car);
      }
      // if the car is not a vip car
    } else {
      // if the parkIndoor is full put the car in the outdoor park
      if (parkIndoorIsFull()) {
        parkOutdoor.add(car);
        // if the parkIn is not full then put it in the park in
      } else {
        addParkIn(car);
      }
    }

    sort();
  }

  public void addParkIn(Car c) {
    for (int i = 0; i < parkIndoor.length; i++) {
      if (parkIndoor[i] == null) {
        parkIndoor[i] = c;
        break;
      }
    }
  }

  public boolean canSwap(Car c) {
    if (!c.isVip()) return false; // solo le VIP possono swappare

    for (Car parked : parkIndoor) {
      if (parked == null) break;

      // posso swappare se la nuova macchina è "migliore"
      if (c.compareTo(parked) > 0) return true;
    }

    return false;
  }

  public boolean parkIndoorIsFull() {
    for (Car car : parkIndoor) {
      if (car == null) {
        return false;
      }
    }

    return true;
  }

  public void sort() {
    int max;

    for (int i = 0; i <= getLastIndexPI(); i++) {
      max = i;

      // trova il massimo invece del minimo
      for (int j = i + 1; j <= getLastIndexPI(); j++) {
        if (parkIndoor[j].compareTo(parkIndoor[max]) > 0) {
          max = j;
        }
      }

      Car temp = parkIndoor[i];
      parkIndoor[i] = parkIndoor[max];
      parkIndoor[max] = temp;
    }
  }

  public int getLastIndexPI() {
    for (int i = 0; i < parkIndoor.length; i++) {
      if (parkIndoor[i] == null) {
        return i - 1;
      }
    }

    return parkIndoor.length - 1;
  }

  public void swap(Car c) {
    for (int i = 0; i < parkIndoor.length; i++) {
      if (c.compareTo(parkIndoor[i]) > 0) {
        Car removed = parkIndoor[i];
        parkIndoor[i] = c;
        parkOutdoor.add(removed);
        return;
      }
    }
  }
  public Car[] getParkIndoor() { return parkIndoor; }

  public ArrayList<Car> getParkOutdoor() { return parkOutdoor; }
}
