import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;
import org.json.simple.parser.ParseException;





import java.io.IOException;
public class Main {
    private static final String USERS_FILE = "User.json";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        JSONObject userJson = new JSONObject();
        JSONObject agendaJson = new JSONObject();

        String[] accessMenu = {
                "Cosa vuoi fare?",
                "[1] - Accedi",
                "[2] - Registrati"
        };

        String[] principalMenu = {

        };

        // Switch the integer returned by printMenu method
        switch (printMenu(accessMenu)) {
            case 1:
                access(scanner);
                break;
            case 2:
                register(scanner);
                break;
        }


    }

    /**
     * Method to login in the register
     *
     * @param scanner scanner
     */
    private static void access(Scanner scanner) {


        JSONObject usersJson = loadUsers();

        System.out.println("Inserisci il nome utente:\n");
        String username= scanner.next();
        System.out.println("Inserisci la password:\n");
        String password=scanner.next();

        if (usersJson.containsKey(username) && usersJson.get(username).equals(password)) {
            System.out.println("Accesso riuscito!"); // Accesso consentito
        } else {
            System.out.println("Nome utente o password errati. Accesso negato."); // Accesso negato
        }

    }

    /**
     * This method permits the new user to create an account.
     *
     * @param scanner scanner
     */
    private static void register(Scanner scanner) {
        System.out.println("register");
    }

    /**
     * Print the menu and take the choice of the user.
     *
     * @param option The menu is ["title", "firstChoice", ...]
     * @return the number of the choice who user chooses.
     */
    private static int printMenu(String[] option) {
        Scanner scanner = new Scanner(System.in);

        int choiceMenu;

        do {
            for (int i = 0; i < option[0].length(); i++) {
                System.out.print("=");
            }

            System.out.println(); // go on next line

            System.out.println(option[0]); // print the title

            for (int i = 0; i < option[0].length(); i++) {
                System.out.print("=");
            }

            System.out.println(); // go on the next line

            for (int i = 1; i < option.length; i++) {
                System.out.println(option[i]);
            }

            System.out.println("\nInserisci la scelta: ");
            choiceMenu = scanner.nextInt();

            if (choiceMenu < 1 || choiceMenu > option.length - 1) {
                System.out.println("\nScelta errata");
            }
        } while (choiceMenu < 1 || choiceMenu > option.length - 1);

        return choiceMenu;
    }

    private static JSONObject loadUsers() {
        JSONParser jsonParser = new JSONParser(); // Creazione di un oggetto JSONParser per analizzare il file JSON
        JSONObject usersJson = new JSONObject(); // Creazione di un nuovo oggetto JSONObject per memorizzare i dati degli utenti

        try (FileReader reader = new FileReader(USERS_FILE)) { // Apre il file JSON in lettura
            usersJson = (JSONObject) jsonParser.parse(reader); // Parsa il contenuto del file JSON
        } catch (IOException | ParseException e) { // Gestione delle eccezioni
            e.printStackTrace(); // Stampa lo stack trace dell'eccezione
        }

        return usersJson; // Restituisce gli utenti caricati dal file JSON
    }


}

