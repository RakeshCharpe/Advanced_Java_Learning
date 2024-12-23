package TruckManagementProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionsDetails {
   // public static final String LOAD_DRIVER="com.mysql.cj.jdbc.Driver";
    public static final String URL="jdbc:mysql://localhost:3306/truckmanagement";
    public static final String PASSWORD="root";
    public static final String USERNAME="root";

    public static Connection getConnections() throws SQLException {
        return DriverManager.getConnection(URL,PASSWORD,USERNAME);
    }
}
