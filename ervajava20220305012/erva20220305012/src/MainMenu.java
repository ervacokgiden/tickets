import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenu extends JFrame {
    private JPanel mainPanel;
    private CardLayout cardLayout;
    private JButton page1Button;
    private JButton page2Button;
    private JButton page3Button;

    public MainMenu() {
        setTitle("Main Menu");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        cardLayout = new CardLayout();
        mainPanel.setLayout(cardLayout);

        JPanel page1 = new JPanel();
        page1.add(new JLabel("Matches Screen"));
        JButton backButton1 = new JButton("previously");
        backButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "menu");
            }
        });
        page1.add(backButton1);

        JPanel menuPanel = new JPanel();
        page1Button = new JButton("Choose Matches");
        page1Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openMatchesPage();
            }
        });
        menuPanel.add(page1Button);

        mainPanel.add(menuPanel, "menu");
        mainPanel.add(page1, "page1");

        cardLayout.show(mainPanel, "menu");

        add(mainPanel);
        setVisible(true);
    }
    private void openMatchesPage() {
        matchesform matches = new matchesform();
        matches.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainMenu::new);
    }
}
