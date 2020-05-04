package edu.unam.app;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientTCP {
    private String host;
    private int port;
    private Socket socket;
    private DataOutputStream alServidor;

    public ClientTCP(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void connectToServer(String nameNode) {
        // Crear socket y conectar al servidor
        Socket socket;
        try {
            socket = new Socket(this.host, this.port);
            this.socket = socket;
            this.alServidor = new DataOutputStream(this.socket.getOutputStream());
            this.alServidor.writeUTF(nameNode);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public DataOutputStream getOutputStreamOfSocket() {
        return this.alServidor;
    }

    public void closeSocket() {
        try {
            this.socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}