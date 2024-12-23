package TruckManagementProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TruckService {


    public void addTruck(Truck truck){
        // we didn't add ID here bcz ID is auto increment
        String sqlQuery = "INSERT INTO TRUCK ( NAME, ENGINE, CAPACITY, DRIVER_NAME) VALUES (?,?,?,?)";
        try{
            Connection connection = ConnectionsDetails.getConnections();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1,truck.getName());
            preparedStatement.setString(2,truck.getEngine());
            preparedStatement.setInt(3,truck.getCapacity());
            preparedStatement.setString(4,truck.getDriver_name());

            int updatedRow = preparedStatement.executeUpdate();
            System.out.println("updated row: "+ updatedRow);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public Truck getTruckById(int id) throws SQLException {
        String sql = "select * from truck where id = ?";
        Truck truck = new Truck();
        Connection connection = ConnectionsDetails.getConnections();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            truck.setId(resultSet.getInt("id"));
            truck.setName(resultSet.getString("name"));
            truck.setCapacity(resultSet.getInt("capacity"));
            truck.setEngine(resultSet.getString("engine"));
            truck.setDriver_name(resultSet.getString("driver_name"));
        }
        return truck;
    }
    public void updateTruck(Truck truck){

    }
}
