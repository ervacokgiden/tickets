import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class matchesform  extends  JFrame
{
    private JTable table1;
    private JPanel JPanel1;
    private JScrollBar scrollBar1;

    matches_dal mdal;
    private ArrayList<matches> mlist;
    private DefaultTableModel tblModel;
    private final String TableColName[] =
            { "Id", "Name", "Price", "Details", "Details" , "stadium" , "Details"  };


    public matchesform()
    {
        setContentPane(JPanel1);
        setTitle("Matches Form");
        setMinimumSize(new Dimension(400,300) );
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        mdal = new matches_dal();
        mlist = mdal.Getmatches();

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
        for (matches k: mlist) {
            String data[] = {String.valueOf(k.match_id), k.match_name,k.match_date,k.home_team,k.away_team,k.stadium,k.ticket_packages};
            tblModel.addRow(data);
        }
    }
    public static void main(String[] args) {
        new matchesform();
    }

}
