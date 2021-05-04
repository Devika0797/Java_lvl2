package lesson4;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame {
    public App() {
        setTitle("My window");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 400);
        setLayout(null);

        JTextArea textArea = new JTextArea();
        textArea.setBounds(20,20,300,75);
        add(textArea);

        JButton button = new JButton("Button 1");
        button.setBounds(100, 100, 100, 20);
        add(button);

        StringBuilder sb = new StringBuilder();
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sb.append("Text").append("\n");
               textArea.setText(sb.toString());
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new App();
    }
}
