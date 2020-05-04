package edu.unam.app;

import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import org.apache.commons.math3.distribution.ExponentialDistribution;

public class Generador {
    private final double velocidad;

    /**
     * Constructor del generador de logs
     * 
     * @param velocidad velocidad del generador
     */
    public Generador(double velocidad) {
        this.velocidad = velocidad;
    }

    /**
     * Inicia el generador de logs
     * 
     * @throws NoSuchAlgorithmException
     * @throws InterruptedException
     */
    public void iniciar(DataOutputStream outputToServer, String nameNode)
            throws NoSuchAlgorithmException, InterruptedException {
        var cantidad = 0;
        while (cantidad < 10) {
            cantidad++;
            // tiempo
            var tiempo = System.currentTimeMillis();
            // sha 256
            MessageDigest texto = MessageDigest.getInstance("SHA-256");
            // arreglo de 20 bytes
            byte[] arreglo = new byte[20];
            // cargo con valores
            new Random().nextBytes(arreglo);
            // obtengo la cadena de texto del arreglo
            String cadena = new String(arreglo, StandardCharsets.UTF_8);
            // obtengo el hash de la cadena
            byte[] hash = texto.digest(cadena.getBytes(StandardCharsets.UTF_8));
            // tiempo a esperar
            var esperar = valor();
            // imprimo valores (Prueba)
            try {
                outputToServer.writeUTF(tiempo + " " + nameNode + " " + mostrarHexadecimal(hash) + " " + esperar);
            } catch (IOException e) {
                e.printStackTrace();
            }
            // System.err.println(tiempo + " " + mostrarHexadecimal(hash) + " " + esperar);
            Thread.sleep(esperar);
        }
        try {
            outputToServer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Pasa el resultado del hash a hexadecimal
     * 
     * @param hash arreglo de bytes con un valor hash
     * @return String en hexadecimal
     */
    private static String mostrarHexadecimal(byte[] hash) {
        var resultado = new StringBuilder();
        for (int i = 0; i < hash.length; i++) {
            String valor = Integer.toHexString(0xff & hash[i]);
            if (valor.length() == 1) {
                resultado.append('0');
            }
            resultado.append(valor);
        }
        return resultado.toString();
    }

    /**
     * Obtiene un valor basado en una distribución exponencial
     * 
     * @return valor a esperar
     */
    private long valor() {
        var distribucion = new ExponentialDistribution(1 / this.velocidad);
        var ejemplo = distribucion.sample() * 1000;
        return (long) ejemplo;
    }
}