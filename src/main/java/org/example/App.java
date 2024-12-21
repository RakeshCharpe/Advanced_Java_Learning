package org.example;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class App
{
    public static String LOAD_DRIVER="com.mysql.cj.jdbc.Driver";
    public static String URL="jdbc:mysql://localhost:3306/rakesh";
    public static String PASSWORD="root";
    public static String USERNAME="root";

    public static void main( String[] args )
    {
        try {
            //LOAD DRIVER
            Class.forName(LOAD_DRIVER);

            //MAKING CONNECTION
            Connection connection =  DriverManager.getConnection(URL,USERNAME,PASSWORD);

            //CREATE STATEMENT
            Statement statement = connection.createStatement();

            //CREATE QUERY
            String query = "select * from demo";

            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                int id =  resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println("ID: "+ id +"name: "+name);
            }
            connection.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }


    }
}
