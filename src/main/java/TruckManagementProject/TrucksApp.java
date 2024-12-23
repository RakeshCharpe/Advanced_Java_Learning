package TruckManagementProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import static TruckManagementProject.ConnectionsDetails.*;

public class TrucksApp {

    public static void main(String[] args) {
        try {

            Connection connection = getConnections();
            Statement statement = connection.createStatement();

            connection.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}
