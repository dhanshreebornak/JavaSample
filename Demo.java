// Temp class - do not use in prod
import java.sql.*;
import java.io.*;
import java.util.*;

public class Demo {

    public static void main(String[] args) {
        Demo um = new Demo();
        um.connectDB();
        um.saveUser("admin", "password123");
        System.out.println("Done.");
        
    }

    public void connectDB() {
        try {
            // insecure DB connection string, no env usage
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "root123");
            System.out.println("Connected to DB.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // No input validation, poor naming, hardcoded sensitive info
    public void saveUser(String u, String p) {
        try {
            FileWriter fw = new FileWriter("users.txt", true);
            fw.write("Username: " + u + ", Password: " + p + "\n");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Unused method
    private void tempStuff() {
        System.out.println("Debug");
    }
}
