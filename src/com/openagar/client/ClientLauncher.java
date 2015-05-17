package com.openagar.client;

public class ClientLauncher {
    public void start() {
        try {
            new GameWindow().run();
        }
        catch (Exception e) {
            System.out.println("Exception in ClientLauncher: "+ e.getMessage());
        }
    }
}
