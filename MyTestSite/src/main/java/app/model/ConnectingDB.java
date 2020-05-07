package app.model;

import app.entities.User;

import java.sql.*;

public class ConnectingDB {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String URL = "jdbc:mysql://localhost:3308/mywebapp?useUnicode=true&serverTimezone=UTC&useSSL=false";
    static Connection dbConnection;
    public static Connection getDbConnection() throws ClassNotFoundException, SQLException {
            Class.forName("com.mysql.cj.jdbc.Driver");
            dbConnection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connected!");
            return dbConnection;
    }
    public void signUp (User user) {
        String insert = "INSERT INTO mywebapp.users (login, email, password) VALUES (?,?,?)";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.executeUpdate();
            getDbConnection().commit();
            getDbConnection().close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public boolean getUser(User user) {
        ResultSet resultSet = null;
        String select = "SELECT * FROM USERS WHERE EMAIL = ? AND PASSWORD = ?";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(select);
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPassword());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
            getDbConnection().commit();
            getDbConnection().close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean getUserForChecking(User user) {
        ResultSet resultSet = null;
        String select = "SELECT * FROM USERS WHERE EMAIL = ?";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(select);
            preparedStatement.setString(1, user.getEmail());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
            getDbConnection().commit();
            getDbConnection().close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

}
