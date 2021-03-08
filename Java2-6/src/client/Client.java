package client;

import java.io.*;
import java.net.Socket;

public class Client {
    private final String IP_ADDRESS = "localhost";
    private final int PORT = 8189;
    private Socket socket;
    DataInputStream in;
    DataOutputStream out;
    private boolean isClientOn = true;

    public Client () {
        try {
            socket = new Socket(IP_ADDRESS, PORT);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            new Thread(()-> {
                    try {
                        while (isClientOn) {
                            System.out.println("Сервер : " +  in.readUTF());
                        }
                    } catch (IOException e) {
                    } finally {
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
            }).start();


            new Thread(()-> {
                try {
                    BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
                    while (true) {
                        String str = consoleReader.readLine();
                        out.writeUTF(str);
                        if (str.equals("/end")) {
                            isClientOn = false;
                            consoleReader.close();
                            break;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {

                    System.out.println("Мы отключились от сервера");

                    try {
                        socket.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
