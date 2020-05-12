package edu.unam.server;

import java.io.IOException;

public class App {
    public static void main(String[] args) {
        int port = Integer.parseInt(args[0]);
        ServerTCP server = new ServerTCP(port);
        System.out.println("servidor " + port);
        try {
            server.listen();
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}
