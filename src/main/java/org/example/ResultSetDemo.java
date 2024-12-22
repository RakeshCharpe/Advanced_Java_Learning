package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ResultSetDemo {
    public static String LOAD_DRIVER="com.mysql.cj.jdbc.Driver";
    public static String URL="jdbc:mysql://localhost:3306/rakesh";
    public static String PASSWORD="root";
    public static String USERNAME="root";
    public static void main(String[] args) {
        try {
            //LOAD DRIVER
            Class.forName(LOAD_DRIVER);

            //MAKING CONNECTION
            Connection connection =  DriverManager.getConnection(URL,USERNAME,PASSWORD);

           //With the help of TYPE_SCROLL_INSENSITIVE , CONCUR_UPDATABLE we get the feature to
            // access resultset directly

            Statement statement = connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE
            );

            //CREATE QUERY
            String query = "select * from demo";

            ResultSet resultSet = statement.executeQuery(query);

           resultSet.first();
           System.out.println("Id: "+resultSet.getInt("id"));
           System.out.println("Name: "+resultSet.getString("name"));

            resultSet.last();
            System.out.println("Id: "+resultSet.getInt("id"));
            System.out.println("Name: "+resultSet.getString("name"));
            resultSet.updateString("name","virat");
            resultSet.updateRow();


            connection.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
