package com.example;

import com.example.services.ClientService;

public class Main {
    public static void main(String[] args) {

       FlywayConfig.migrate();

        ClientService clientService =
                new ClientService();

        long newClientId =
                clientService.create("Netflix");

        System.out.println(
                "Created client ID: " + newClientId
        );

        System.out.println(
                clientService.getById(newClientId)
        );

        clientService.setName(
                newClientId,
                "OpenAI"
        );

        System.out.println(
                clientService.getById(newClientId)
        );

        System.out.println(
                clientService.listAll()
        );

        clientService.deleteById(newClientId);

        System.out.println(
                clientService.listAll()
        );
    }
}