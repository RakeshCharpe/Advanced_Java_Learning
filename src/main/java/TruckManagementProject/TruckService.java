package TruckManagementProject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TruckService {

    // To add new truck
    public void addTruck(Truck truck) throws SQLException {
        // we didn't add ID here bcz ID is auto increment
        String sqlQuery = "INSERT INTO TRUCK ( NAME, ENGINE, CAPACITY, DRIVER_NAME) VALUES (?,?,?,?)";
        String sqlQueryToCheck = "select * from truck";
        try{
            Connection connection = ConnectionsDetails.getConnections();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQueryToCheck);
            preparedStatement.setString(1,truck.getName());
            preparedStatement.setString(2,truck.getEngine());
            preparedStatement.setInt(3,truck.getCapacity());
            preparedStatement.setString(4,truck.getDriver_name());




                int updatedRow = preparedStatement.executeUpdate();
                    System.out.println("updated row: "+ updatedRow);



        }catch(Exception e){
            e.printStackTrace();
        }
        finally {
            Connection connections = ConnectionsDetails.getConnections();
            connections.close();
        }
    }



    // To get truck details by ID
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



    // To update data of truck by ID
    public void updateTruck(Truck truck) throws SQLException {
        String sql = "update truck set name = ?, capacity = ?, engine = ?, driver_name = ? where id=?";
        Connection connections = ConnectionsDetails.getConnections();
        PreparedStatement preparedStatement = connections.prepareStatement(sql);
        preparedStatement.setString(1,truck.getName());
        preparedStatement.setInt(2,truck.getCapacity());
        preparedStatement.setString(3,truck.getEngine());
        preparedStatement.setString(4,truck.getDriver_name());
        preparedStatement.setInt(5,truck.getId());
        int i = preparedStatement.executeUpdate();
        System.out.println("Updated Row:" + i);
    }



    // To getting list of trucks
    public List<Truck> getAllTrucks(){
        String sql = "select * from truck";
        List<Truck> tl = new ArrayList<>();
        try{

            Connection connections = ConnectionsDetails.getConnections();
            PreparedStatement preparedStatement = connections.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Truck truck = new Truck();
                truck.setId(resultSet.getInt("id"));
                truck.setName(resultSet.getString("name"));
                truck.setCapacity(resultSet.getInt("capacity"));
                truck.setEngine(resultSet.getString("engine"));
                truck.setDriver_name(resultSet.getString("driver_name"));
                tl.add(truck);
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
        return tl;
    }

    public void deleteById(int id){
        String sql  = "delete from truck where id=?";
        try{
            Connection connections = ConnectionsDetails.getConnections();
            PreparedStatement preparedStatement = connections.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            int i = preparedStatement.executeUpdate();
            System.out.println("Updated Row: "+ i);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
