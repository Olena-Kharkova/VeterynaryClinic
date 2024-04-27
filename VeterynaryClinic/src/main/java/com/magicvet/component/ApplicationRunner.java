package main.java.com.magicvet.component;

import main.java.com.magicvet.clientservice.ClientService;

public class ApplicationRunner {

    private ClientService clientService = new ClientService();
    public void run() {
        if (Authenticator.auth()) {
            clientService.registerNewClient();
        }
    }
}
