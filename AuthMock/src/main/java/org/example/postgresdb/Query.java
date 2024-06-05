package org.example.postgresdb;

import org.example.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;

import java.sql.*;

@Component("q")
public class Query {
    static final String DB_URL = "jdbc:postgresql://192.168.199.125:5432/mydb";
    static final String USER = "postgres";
    static final String PASS = "postgres";
    Connection con = null;

    public User getUser(String login) {
        String query = String.format("SELECT * FROM public.User u JOIN public.contacts c ON u.login = c.login WHERE u.login = '%s'", login);

        try {
            con = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                return new User(resultSet.getString("login"), resultSet.getString("password"),
                        resultSet.getDate("date"), resultSet.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            con = null;
        }

        throw new RuntimeException("User Not Found");
    }

    public int addUser(User u) {
        String query = "INSERT INTO public.user (login, password, date) VALUES (?, ?, ?);" +
                "INSERT INTO public.contacts (login, email) VALUES(?, ?);";
        int userAdded = 0;

        try (Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement statement = con.prepareStatement(query)) {

            statement.setString(1, u.getLogin());
            statement.setString(2, u.getPassword());
            statement.setObject(3, u.getDate());
            statement.setString(4, u.getLogin());
            statement.setString(5, u.getEmail());

            userAdded = statement.executeUpdate();
            if (userAdded != 0) {
                return userAdded;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            con = null;
        }

        throw new RuntimeException("User Already Exists");
    }
}
