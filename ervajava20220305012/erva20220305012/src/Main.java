import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);
        System.out.println("*FOOTBALL MATCHES'S TICKET SYSTEM*");

        String adminUsername ="user1";
        String adminPassword ="123";

        boolean isLoggedIn = false;


        while (true)
        {
            if (!isLoggedIn){
                System.out.println("1-Login");
            }
            System.out.println("2-Main Menu");
            System.out.println("3-Matches Screen");
            System.out.println("4-Ticket Reservations Screen");
            System.out.println("5-Profile Settings Screen");
            System.out.println("6-Exit");
            System.out.print("Choose:");
            int choose = input.nextInt();

            if ( choose == 1 && !isLoggedIn){
                System.out.print("UserName: ");
                String username = input.next();
                System.out.print("Password: ");
                String password = input.next();

                if (username.equals(adminUsername) && password.equals(adminPassword)){
                    System.out.println("Admin Login successful!");
                    isLoggedIn = true;
                } else {
                    System.out.println("Invalid username or password!");
                }
            }

            else if(choose==2 && isLoggedIn)
            {
                Scanner input2= new Scanner(System.in);
                System.out.println("3-Matches Screen");
                System.out.println("4-Ticket Reservations Screen");
                System.out.println("5-Profile Settings Screen");
                System.out.println("6-Exit");
                System.out.print("Choose:");
            }
            else if(choose==3 && isLoggedIn)
            {
                System.out.println(" ");
                matches_dal mdal = new matches_dal();
                mdal.Test();
                mdal.ListToConsole();
                System.out.println(" ");
            }
            else if(choose==4 && isLoggedIn)
            {
                System.out.println(" ");
                reservations_dal rdal = new reservations_dal();
                rdal.ListToConsole();
            }
            else if(choose==5 && isLoggedIn)
            {
                System.out.println(" ");
                users_dal udal = new users_dal();
                udal.ListToConsole();
            }
            else if(choose==6)
            {
                System.out.println("See you later...");
                break;
            } else {
                System.out.println("Please login first.");}
        }

    }

}