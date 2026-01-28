package edu.aitu.oop3.db;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class DataBaseCreation {
    public static void init() {
        memberTable();
        fitnessTable();
        bookingTable();
    }
    private static void memberTable(){
        String sql = """
                CREATE TABLE IF NOT EXISTS members(
                id SERIAL PRIMARY KEY,
                name varchar(255) NOT NULL,
                surname varchar (255) NOT NULL,
                email varchar(255) UNIQUE NOT NULL,
                gender varchar(10) NOT NULL
                );
                """;
        execute(sql);
    }
    private static void fitnessTable(){
        String sql = """
                create table if not exists fitness(
                id SERIAL PRIMARY KEY,
                type varchar(255) not null,
                description TEXT,
                date varchar(20),
                time varchar(10),
                cost INT,
                trainer_first_name varchar(255),
                trainer_last_name varchar(255),
                max_places INT
                );
                """;
        execute(sql);
    }
    private static void bookingTable(){
        String sql = """
                create table if not exists booking(
                id SERIAL PRIMARY KEY,
                member_id REFERENCES members(id),
                class_id REFERENCES fitness(id),
                booking_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                );
                """;
        execute(sql);
    }

    private static void execute(String sql) {
        try(Connection con = DatabaseConnection.getConnection(); Statement stmt = con.createStatement();) {
            stmt.execute(sql);
            System.out.println("Executed:" + sql.split("\\(")[0]);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }
}
