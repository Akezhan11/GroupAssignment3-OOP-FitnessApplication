package edu.aitu.oop3.db;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public final class DatabaseConnection {

    private static final String URL =
            "jdbc:postgresql://aws-1-eu-west-1.pooler.supabase.com:5432/postgres?sslmode=require";
    private static final String USER =
            "postgres.cwkmoedzdextltlplwvr";

    private static final String PASSWORD = loadPassword();

    private DatabaseConnection() {}

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private static String loadPassword() {
        try (InputStream in = new FileInputStream("config.properties")) {
            Properties props = new Properties();
            props.load(in);
            String p = props.getProperty("DB_PASSWORD");
            if (p == null || p.isBlank()) throw new RuntimeException("DB_PASSWORD is empty");
            return p.trim();
        } catch (Exception e) {
            throw new RuntimeException("Cannot read DB_PASSWORD from config.properties", e);
        }
    }
}

