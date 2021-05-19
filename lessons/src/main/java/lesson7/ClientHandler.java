package lesson7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * обслуживает клиента,  отвечает за связь между клиентом и сервером
 */
public class ClientHandler {
    private MyServer server;
    private Socket socket;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;

    private String name;

    public String getName() {
        return name;
    }

    public ClientHandler(MyServer server, Socket socket) {
        try {
            this.server = server;
            this.socket = socket;
            this.inputStream = new DataInputStream(socket.getInputStream());
            this.outputStream = new DataOutputStream(socket.getOutputStream());
            this.name = "";
            new Thread(() -> {
                try {
                    authentification();//авторизация как в чатике
                    readMessages();//чтение сообзений
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        closeConnection();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } catch (IOException e) {
            System.out.println("Проблема при создании клинета.");
        }


    }

    private void authentification() throws IOException {
        // auth login pass
        while (true){
            String message = inputStream.readUTF();
            if (message.startsWith(ChatConstants.AUTH_COMMAND)) {
                String[] parts = message.split("\\s+"); // разбиваеь строчку по пробелам
                String nick = server.getAuthService().getNickByLoginAndPass(parts[1], parts[2]);
                if (nick != null) {
                    if (!server.isNickBusy(nick)){ //проверим, что такого нет
                        sendMsg(ChatConstants.AUTH_OK + " " + nick);
                        name = nick;
                        server.subscribe(this);
                        server.broadcastMessage(name + " вошел в чат");
                        return;
                    } else {
                        sendMsg("Логин уже испульзуется");
                    }

                } else {
                    sendMsg("Неверные логин/пароль");

                 }
            }
        }
    }

    public void sendMsg(String message) throws IOException {
        try {
            outputStream.writeUTF(message);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readMessages() throws IOException {
        while (true) {
            String messageFromClient = inputStream.readUTF();
            System.out.println("от " + name + ": " + messageFromClient);
            if (messageFromClient.equals(ChatConstants.STOP_WORD)) {
                return;
            }
            server.broadcastMessage(name + ": " + messageFromClient); // распространить сообщение всем клиентам

        }
    }

    public void closeConnection() throws IOException {
        server.subscribe(this);
        server.broadcastMessage(name + " вышел из чата");
        try {
            inputStream.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        try {
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try{
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
