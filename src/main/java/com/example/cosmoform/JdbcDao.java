package com.example.cosmoform;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcDao {
    private static final String DATABASE_URL = "jdbc:mysql://127.0.0.2:3306/forum_shirts?useSSL=false";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASS = "root";

    private static final String INSERT_Client = "INSERT INTO Client_Waiver (FirstName_LastName," +
            " Signdate) VALUES (?,?)";
    private static final String INSERT_Feedback = "INSERT INTO Feedback (FirstName_LastName" +
            "Feedback_Answer) VALUES (?,?)";
    private static final String INSERT_Waiver = "INSERT INTO Waxing_Waiver (Answer, Date_Now," +
            " FirstName_LastName) VALUES (?,?,?)";


    public void clientRecord(String Name,String dateOfSignature) throws SQLException {
        //Establishing Connection
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASS);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_Client)) {

            preparedStatement.setString(1, Name);
            preparedStatement.setString(2, dateOfSignature);

            //Executes the query
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            printSQLException(exception);
        }
    }

    public void feedback(String Name,String feedbackAnswer) throws SQLException {
        //Establishing Connection
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASS);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_Feedback)) {

            preparedStatement.setString(1, Name);
            preparedStatement.setString(2, feedbackAnswer);


            //Executes the query
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            printSQLException(exception);
        }
    }

    public void waiverRecord(String Answer, String Date, String Name) throws SQLException {
        //Establishing Connection
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASS);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_Waiver)) {

            preparedStatement.setString(1, Answer);
            preparedStatement.setString(2, Date);
            preparedStatement.setString(3, Name);


            //Executes the query
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            printSQLException(exception);
        }
    }


    public static void printSQLException (SQLException ex){
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable throwable = ex.getCause();
                while (throwable != null) {
                    System.out.println("Cause: " + throwable);
                    throwable = throwable.getCause();
                }
            }
        }
    }
}
