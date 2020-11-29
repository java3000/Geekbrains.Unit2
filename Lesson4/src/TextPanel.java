import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextPanel {
    private final JPanel panel;
    private final JTextField textField;
    private final JButton sendButton;
    private final ChatPanel chat;


    public TextPanel(ChatPanel chat) {
        panel = new JPanel();
        textField = new JTextField();
        sendButton = new JButton("send");
        this.chat = chat;

        init();
    }

    public JPanel getPanel() {
        return panel;
    }

    private void init() {
        textField.setMinimumSize(new Dimension(50, 30));
        textField.setPreferredSize(new Dimension(600, 30));

        addTextFieldListener();
        addSendButtonListener();

        panel.setLayout(new FlowLayout());
        panel.add(textField);
        panel.add(sendButton);
    }

    private void addTextFieldListener() {
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    chat.getTextArea().append(String.format("\n сообщение: %s \n", textField.getText()));
                    textField.setText("");
                }
            }
        });
    }

    private void addSendButtonListener() {
        sendButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                chat.getTextArea().append(String.format("\n сообщение: %s \n", textField.getText()));
                textField.setText("");
            }
        });
    }
}
