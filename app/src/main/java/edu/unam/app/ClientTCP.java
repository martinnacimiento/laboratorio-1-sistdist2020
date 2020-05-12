package edu.unam.app;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientTCP {
    private String host;
    private int port;
    private Socket socket;
    private DataOutputStream toServer;

    public ClientTCP(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void connectToServer(String nameNode) {
        try {
            this.socket = new Socket(this.host, this.port);
            this.toServer = new DataOutputStream(this.socket.getOutputStream());
            this.toServer.writeUTF(nameNode);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public DataOutputStream getDataOutputStream() {
        return this.toServer;
    }

    public void closeSocket() {
        try {
            this.socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}