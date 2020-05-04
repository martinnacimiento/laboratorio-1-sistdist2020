package edu.unam.server;

import java.io.IOException;

public class App {
    public static void main(String[] args) {
        ServerTCP server = new ServerTCP(8000);
        System.out.println("servidor 8000");
        try {
            server.listen();
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}
