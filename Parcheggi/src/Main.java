import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String[] menu = {
            "GESTORE PARCHEGGI",
            "Inserisci macchina",
            "Visualizza pacheggi",
            "Esci",
    };

    GestoreParcheggi gestore = new GestoreParcheggi();

    double power, cost;
    boolean isGpl, isVip;
    String _is;

    gestore.add(new Car(120, 15000, false, false)); // Indoor (non gpl, non vip)
    gestore.add(new Car(140, 18000, false, true));  // Indoor (vip)
    gestore.add(new Car(160, 22000, false, true));  // Indoor (vip, ma forse swap se meglio)
    gestore.add(new Car(90, 10000, true, false));   // Outdoor (gpl)
    gestore.add(new Car(110, 12000, true, true));   // Outdoor (gpl)
    gestore.add(new Car(200, 30000, false, true));  // Potrebbe far swap se più potente

    while (true) {
      switch (Tools.menu(menu, scanner)) {
        case 1 -> {
          System.out.println("inserisci la potenza in cavalli");
          power = Double.parseDouble(scanner.nextLine());

          System.out.println("inserisci il costo della macchina");
          cost = Double.parseDouble(scanner.nextLine());

          System.out.println("E' a gpl (y/n)");
          _is = scanner.nextLine();
          isGpl = _is.equalsIgnoreCase("y");

          System.out.println("E' un vip (y/n)");
          _is = scanner.nextLine();
          isVip = _is.equalsIgnoreCase("y");

          gestore.add(new Car(power, cost, isGpl, isVip));
        }
        case 2 -> {
          System.out.println("Parcheggio coperto: ");

          for (int i = 0; i < gestore.getParkIndoor().length; i++) {
            // stop printing when the cycle finds a position set to null
            if (gestore.getParkIndoor()[i] == null) {
              break;
            }

            System.out.println(gestore.getParkIndoor()[i]);
          }

          System.out.println("Parcheggio scoperto:");
          gestore.getParkOutdoor().forEach(System.out::println);
        }
        default -> {
          break;
        }
      }
    }
  }
}
