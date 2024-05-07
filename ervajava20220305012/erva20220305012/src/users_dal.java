import java.sql.*;
import java.util.ArrayList;
public class users_dal {



        // for MySQL Server
        // mysql.connector.j-8.3.0
        String user="user1", pass="123";
        String conUrl = "jdbc:mysql://localhost/tickets";

        public void Test()
        {
            try {
                Connection conn = DriverManager.getConnection(conUrl, user, pass);
                System.out.println("Connected to MySql server.....");
            } catch (
                    SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    public void ListToConsole() {
        String cmd = "SELECT `user_id`,`username`,`password`,`full_name`,'email','phone','address','created_at','updated_at' FROM `users`";

        try (Connection conn = DriverManager.getConnection(conUrl, user, pass);)
        {
            Statement statement = conn.createStatement();
            ResultSet res = statement.executeQuery(cmd);

            int say=0;
            int user_id;
            String username, password, full_name, email, phone, address, created_at,updated_at;

            System.out.println("result set ready");
            while(res.next()) {
                user_id = res.getInt(1);
                username = res.getString(2);
                password = res.getString(3);
                full_name = res.getString(4);
                email = res.getString(5);
                phone = res.getString(6);
                address = res.getString(7);
                created_at = res.getString(8);
                updated_at = res.getString(9);
                System.out.printf("User Id= %d%n, User Name= %s%n, Password=%s%n, Full Name= %s%n, Email= %s%n,  Phone= %s%n,  Address= %s%n,  Created at= %s%n,  Updated at= %s%n", user_id, username, password, full_name, email, phone, address, created_at, updated_at);
                say++;
            }
            System.out.println("End of List.");
            res.close();

            //System.out.println("Connected to MySql server.....");
        } catch (
                SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<users> GetUsers()
    {
        ArrayList<users> ulist = new ArrayList<>();

        String cmd = "SELECT * FROM `users`";

        users u;

        try (Connection conn = DriverManager.getConnection(conUrl, user, pass);)
        {
            Statement statement = conn.createStatement();
            ResultSet res = statement.executeQuery(cmd);

            while(res.next()) {
                u = new users();

                u.user_id = res.getInt(1);
                u.username = res.getString(2);
                u.password = res.getString(3);
                u.full_name= res.getString(4);
                u.email = res.getString(5);
                u.phone = res.getString(6);
                u.address = res.getString(7);
                u.created_at = res.getString(8);
                u.updated_at = res.getString(9);

                ulist.add(u);
            }
            res.close();

            //System.out.println("Connected to MySql server.....");
        } catch (
                SQLException e) {
            System.out.println(e.getMessage());
        }
        return ulist;
    }
}