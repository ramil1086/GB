package server;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static int PORT = 8189;
    ServerSocket server = null;
    Socket socket = null;
    private DataInputStream in;
    private DataOutputStream out;
    private boolean isServerOn = true;

    public Server() {
        try {
            server = new ServerSocket(PORT);
            System.out.println("Сервер запущен");
            socket = server.accept();
            System.out.println("Клиент подключился");
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            new Thread(() -> {
                try {
                    while (true) {
                        String str = in.readUTF();
                        if (str.equals("/end")) {
                            break;
                        }
                        System.out.println("Клиент : " + str);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("Клиент отключился");
                    try {
                        isServerOn = false;
                        socket.close();
                        server.close();
                        System.exit(0);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }).start();


            new Thread(() -> {
                BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
                try {
                    while (isServerOn) {
                        out.writeUTF(consoleReader.readLine());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        consoleReader.close();
                        isServerOn = false;
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
