//SQL Connection method taken from stackoverflow
//https://stackoverflow.com/questions/34856113/implementing-sql-in-a-bukkit-spigot-plugin
//WIP and most likely wont be done for some time


package survivalcore.survivalcore.Extensions;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL {

    public static String host = "our host name";
    public static String port = "our host name";
    public static String database = "database";
    public static String username = "username";
    public static String password = "password";
    public static Connection con;

    public static boolean isConnected;

    static ConsoleCommandSender console = Bukkit.getConsoleSender();

    public static void connect() {
        if (!isConnected) {
            try {
                con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, username, password);
                console.sendMessage("SQL connection established");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        }


    // disconnect
    public static void disconnect() {
        if (isConnected) {
            try {
                con.close();
                console.sendMessage("SQL Connection disconnected");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void setConnected(boolean value) {

        isConnected = value;

    }

    // getConnection
    public static Connection getCon() {
        return con;
    }
}





