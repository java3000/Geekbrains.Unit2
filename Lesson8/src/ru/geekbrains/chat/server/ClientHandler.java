package ru.geekbrains.chat.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Date;

public class ClientHandler {
    private String name;
    private DataInputStream in;
    private DataOutputStream out;
    private Socket socket;
    private Chat chat;
    private boolean isLoggedIn;

    public ClientHandler(Socket socket, Chat chat) {
        this.socket = socket;
        this.chat = chat;
        this.isLoggedIn = false;
        try {
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (Exception e) {
            throw new RuntimeException("SWW", e);
        }

        listen();
    }

    public String getName() {
        return name;
    }

    private void listen() {
        new Thread(() -> {
            //ну, чтоб лишнее не делать.
            if (!isLoggedIn) doAuth();
            receiveMessage();
        }).start();
    }

    private void doAuth() {
        sendMessage("Please enter credentials. Sample [-auth login password] \n " +
                "or you will be disconnected after 120 seconds");
        try {
            /**", de
             * -auth login password
             * sample: -auth l1 p1
             */
            int delta = 120 * 1000;
            long inactivityTimer = System.currentTimeMillis();

            while (true) {
                String mayBeCredentials = in.readUTF();
                if (mayBeCredentials.startsWith("-auth")) {
                    String[] credentials = mayBeCredentials.split("\\s");
                    String mayBeNickname = chat.getAuthenticationService()
                            .findNicknameByLoginAndPassword(credentials[1], credentials[2]);
                    if (mayBeNickname != null) {
                        if (!chat.isNicknameOccupied(mayBeNickname)) {
                            sendMessage("[INFO] Auth OK");
                            name = mayBeNickname;

                            chat.broadcastMessage(String.format("[%s] logged in", name));
                            chat.subscribe(this);
                            isLoggedIn = true;

                            return;
                        } else {
                            sendMessage("[INFO] Current user is already logged in.");
                        }
                    } else {
                        sendMessage("[INFO] Wrong login or password.");
                    }
                }

                if (!isLoggedIn && System.currentTimeMillis() >= (inactivityTimer + delta)) {
                    sendMessage("you was disconnected due to unauthorized activity");
                    in.close();
                    out.close();
                    socket.close();
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("SWW", e);
        }
    }

    public void sendMessage(String message) {
        try {
            if (!socket.isClosed()) {
                out.writeUTF(message);
            }
        } catch (IOException e) {
            throw new RuntimeException("SWW", e);
        }
    }

    public void receiveMessage() {
        while (true) {
            try {
                if (!socket.isClosed()) {
                    String message = in.readUTF();
                    if (message.startsWith("-exit")) {
                        chat.unsubscribe(this);
                        chat.broadcastMessage(String.format("[%s] logged out", name));
                        break;
                    }
                    chat.broadcastMessage(String.format("[%s]: %s", name, message));
                }
            } catch (IOException e) {
                throw new RuntimeException("SWW", e);
            }
        }
    }
}
