import edu.aitu.oop3.db.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) {
        System.out.println("Connecting...");
        try (Connection con = DatabaseConnection.getConnection()) {
            System.out.println("Connected OK!");

            String sql = "SELECT CURRENT_TIMESTAMP";
            try (PreparedStatement st = con.prepareStatement(sql);
                 ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    System.out.println("DB time: " + rs.getTimestamp(1));
                }
            }

        } catch (Exception e) {
            System.out.println("Connection failed:");
            e.printStackTrace();
        }
    }
}
