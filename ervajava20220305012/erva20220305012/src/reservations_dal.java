
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class reservations_dal {

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
    {String cmd = "SELECT `reservationId`,`userId`,`matchId`,`ticketPackage`,`quantity`,`totalPrice`,`reservationDate`,`status` FROM `reservationss`";

        try (Connection conn = DriverManager.getConnection(conUrl, user, pass);)
        {
            Statement statement = conn.createStatement();
            ResultSet res = statement.executeQuery(cmd);

            int say=0;
            int reservationId,userId,matchId,totalPrice,quantity;
            Date reservationDate;
            String  Status,ticketPackage;

            System.out.println("result set ready");
            while(res.next()) {
                reservationId = res.getInt(1);
                userId = res.getInt(2);
                matchId = res.getInt(3);
                ticketPackage = res.getString(4);
                quantity = res.getInt(5);
                totalPrice = res.getInt(6);
                reservationDate=res.getDate(7);
                Status=res.getString(8);
                System.out.printf("ReservationId Id=%d, UserId=%d , MatchId=%d, TicketPackage=%s, Quantity=%d, TotalPrice=%d, ReservationDate=%s, Status=%s   %n"  , reservationId,userId,matchId,ticketPackage,quantity,totalPrice,reservationDate,Status);
                say++;
            }
            System.out.println("End of List.");
            res.close();

            //System.out.println("Connected to MySql server.....");
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<reservations> Getreservations()
    {
        ArrayList<reservations> rlist = new ArrayList<>();

        String cmd = "SELECT `reservationId`,`userId`,`matchId`,`ticketPackage`,`quantity`,`totalPrice`,`reservationDate`,`status` FROM `reservationss`";

        reservations r;

        try (Connection conn = DriverManager.getConnection(conUrl, user, pass);)
        {
            Statement statement = conn.createStatement();
            ResultSet res = statement.executeQuery(cmd);

            while(res.next()) {
                r = new reservations();

                r.reservationId = res.getInt(1);
                r.userId = res.getInt(2);
                r.matchId = res.getInt(3);
                r.ticketPackage= res.getString(4);
                r.quantity= res.getInt(5);
                r.totalPrice= res.getInt(6);
                r.reservationDate= res.getDate(7);
                r.Status= res.getString(8);
                rlist.add(r);
            }
            res.close();

        } catch (
                SQLException e) {
            System.out.println(e.getMessage());
        }
        return rlist;
    }


}



