package edu.unam.server;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class AttentionTask implements Runnable {
    private final Socket socket;
    private String nameNode;

    public AttentionTask(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Obtener input y output stream del req
            DataInputStream inputFromClient = new DataInputStream(this.socket.getInputStream());

            this.nameNode = inputFromClient.readUTF();
            System.out.println(System.currentTimeMillis() + " - " + this.nameNode + " - conectado");
            for (;;) {
                String data = inputFromClient.readUTF();
                if (data == null) {
                    break;
                }
                System.out.println(data);
            }
            inputFromClient.close();
            this.socket.close();
        } catch (IOException e) {
            System.out.println(System.currentTimeMillis() + " - " + this.nameNode + " - desconectado");
        }
    }

}