package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private Server server;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private String nickName;

    public ClientHandler(Server server, Socket socket) {

        try {
            this.server = server;
            this.socket = socket;
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            new Thread(() -> {
                try {
                    // цикл аутентифиукаии
                    while (true) {
                        String str = in.readUTF();
                        if (str.startsWith("/auth")) {
                            String[] token = str.split("\\s");
                            String newNick = server.getAuthService()
                                    .getNickByLoginAndPassword(token[1], token[2]);
                            if (newNick != null) {
                                nickName = newNick;
                                sendMsg("/authok " + nickName);
                                server.subscribe(this);
                                System.out.println("Клиент " + nickName + " подключился");
                                break;
                            } else {
                                sendMsg("Неверный логин / пароль");
                            }
                        }
                    }

                    //цикл работы
                    while (true) {
                        String str = in.readUTF();
                        if (str.equals("/end")) {
                            break;
                        }
                        // приватное сообщение
                        else if (str.startsWith("/w")) {
                            String[] privateReceiverAndMsg = str.split("\\s");
                            String receiver = privateReceiverAndMsg[1];
                            String msg = privateReceiverAndMsg[2];
                            server.privateMsg(this, receiver, msg);
                            sendMsg("Private msg to " + receiver + " : " + msg);
                        }
                        else server.broadcastMsg(this, str);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("Клиент " + nickName + " отключился");
                    server.unsubscribe(this);
                    try {
                        socket.close();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    void sendMsg(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getNickName(){
        return nickName;
    }
}

