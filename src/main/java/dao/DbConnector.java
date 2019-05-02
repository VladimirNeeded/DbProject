package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Optional;

public class DbConnector {
    private static final String dbUrl = "jdbc:mysql://localhost:3306/mate_academy?useSSL=false";
    private static final String name = "root";
    private static final String password = "4815162342";

    public static Optional<Connection> connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return Optional.of(DriverManager.getConnection(dbUrl, name, password));
        }catch (Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    }
}