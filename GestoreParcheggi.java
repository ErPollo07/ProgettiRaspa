import java.util.ArrayList;

public class GestoreParcheggi {
    private Car[] parkIndoor;
    private ArrayList<Car> parkOutdoor;

    public GestoreParcheggi() {
        this.parkIndoor = new Car[3];
        this.parkOutdoor = new ArrayList<>();
    }

    public void add(Car car) {
        if (car.isGPL() && !car.isVip()) {
            parkOutdoor.add(car);
            return;
        }

        if (car.isVip()) {
            if (parkIndoorIsFull()) {
                for (int i = 0; i < parkIndoor.length; i++) {
                    if (!parkIndoor[0].isVip()) {
                        swap(car, i);
                        return;
                    }
                }
            }

            for (int i = 0; i < parkIndoor.length; i++) {
                if (parkIndoor[i] != null) {
                    parkIndoor[i] = car;
                    break;
                }
            }
        }
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

    }

    public void swap(Car c, int index) {
        Car temp = parkIndoor[index];
        parkIndoor[index] = c;
        parkOutdoor.add(temp);
    }

    public Car[] getParkIndoor() {
        return parkIndoor;
    }

    public ArrayList<Car> getParkOutdoor() {
        return parkOutdoor;
    }
}
