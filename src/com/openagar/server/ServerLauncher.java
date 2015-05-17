package com.openagar.server;

public class ServerLauncher {
    public void start() {
        try {
            /* TODO: Load GameServer configuration */
            GameServerSettings settings = new GameServerSettings();

            /* Create the GameServer */
            GameServer server = new GameServer(settings);

            /* Start it */
            if (server != null)
                server.start();
        }
        catch (Exception e) {
            Server.print("Exception in ServerLauncher: "+ e.getMessage());
        }
    }
}
