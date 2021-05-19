package lesson7;

/**
 * сервис авторизации
 */
public interface AuthService {
    // запустить сервис
    void start();
    // остановить сервис
    void stop();
    // получить никнейм
    String getNickByLoginAndPass(String login, String pass );

}
