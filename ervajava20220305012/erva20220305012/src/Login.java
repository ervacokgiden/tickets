import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Book;

public class Login extends JFrame {

    private JTextField textField1;
    private JTextField passwordField;
    private JButton loginButton;
    private JPanel panel1;

    public Login() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1280, 720);

        panel1 = new JPanel();
        textField1 = new JTextField(15);
        passwordField = new JPasswordField(15);
        JLabel usernameLabel = new JLabel("User:");
        JLabel passwordLabel = new JLabel("Password:");
        loginButton = new JButton("Login");

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String userName = textField1.getText();
                String password = passwordField.getText();
                if (userName.equalsIgnoreCase("user1") && password.equals("123")) {
                    JOptionPane.showMessageDialog(Login.this, "Login successful");
                    openMatchesPage();
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(Login.this, "Incorrect entry");
                }
            }
        });

        panel1.add(usernameLabel);
        panel1.add(textField1);
        panel1.add(passwordLabel);
        panel1.add(passwordField);
        panel1.add(loginButton);
        add(panel1);
    }

    private void openMatchesPage() {
        MainMenu books = new MainMenu();
        books.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
}
