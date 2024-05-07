import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class usersform  extends  JFrame
{
    private JTable table1;
    private JPanel JPanel1;
    private JScrollBar scrollBar1;

    users_dal udal;
    private ArrayList<users> ulist;
    private DefaultTableModel tblModel;
    private final String TableColName[] =
            { "Id", "Name", "Price", "Details", "email" , "phone" , "address" , "created_at", "updated_at" };


    public usersform()
    {
        setContentPane(JPanel1);
        setTitle("My GUI Form"); // optional
        setMinimumSize(new Dimension(400,300) ); // optional
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        udal = new users_dal();
        ulist = udal.GetUsers();

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
        for (users k: ulist) {
            String data[] = {String.valueOf(k.user_id), k.username,k.password,k.full_name,k.email,k.phone,k.address, k.created_at, k.updated_at};
            tblModel.addRow(data);
        }
    }
    public static void main(String[] args) {
        new usersform();
    }

}
