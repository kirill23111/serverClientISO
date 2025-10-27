import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        int port = 5050; // можно поменять на любой свободный

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started on port " + port);
            System.out.println("Waiting for connection...");

            Socket clientSocket = serverSocket.accept(); // ждём клиента
            System.out.println("New connection accepted");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String name = in.readLine(); // читаем строку
            System.out.println("Received from client (" + clientSocket.getPort() + "): " + name);

            out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
