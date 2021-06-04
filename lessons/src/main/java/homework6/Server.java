package homework6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static DataInputStream inputStream;
    private static DataOutputStream outputStream;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(Constants.PORT)) {
            System.out.println("Server started. Wait for connection...");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");
            inputStream= new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());
            receiveMsg();
            sendMsg();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void receiveMsg() { // от клиента
        new Thread(() -> {
            try {
                while (true) {
                    String strFromClient = inputStream.readUTF();
                    if (strFromClient.equals(Constants.STOP_WORD)){
                        break;
                    }
                    outputStream.writeUTF("Client: " + strFromClient);
                }
                System.out.println("Server shutting down");
            } catch (IOException e) {
                    e.printStackTrace();
                }
        }).start();
    }

    private static void sendMsg() { // клиенту
        new Thread(() -> {
            try {
                while (true) {
                    String strToClient = new String();
                        outputStream.writeUTF(strToClient);
                    }
            } catch (IOException e) {
                    e.printStackTrace();
                }
        }).start();
    }

}



