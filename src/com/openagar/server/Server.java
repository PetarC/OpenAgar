package com.openagar.server;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Server {
    public static String NAME = "OpenAgar";
    public static String VERSION = "0.0.1";
    public static String CODENAME = "Morpheus";

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    public static void main(String[] args) {
        /* Show server details */
        System.out.println(Server.getServerDetails());

        /* Start server */
        new ServerLauncher().start();
    }

    public static String getServerDetails() {
        StringBuilder sb = new StringBuilder();

        sb.append("================================================================================\n");
        sb.append(" "+ Server.NAME +" Server\n");
        sb.append(" "+ Server.VERSION +" '"+ Server.CODENAME +"'\n");
        sb.append("================================================================================");

        return sb.toString();
    }

    public static void print(String text) {
        if (text != null) {
            System.out.println("["+ dateFormat.format(new Date()) +"] " + text);
        }
    }
}
