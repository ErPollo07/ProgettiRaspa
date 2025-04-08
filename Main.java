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

        while (true) {
            switch (Tools.menu(menu, scanner)) {
                case 1 -> {
                    System.out.println("inserisci la potenza in cavalli");
                    power = Double.parseDouble(scanner.nextLine());

                    System.out.println("inserisci il costo della macchina");
                    cost = Double.parseDouble(scanner.nextLine());

                    System.out.println("E' a gpl (t/f)");
                    _is = scanner.nextLine();
                    isGpl = _is.equals("t");

                    System.out.println("E' un vip (t/f)");
                    _is = scanner.nextLine();
                    isVip = _is.equals("t");


                }
                case 2 -> {

                }
                default -> {
                    break;
                }
            }
        }

    }
}
