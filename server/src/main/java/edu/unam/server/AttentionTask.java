package edu.unam.server;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class AttentionTask implements Runnable {
    private final Socket socket;
    private String nameNode;
    private long connectedAt;
    private Log logger;

    public AttentionTask(Socket socket, long connectedAt, Log logger) {
        this.socket = socket;
        this.connectedAt = connectedAt;
        this.logger = logger;
    }

    @Override
    public void run() {
        try {
            // Obtener input y output stream del req
            DataInputStream inputFromClient = new DataInputStream(this.socket.getInputStream());

            this.nameNode = inputFromClient.readUTF();
            System.out.println(this.connectedAt + " - " + this.nameNode + " - conectado");
            for (;;) {
                String json = inputFromClient.readUTF();
                long timeArrival = System.currentTimeMillis();
                if (json == null) {
                    break;
                }
                Event event = Event.fromJson(json);
                event.setTimeDelay(timeArrival);
                event.setBandwidth(json.length());
                System.out.println(event.getTime() + " " + this.nameNode + " " + event.getHash());
                this.logger.pushEvent(event);
            }
            inputFromClient.close();
            this.socket.close();
        } catch (IOException e) {
            System.out.println(System.currentTimeMillis() + " - " + this.nameNode + " - desconectado");
        }
    }

}