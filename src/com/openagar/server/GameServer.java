package com.openagar.server;

import java.net.ServerSocket;
import java.util.HashSet;
import java.util.Set;

public class GameServer {
    private static final int BACKLOG = 256;

    private Set<NetworkPlayer> playerList = new HashSet<>();
    private ServerSocket serverSocket;
    private LoginServer loginServer;
    private GameServerSettings settings;

    public GameServer(GameServerSettings settings) throws IllegalArgumentException {
        if (settings == null)
            throw new IllegalArgumentException("Invalid GameServer settings");

        this.settings = settings;

        try {
            serverSocket = new ServerSocket(settings.getPort());
            loginServer = new LoginServer(this);
        }
        catch (Exception e) {
            Server.print("Could not start GameServer on port " + settings.getPort());
        }
    }

    public void add(NetworkPlayer player) {
        playerList.add(player);
        Server.print("GameServer "+ settings.getName() +" has now "+ playerList.size() +" clients");
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public String getName() {
        return settings.getName();
    }

    public void start() {
        if (serverSocket == null || loginServer == null)
            return;

        Server.print("GameServer "+ settings.getName() +" started on port " + serverSocket.getLocalPort());
        loginServer.start();
    }

    public void stop() {
        loginServer.stop();
        Server.print("GameServer "+ settings.getName() +" has stopped");
    }
}
