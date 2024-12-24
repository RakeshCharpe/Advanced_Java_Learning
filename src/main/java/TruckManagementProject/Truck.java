package TruckManagementProject;

public class Truck {
    private int id;
    private String name;
    private String engine;
    private int capacity;
    private  String driver_name;

    Truck(){

    }
    public Truck( String driver_name, int capacity, String engine, String name) {
        this.id = id;
        this.driver_name = driver_name;
        this.capacity = capacity;
        this.engine = engine;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDriver_name() {
        return driver_name;
    }

    public void setDriver_name(String driver_name) {
        this.driver_name = driver_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", engine='" + engine + '\'' +
                ", capacity=" + capacity +
                ", driver_name='" + driver_name + '\'' +
                '}';
    }
}
