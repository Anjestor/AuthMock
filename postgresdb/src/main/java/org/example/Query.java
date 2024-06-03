package org.example;

import java.sql.*;

public class Query {
    static final String DB_URL = "jdbc:postgresql://192.168.199.125:5432/mydb";
    static final String USER = "postgres";
    static final String PASS = "postgres";
    Connection con = null;

    public User getUser(String login) {
        String query = String.format("SELECT * FROM public.User u JOIN public.contacts c ON u.login = c.login WHERE u.login = '%s'", login);
        try {
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                return new User(resultSet.getString("login"), resultSet.getString("password"),
                        resultSet.getDate("date"), resultSet.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int insertData(User u) {
        String query = "INSERT INTO public.user (login, password, date) VALUES (?, ?, ?);" +
                       "INSERT INTO public.contacts (login, email) VALUES(?, ?);";
        try (PreparedStatement statement = con.prepareStatement(query)) {

            statement.setString(1, u.getLogin());
            statement.setString(2, u.getPassword());
            statement.setObject(3, u.getDate());
            statement.setString(4, u.getLogin());
            statement.setString(5, u.getEmail());

            return statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Query() {
        try {
            con = DriverManager.getConnection(DB_URL, USER, PASS);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
