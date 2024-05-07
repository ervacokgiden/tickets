import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class reservationsform extends JFrame{
    private JScrollBar scrollBar1;
    private JTable table1;
    private JPanel JPanel1;
    reservations_dal rdal;
    private ArrayList<reservations> rlist;
    private DefaultTableModel tblModel;
    private final String TableColName[] =
            { "reservation_id", "user_id", "match_id", "ticket_package", "quantity" , "total_price" , "reservation_date","status"  };

    public reservationsform()
    {
        setContentPane(JPanel1);
        setTitle("My GUI Form"); // optional
        setMinimumSize(new Dimension(400,300) ); // optional
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        rdal = new reservations_dal();
        rlist = rdal.Getreservations();

        tblModel = (DefaultTableModel) table1.getModel();
        tblModel.setColumnIdentifiers(TableColName);

        UpdateTable();
    }
    private void UpdateTable()
    {
        // clear table rows
        while (tblModel.getRowCount()>0)
            tblModel.removeRow(0);
        // fill the table
        for (reservations k: rlist) {
            String data[] = {String.valueOf(k.reservationId), String.valueOf( k.userId), String.valueOf(k.matchId),k.ticketPackage, String.valueOf(k.quantity), String.valueOf(k.totalPrice),String.valueOf(k.reservationDate),k.Status};
            tblModel.addRow(data);
        }
    }
    public static void main(String[] args) {
        new reservationsform();
    }
}
