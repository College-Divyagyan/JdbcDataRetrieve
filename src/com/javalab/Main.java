package com.javalab;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.protocol.Resultset;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javalab", "root", "");
            String sql = "select * from subjects";

            PreparedStatement preparedStatement = null;

            ResultSet resultset = null;

            preparedStatement = connection.prepareStatement(sql);
            resultset = preparedStatement.executeQuery();

            while (resultset.next()) {
                int id = resultset.getInt("id");
                String name = resultset.getString("name");

                System.out.println("subject is :" +name);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
