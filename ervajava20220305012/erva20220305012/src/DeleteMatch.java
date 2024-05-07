import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class DeleteMatch {

    static final String conUrl = "jdbc:mysql://localhost:3306/tickets";
    static final String user = "user1";
    static final String pass = "123";

    public static void main(String[] args) {

        JFrame frame = new JFrame("Delete Match:");
        frame.setSize(400, 200);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JTextField textField = new JTextField(20);
        JButton deleteButton = new JButton("Delete Match");

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String match_name = textField.getText();
                if (!match_name.isEmpty()) {
                    DeleteMatch(match_name);
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter matches name:");
                }
            }
        });


        frame.add(new JLabel("Match to be delated:"));
        frame.add(textField);
        frame.add(deleteButton);


        frame.setVisible(true);
    }

    public static void DeleteMatch(String match_name) {
        try (Connection conn = DriverManager.getConnection(conUrl, user, pass)) {
            String cmd = "DELETE FROM matches WHERE match_name = ?";

            PreparedStatement statement = conn.prepareStatement(cmd);
            statement.setString(1, match_name);

            int affectedRows = statement.executeUpdate();
            if (affectedRows > 0) {
                JOptionPane.showMessageDialog(null, match_name + " Match deleted successful.");
            } else {
                JOptionPane.showMessageDialog(null, match_name + " Match is not found.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "data error: " + ex.getMessage());
        }
    }
}
