import java.io.*;
import java.net.*;
import java.util.Scanner;

public class client {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String serverAddress = "localhost";
        Socket socket = new Socket(serverAddress, 54321);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        out.println(name);

        new Thread(new Runnable() {
            public void run() {
                try {
                    while (true) {
                        String message = in.readLine();
                        if (message == null) {
                            break;
                        }
                        System.out.println(message);
                    }
                } catch (IOException e) {
                    System.out.println("Error reading from server: " + e);
                }
            }
        }).start();

        while (true) {
            String message = scanner.nextLine();
            if (message.equalsIgnoreCase("exit")) {
                break;
            }
            out.println(message);
        }

        socket.close();
    }
}
