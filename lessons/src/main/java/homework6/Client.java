package homework6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client  {

    private static Socket socket;
    private static DataInputStream inputStream;
    private static DataOutputStream outputStream;

    public static void main(String[] args) {
        try {
            socket = new Socket(Constants.HOST, Constants.PORT);
            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());
            receivedMsg();
            sentMsg();
        } catch ( IOException e) {
            e.printStackTrace();
        }
    }

    private static void receivedMsg() { // от сервера
        new Thread(() -> {
            try {
                while (true) {
                    String strFromServer = inputStream.readUTF();
                    if (strFromServer.equals(Constants.STOP_WORD)) {
                        break;
                    }
                    outputStream.writeUTF("Server: " + strFromServer);
                }
            } catch (IOException e) {
                    e.printStackTrace();
                }
        }).start();
    }

    private static void sentMsg() { // серверу
        new Thread(() -> {
            try {
                while (true) {
                    String strToServer = new String();
                        outputStream.writeUTF(strToServer);
                    }
            } catch (IOException e) {
                    e.printStackTrace();
            }
        }).start();
    }

}
