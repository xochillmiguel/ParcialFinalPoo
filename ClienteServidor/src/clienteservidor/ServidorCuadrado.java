package clienteservidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorCuadrado {
    public static void main(String[] args) {
        try {
            ServerSocket servidor = new ServerSocket(5000);
            System.out.println("Servidor iniciado en el puerto 5000");

            while (true) {
                Socket socketCliente = servidor.accept();
                ManejadorCliente manejador = new ManejadorCliente(socketCliente);
                Thread hilo = new Thread(manejador);
                hilo.start();
            }
        } catch (IOException e) {
            System.out.println("Error en el servidor: " + e.getMessage());
        }
    }
}
