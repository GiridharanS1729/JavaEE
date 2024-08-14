import java.io.*;
import java.net.*;
import java.util.*;

public class server {
    private static Set<PrintWriter> clientWriters = new HashSet<>();
    private static Set<String> clientNames = new HashSet<>();

    public static void main(String[] args) throws Exception {
        System.out.println("Chat server started...");
        ServerSocket serverSocket = new ServerSocket(54321);

        while (true) {
            new ClientHandler(serverSocket.accept()).start();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter out;
        private String name;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                name = in.readLine();
                if (name != null && !name.isEmpty()) {
                    synchronized (clientNames) {
                        clientNames.add(name);
                    }
                    synchronized (clientWriters) {
                        clientWriters.add(out);
                    }
                    System.out.println(name + " joined");

                    String message;
                    while ((message = in.readLine()) != null) {
                        System.out.println(name+": " + message);
                        synchronized (clientWriters) {
                            for (PrintWriter writer : clientWriters) {
                                writer.println(name + ": " + message);
                            }
                        }
                    }
                }
            } catch (IOException e) {
                System.out.println("Error handling client: " + e);
            } finally {
                if (out != null) {
                    synchronized (clientWriters) {
                        clientWriters.remove(out);
                    }
                }
                if (name != null) {
                    synchronized (clientNames) {
                        clientNames.remove(name);
                    }
                    System.out.println(name + " left");
                }
                try {
                    socket.close();
                } catch (IOException e) {
                    System.out.println("Error closing socket: " + e);
                }
            }
        }
    }
}
