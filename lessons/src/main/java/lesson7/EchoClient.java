package lesson7;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import lesson6.EchoConstants;

public class EchoClient extends JFrame {

    private Socket socket;

    private JTextArea chatArea;
    private JTextField inputField;

    private DataInputStream inputStream;
    private DataOutputStream outputStream;

    public EchoClient() {
        try {
            openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        initGUI();
    }

    private void openConnection() throws IOException {
        this.socket = new Socket(EchoConstants.HOST, EchoConstants.PORT);
        this.inputStream = new DataInputStream(socket.getInputStream());
        this.outputStream = new DataOutputStream(socket.getOutputStream());

        new Thread(() -> {
            try {
                //auth
                while (true) {
                    String strFromServer = inputStream.readUTF();
                    if (strFromServer.equals(ChatConstants.AUTH_OK)) {
                        break;
                    }
                    chatArea.append(strFromServer);
                    chatArea.append("\n");
                }
                //read
                while (true) {
                    String strFromServer = inputStream.readUTF();
                    if (strFromServer.equals(EchoConstants.STOP_WORD)) {
                        break;
                    }
                    chatArea.append(strFromServer);
                    chatArea.append("\n");
                    }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }).start();
    }

    private void shutDown() {
        chatArea.append("Соединения завершается");
        try {
            Thread.sleep(ChatConstants.SLEEP);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        closeConnection();
        setVisible(false);
    }


    public void closeConnection() {
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initGUI() {
        setBounds(600, 300, 500, 500);
        setTitle("Клиент");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Message area
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        add(new JScrollPane(chatArea), BorderLayout.CENTER);

        //down panel
        JPanel panel = new JPanel(new BorderLayout());
        inputField = new JTextField();
        panel.add(inputField, BorderLayout.CENTER);

        JButton sendButton = new JButton("Send");
        panel.add(sendButton, BorderLayout.EAST);

        add(panel, BorderLayout.SOUTH);

        sendButton.addActionListener(e -> sendMessage());
        inputField.addActionListener(e -> sendMessage());

        //close window
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                    try {
                        outputStream.writeUTF(EchoConstants.STOP_WORD);
                        closeConnection();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
        });
        setVisible(true);

    }

    private void sendMessage() {
        if (!inputField.getText().trim().isEmpty()) {
            try {
                outputStream.writeUTF(inputField.getText());
                inputField.setText("");
                inputField.grabFocus();
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Send error occured");
            }
        }
    }


    public static void main(String[] args) {

        SwingUtilities.invokeLater(EchoClient::new);

    }

}