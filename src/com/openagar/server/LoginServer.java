package com.openagar.server;

import java.net.ServerSocket;
import java.net.Socket;

public class LoginServer implements Runnable {
    private GameServer gameServer;
    private ServerSocket serverSocket;
    private boolean running = false;

    public LoginServer(GameServer gameServer) {
        if (gameServer == null)
            throw new IllegalArgumentException("Illegal GameServer gameServer");

        this.gameServer = gameServer;
        this.serverSocket = gameServer.getServerSocket();

        try {
            gameServer.getServerSocket().setSoTimeout(3);
        }
        catch (Exception e) {
            Server.print("LoginServer: Could not set timeout for GameServer "+ gameServer.getName());
        }
    }

    public void listenForClient() {
        try {
            Socket socket = serverSocket.accept();

            if (socket != null) {
                Server.print("LoginServer: Connection from "+ socket.getLocalAddress().getHostAddress());
                gameServer.add(new NetworkPlayer(socket));
            }
        }
        catch (Exception e) {
            /* TODO: Handle exception in LoginServer@listenForClient */
        }
    }

    public synchronized void start() {
        running = true;
        new Thread(this).run();
    }

    public synchronized void stop() {
        running = false;
    }

    @Override
    public void run() {
        Server.print("Listening for clients for GameServer "+ this.gameServer.getName());

        while (running) {
            try {
                this.listenForClient();
                Thread.sleep(250);
            } catch (Exception e) {
                /* TODO: Handle exception in LoginServer@run */
            }
        }
    }
}
