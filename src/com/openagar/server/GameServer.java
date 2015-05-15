package com.openagar.server;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.util.HashSet;
import java.util.Set;

public class GameServer {
    private static final int BACKLOG = 256;

    private Set<NetworkPlayer> playerList = new HashSet<>();
    private ServerSocket serverSocket;
    private LoginServer loginServer;
    private String name;

    public GameServer(String name, int port) throws IllegalArgumentException {
        if (name == null)
            throw new IllegalArgumentException("Invalid GameServer name");
        if (port <= 0)
            throw new IllegalArgumentException("Invalid GameServer port");

        this.name = name;

        try {
            serverSocket = new ServerSocket(port);
            loginServer = new LoginServer(this);
        }
        catch (Exception e) {
            Server.print("Could not start GameServer on port " + port);
        }
    }

    public void add(NetworkPlayer player) {
        playerList.add(player);
        Server.print("GameServer "+ name +" has now "+ playerList.size() +" clients");
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public String getName() {
        return name;
    }

    public void start() {
        if (serverSocket == null || loginServer == null)
            return;

        Server.print("GameServer "+ name +" started on port " + serverSocket.getLocalPort());
        loginServer.start();
    }

    public void stop() {
        loginServer.stop();
        Server.print("GameServer "+ name +" has stopped");
    }
}
