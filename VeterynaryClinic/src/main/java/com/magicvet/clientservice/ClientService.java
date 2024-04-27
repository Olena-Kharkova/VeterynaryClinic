package main.java.com.magicvet.clientservice;

import main.Main;
import main.java.com.magicvet.model.Client;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientService {
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static final String NAME_PATTERN = "[A-Za-z]{3,}";

    public void registerNewClient() {

        System.out.println("Please provide client details.");

        String email;
        do {
            System.out.print("Email: ");
            email = Main.SCANNER.nextLine();
            if (!isEmailValid(email)) {
                System.out.println("Invalid email format. Please enter a valid email address.");
            }
        } while (!isEmailValid(email));

        String firstName;
        do {
            System.out.print("First name: ");
            firstName = Main.SCANNER.nextLine();
            if (!isValidName(firstName)) {
                System.out.println("Invalid name. Your name must contain only letters and be at least 3 characters long.");
            }
        } while (!isValidName(firstName));

        String lastName;
        do {
            System.out.print("Last name: ");
            lastName = Main.SCANNER.nextLine();
            if (!isValidName(lastName)) {
                System.out.println("Invalid name. Your name must contain only letters and be at least 3 characters long.");
            }
        } while (!isValidName(lastName));

        Client client = buildClient(email, firstName, lastName);
        System.out.println("New client: " + client.getFirstName()
                + " " + client.getLastName()
                + " (" + client.getEmail() + ")");
    }

    private static Client buildClient(String email, String firstName, String lastName) {
        Client client = new Client();
        client.setEmail(email);
        client.setFirstName(firstName);
        client.setLastName(lastName);
        return client;
    }

    static boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    static boolean isValidName(String name) {
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
}
