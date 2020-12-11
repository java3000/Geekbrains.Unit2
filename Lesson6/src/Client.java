import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.util.Date;
import java.util.Scanner;

public class Client {
    private final String address;
    private final int port;

    public Client(String address, int port) {
        this.address = address;
        this.port = port;
    }

    public void start() {
        try (Socket socket = new Socket(address, port)) {
            System.out.println("client started on: " + socket);
            doWork(socket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void doWork(Socket socket) {
        new Thread(() -> {
            try (DataInputStream dis = new DataInputStream(socket.getInputStream())) {
                while (true) {
                    System.out.println(new Date() + " Server wrote: " + dis.readUTF());
                }
            } catch (EOFException | SocketException e) {
                System.out.println("Server is unavailable. Connection closed.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        Scanner scanner = new Scanner(System.in);
        try (DataOutputStream dos = new DataOutputStream(socket.getOutputStream())) {
            while (!socket.isClosed()) {
                dos.writeUTF(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}