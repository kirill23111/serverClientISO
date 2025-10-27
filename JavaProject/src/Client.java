import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        String host = "127.0.0.1"; // или "localhost"
        int port = 5050;

        try (Socket socket = new Socket(host, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(
                     new InputStreamReader(socket.getInputStream()))) {

            out.println("Alice"); // отправляем строку серверу
            String response = in.readLine(); // читаем ответ
            System.out.println("Server replied: " + response);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
