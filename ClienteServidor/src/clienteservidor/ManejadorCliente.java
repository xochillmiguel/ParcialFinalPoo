package clienteservidor;

import java.io.*;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ManejadorCliente implements Runnable {
    private Socket socket;

    public ManejadorCliente(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);

            String nombre = entrada.readLine();
            int numero = Integer.parseInt(entrada.readLine());

            System.out.println("Cliente " + nombre + " conectado");

            int cuadrado = numero * numero;
            String fechaHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            salida.println("¡Bienvenido, " + nombre + "!");
            salida.println("El cuadrado de tu número es: " + cuadrado);
            salida.println("Fecha y hora actual: " + fechaHora);

            System.out.println("Cliente " + nombre + " desconectado");

            socket.close();
        } catch (IOException e) {
            System.out.println("Error con cliente: " + e.getMessage());
        }
    }
}
