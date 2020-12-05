import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class Server {
    private final int port;

    public Server(int port) {
        this.port = port;
    }

    public void start() {
        try (ServerSocket socket = new ServerSocket(port)) {
            System.out.println("server started on: " + socket);
            try(Socket clientSocket = socket.accept()) {
                listen(clientSocket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listen(Socket clientSocket) {
        new Thread(() -> {
            try (DataInputStream dis = new DataInputStream(clientSocket.getInputStream())) {
                while (true) {
                    System.out.println(new Date() + " Client wrote: " + dis.readUTF());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        Scanner scanner = new Scanner(System.in);
        try (DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream())) {
            while (!clientSocket.isClosed()) {
                dos.writeUTF(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
