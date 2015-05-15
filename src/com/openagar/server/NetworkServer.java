package com.openagar.server;

import java.util.ArrayList;
import java.util.List;

public class NetworkServer {
    private List<GameServer> serverList = new ArrayList<>();

    public void createGameServer(String name, int port) {
        try {
            GameServer server = new GameServer(name, port);

            if (server != null) {
                server.start();
                serverList.add(server);
            }
        }
        catch (Exception e) {
            Server.print("Exception in NetworkServer: "+ e.getMessage());
        }
    }

    public void start() {
        /* TODO: Load GameServer list from a configuration file */

        /* Create a single default GameServer */
        createGameServer("Default", 13405);
    }
}
