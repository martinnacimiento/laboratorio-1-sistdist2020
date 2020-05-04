package edu.unam.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTCP {
    private int port;
    private boolean off = false;

    public ServerTCP(int port) {
        this.port = port;
    }

    public void listen() throws IOException {
        // Crear ServerSocket en un puerto
        ServerSocket svc = new ServerSocket(this.port);
        for (;;) {
            try {
                // Esperado conecciones
                Socket socket = svc.accept();
                AttentionTask attentionTask = new AttentionTask(socket);
                Thread thread = new Thread(attentionTask);
                thread.start();
                if (this.off) {
                    svc.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void offServer() {
        this.off = true;
    }
}