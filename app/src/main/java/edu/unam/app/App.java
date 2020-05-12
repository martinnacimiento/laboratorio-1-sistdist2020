package edu.unam.app;

import java.io.DataOutputStream;
import java.security.NoSuchAlgorithmException;

public class App {
    public static void main(String[] args) {
        // TODO: Validaciones
        String nameNode = args[0];
        float speedEvent = Float.parseFloat(args[1]);
        String hostNameServer = args[2];
        int portServer = Integer.parseInt(args[3]);

        System.out.println("nodo " + nameNode + " " + speedEvent + " " + hostNameServer + " " + portServer);

        ClientTCP client = new ClientTCP(hostNameServer, portServer);
        client.connectToServer(nameNode);
        DataOutputStream outputToServer = client.getDataOutputStream();
        Generador generador = new Generador(speedEvent);
        try {
            generador.iniciar(outputToServer, nameNode);
        } catch (NoSuchAlgorithmException | InterruptedException e) {
            System.err.println("Error!!");
        }
    }
}
