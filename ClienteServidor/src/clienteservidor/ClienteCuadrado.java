package clienteservidor;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClienteCuadrado {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5000);

            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);

            System.out.print("Ingresa tu nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingresa un número entero: ");
            int numero = scanner.nextInt();

            salida.println(nombre);
            salida.println(numero);

            String respuesta1 = entrada.readLine();
            String respuesta2 = entrada.readLine();
            String respuesta3 = entrada.readLine();

            System.out.println(respuesta1);
            System.out.println(respuesta2);
            System.out.println(respuesta3);

            socket.close();
        } catch (IOException e) {
            System.out.println("Error en el cliente: " + e.getMessage());
        }
    }
}
