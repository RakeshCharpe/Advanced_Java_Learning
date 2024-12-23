package org.example;

import java.sql.*;

public class PrepareStatement {
    public static String LOAD_DRIVER="com.mysql.cj.jdbc.Driver";
    public static String URL="jdbc:mysql://localhost:3306/rakesh";
    public static String PASSWORD="root";
    public static String USERNAME="root";


    public static void main(String[] args) {


            try {
                // no need to add driver now IDE are smart
               // Class.forName(LOAD_DRIVER);

                //MAKING CONNECTION
                Connection connection =  DriverManager.getConnection(URL,USERNAME,PASSWORD);

  
                //we can prepare statement as well
                String insertQuery = "INSERT INTO demo (id, name) VALUES (?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
                preparedStatement.setInt(1,4);
                preparedStatement.setString(2,"Rohit");

                int i = preparedStatement.executeUpdate();
                System.out.println("lines updated: "+ i);


                connection.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }

    }
}
