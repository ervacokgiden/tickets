
import java.sql.*;
import java.util.ArrayList;

public class matches_dal {


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
    public void ListToConsole()
    {
        String cmd = "SELECT * FROM `matches`";

        try (Connection conn = DriverManager.getConnection(conUrl, user, pass);)
        {
            Statement statement = conn.createStatement();
            ResultSet res = statement.executeQuery(cmd);

            int say=0;
            int match_id;
            String match_name, match_date, home_team, away_team, stadium, ticket_packages;

            System.out.println("result set ready");
            while(res.next()) {
                match_id = res.getInt(1);
                match_name = res.getString(2);
                match_date = res.getString(3);
                home_team = res.getString(4);
                away_team = res.getString(5);
                stadium = res.getString(6);
                ticket_packages = res.getString(7);

                System.out.printf("Match Id= %d%n, Match Name= %s%n, Match Date= &s%n, Home Team=%s%n, Away Team= %s%n, Stadium= %s%n,  Ticket Packages= %s%n"  , match_id, match_name, match_date, home_team, away_team, stadium, ticket_packages);
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

    public ArrayList<matches> Getmatches()
    {
        ArrayList<matches> mlist = new ArrayList<>();

        String cmd = "SELECT * FROM `matches`";

        matches m;

        try (Connection conn = DriverManager.getConnection(conUrl, user, pass);)
        {
            Statement statement = conn.createStatement();
            ResultSet res = statement.executeQuery(cmd);

            while(res.next()) {
                m = new matches();

                m.match_id = res.getInt(1);
                m.match_name = res.getString(2);
                m.match_date = res.getString(3);
                m.home_team = res.getString(4);
                m.away_team = res.getString(5);
                m.stadium = res.getString(6);
                m.ticket_packages = res.getString(7);


                mlist.add(m);
            }
            res.close();

            //System.out.println("Connected to MySql server.....");
        } catch (
                SQLException e) {
            System.out.println(e.getMessage());
        }
        return mlist;
    }

    }

