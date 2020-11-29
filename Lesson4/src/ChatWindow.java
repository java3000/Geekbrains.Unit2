import javax.swing.*;
import java.awt.*;

public class ChatWindow extends JFrame {

    public ChatWindow() {
        setTitle("чЯтег");
        setBounds(new Rectangle(50, 50, 700, 600));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        ChatPanel chatPanel = new ChatPanel();
        JPanel menu = new MenuPanel().getPanel();
        JPanel chat = chatPanel.getPanel();
        JPanel text = new TextPanel(chatPanel).getPanel();

        add(menu, BorderLayout.NORTH);
        add(chat, BorderLayout.CENTER);
        add(text, BorderLayout.SOUTH);

        setVisible(true);
    }
}
