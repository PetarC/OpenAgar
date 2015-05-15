package com.openagar.server;

import java.net.Socket;

public class NetworkPlayer {
    private Socket player;

    public NetworkPlayer(Socket player) {
        if (player == null)
            throw new IllegalArgumentException("Invalid Socket player");

        this.player = player;
    }
}
