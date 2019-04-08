package com.sdacademy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcMain {

    public static final String PASSWORD = "Kinga2010!";
    public static final String USER = "root";
    public static final String URL = "jdbc:mysql://localhost:3306/tarr4_db?serverTimezone=UTC";;
    public static final String SQL = "delete from zawodnicy where imie=? and nazwisko=?";
    public static final String SQL1 = "update zawodnicy set waga=? where imie=? and nazwisko=?";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1,"Kasia");
            preparedStatement.setString(2,"Malinowska");
            preparedStatement.addBatch();

            preparedStatement.setString(1,"Piotr");
            preparedStatement.setString(2,"MALYSZ");
            preparedStatement.addBatch();
            int[] executeBatch = preparedStatement.executeBatch();

            for (int i:executeBatch) {
                System.out.println(i);
            }
            preparedStatement = connection.prepareStatement(SQL1);
            preparedStatement.setInt(1,100);
            preparedStatement.setString(2,"Marcin");
            preparedStatement.setString(3,"BACHLEDA");
            preparedStatement.addBatch();

            preparedStatement.setInt(1,120);
            preparedStatement.setString(2,"Robert");
            preparedStatement.setString(3,"MATEJA");
            preparedStatement.addBatch();
            int[] executeBatch2 = preparedStatement.executeBatch();
            System.out.println("waga");
            for (int i:executeBatch2) {
                System.out.println(i);
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
