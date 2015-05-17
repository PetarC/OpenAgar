package com.openagar.server;

public class GameServerSettings {
    private int port;
    private String name;

    public GameServerSettings() {
        this.port = 13205;
        this.name = Server.NAME + " Default";
    }

    public int getPort() {
        return port;
    }

    public String getName() {
        return name;
    }
}
