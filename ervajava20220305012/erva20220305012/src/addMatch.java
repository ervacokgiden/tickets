import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class addMatch{

    static final String conUrl = "jdbc:mysql://localhost:3306/tickets";
    static final String user = "user1";
    static final String pass = "123";

    public static void main(String[] args) {
        JFrame frame = new JFrame("Add Match");
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JTextField textField1 = new JTextField(10);
        JTextField textField2 = new JTextField(20);
        JTextField textField3 = new JTextField(20);
        JTextField textField4 = new JTextField(20);
        JTextField textField5 = new JTextField(20);
        JTextField textField6 = new JTextField(10);
        JTextField textField7 = new JTextField(10);
        JButton addButton = new JButton("Add Match");


        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addMatch(textField1.getText(), textField2.getText(), textField3.getText(), textField4.getText(), textField5.getText(), textField6.getText(),textField7.getText());
            }
        });


        frame.add(new JLabel("Match ID:"));
        frame.add(textField1);
        frame.add(new JLabel("Match Name:"));
        frame.add(textField2);
        frame.add(new JLabel("Match Date:"));
        frame.add(textField3);
        frame.add(new JLabel("Home Team:"));
        frame.add(textField4);
        frame.add(new JLabel("Away Team:"));
        frame.add(textField5);
        frame.add(new JLabel("Stadium:"));
        frame.add(textField6);
        frame.add(new JLabel("Ticket Packages:"));
        frame.add(textField7);
        frame.add(addButton);


        frame.setVisible(true);
    }

    public static void addMatch(String matchid, String matchname, String matchdate, String hometeam, String awayteam, String stadium, String ticketpackages) {
        try (Connection conn = DriverManager.getConnection(conUrl, user, pass)) {
            String cmd = "INSERT INTO matches (match_id, match_name, match_date, home_team, away_team, stadium, ticket_packages) " + "VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement statement = conn.prepareStatement(cmd);
            statement.setString(1, matchid);
            statement.setString(2, matchname);
            statement.setString(3, matchdate);
            statement.setString(4, hometeam);
            statement.setString(5, awayteam);
            statement.setString(6, stadium);
            statement.setString(7, ticketpackages);

            int affectedRows = statement.executeUpdate();
            if (affectedRows > 0) {
                JOptionPane.showMessageDialog(null, "Match information saved.");
            } else {
                JOptionPane.showMessageDialog(null, "Match information error.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data error: " + ex.getMessage());
        }
    }

    public void setVisible(boolean b) {
    }
}
