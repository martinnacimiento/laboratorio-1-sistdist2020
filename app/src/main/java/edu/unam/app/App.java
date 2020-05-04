package edu.unam.app;

import java.io.DataOutputStream;
import java.security.NoSuchAlgorithmException;

public class App {
    public static void main(String[] args) {
        String nameNode = args[0];
        float speed = Float.parseFloat(args[1]);
        String host = args[2];
        String port = args[3];

        System.out.println("nodo " + nameNode + " " + speed + " " + host + " " + port);
        var velocidad = speed;

        ClientTCP client = new ClientTCP("localhost", 8000);
        client.connectToServer(nameNode);
        DataOutputStream outputToServer = client.getOutputStreamOfSocket();
        Generador generador = new Generador(velocidad);
        try {
            generador.iniciar(outputToServer, nameNode);
        } catch (NoSuchAlgorithmException | InterruptedException e) {
            System.err.println("Error!!");
        }
    }
}
