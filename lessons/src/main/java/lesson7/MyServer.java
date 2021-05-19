package lesson7;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * само приложение
 */
public class MyServer {
    private List <ClientHandler> clients;
    private AuthService authService;

    public MyServer() {
        try(ServerSocket server = new ServerSocket(ChatConstants.PORT)) {
            authService = new BaseAuthService();
            authService.start();
            clients = new ArrayList<>();
            while (true) {
                System.out.println("Сервер ожидает подключения");
                Socket socket = server.accept();
                System.out.println("Клиент подключился");
                new ClientHandler(this, socket);

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (authService != null) {
                authService.stop();
            }
        }
    }

    public AuthService getAuthService() {
        return authService;
    }

    public boolean isNickBusy(String nick) {
       for (ClientHandler client : clients){
           if (client.getName().equals(nick)){
               return true;
           }
       }
       return false;
    }

    public void subscribe(ClientHandler clientHandler) {
        clients.add(clientHandler);
    }
    public void unsubscribe(ClientHandler clientHandler) {
        clients.remove(clientHandler);
    }

    // отправляет сообщения всем пользователям
    public void broadcastMessage(String message) throws IOException {
        for (ClientHandler client : clients) {
            client.sendMsg(message);
        }
    }
}
