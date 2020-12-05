import javax.swing.*;
import java.awt.*;

public class ChatPanel {
    private JPanel panel;
    private JTextArea text;

    public ChatPanel() {
        init();
    }

    public JPanel getPanel() {
        return panel;
    }

    public JTextArea getTextArea() {
        return text;
    }

    private void init() {
        panel = new JPanel();
        text = new JTextArea();
        panel.setLayout(new BorderLayout());
        panel.add(text, BorderLayout.CENTER);

        //для красоты, чтобы не была совсем прижата к границам, а хоть как-то отделялась от краев окна
        panel.add(new JPanel(), BorderLayout.NORTH);
        panel.add(new JPanel(), BorderLayout.EAST);
        panel.add(new JPanel(), BorderLayout.WEST);
    }
}
