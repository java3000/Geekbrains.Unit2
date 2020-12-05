import javax.swing.*;
import java.awt.*;

public class MenuPanel {

    private final JPanel panel;

    public MenuPanel() {
        this.panel = new JPanel();
        init();
    }

    public JPanel getPanel() {
        return panel;
    }

    private void init() {
        panel.setLayout(new GridLayout(1, 2));
        panel.add(initBarMenu());
    }

    private JMenuBar initBarMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("Меню");
        menuBar.add(fileMenu);

        JMenuItem cut = new JMenuItem("Выход");
        addMenuElementListener(cut);
        fileMenu.add(cut);

        JMenu aboutMenu = new JMenu("О программе");
        menuBar.add(aboutMenu);

        return menuBar;
    }

    private void addMenuElementListener(JMenuItem item) {
        item.addActionListener(e -> System.exit(0));
    }
}
