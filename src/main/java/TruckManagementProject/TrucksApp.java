package TruckManagementProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static TruckManagementProject.ConnectionsDetails.*;

public class TrucksApp {

    public static void main(String[] args) throws SQLException {
       TruckService truckService = new TruckService();

       Truck rajesh = new Truck("Rajesh",100,"1200","Tata");
       Truck rakesh = new Truck("Rakesh",200,"1500","Mahindra");
       Truck rohit = new Truck("Rohit",110,"1300","Volvo");

       // To add truck in service
       truckService.addTruck(rajesh);
       truckService.addTruck(rakesh);
       truckService.addTruck(rohit);

       // To get truck by id
        Truck truckById = truckService.getTruckById(1);

        // To update data in truck
        truckById.setEngine("2000");
        truckService.updateTruck(truckById);

        // To get list of all trucks
        List<Truck> allTrucks = truckService.getAllTrucks();
        for (Truck truck:allTrucks){
            System.out.println( truck);
        }


    }
}
