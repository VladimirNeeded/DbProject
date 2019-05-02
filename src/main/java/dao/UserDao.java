package dao;

import model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

public class UserDao {

    Optional<Connection> connection =  DbConnector.connect();

    public void addUser(User user) {
        Optional<Connection> connection =  DbConnector.connect();
        try {
            Statement statement = connection.get().createStatement();
            String sqlAdd = "INSERT INTO `mate_academy`.`users` (`login`, `password`) VALUES ('" + user.getLogin() + "', '" + user.getPassword() + "');";
            System.out.println(sqlAdd);
            statement.execute(sqlAdd);
        } catch (SQLException e) {
            System.out.println("SQLException//////////////////////////////////");
        }
    }

    public Optional<String> selectPassword(String login) {
        try {
            Statement statement = connection.get().createStatement();
            String sqlSelect = "SELECT password FROM mate_academy.users WHERE login = '" + login + "';";
            ResultSet resultPassword = statement.executeQuery(sqlSelect);
            while (resultPassword.next()) {
                Optional<String> resPass = Optional.of(resultPassword.getString("password"));
                return resPass;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}