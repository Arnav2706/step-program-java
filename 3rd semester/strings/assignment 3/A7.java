class Vehicle {
    String vehicleId;
    String brand;
    String model;
    int year;
    double mileage;
    String fuelType;
    String currentStatus;

    Vehicle(String id, String br, String mo, int yr, double mil, String fuel) {
        vehicleId = id;
        brand = br;
        model = mo;
        year = yr;
        mileage = mil;
        fuelType = fuel;
        currentStatus = "Available";
    }
}

class Car extends Vehicle {
    int seatingCapacity;
    Car(String id, String br, String mo, int yr, double mil, String fuel, int seat) {
        super(id, br, mo, yr, mil, fuel);
        seatingCapacity = seat;
    }
}

class Bus extends Vehicle {
    int seatingCapacity;
    Bus(String id, String br, String mo, int yr, double mil, String fuel, int seat) {
        super(id, br, mo, yr, mil, fuel);
        seatingCapacity = seat;
    }
}

class Truck extends Vehicle {
    double loadCapacity;
    Truck(String id, String br, String mo, int yr, double mil, String fuel, double load) {
        super(id, br, mo, yr, mil, fuel);
        loadCapacity = load;
    }
}

class Driver {
    String driverId;
    String driverName;
    String licenseType;
    Vehicle assignedVehicle;
    int totalTrips;

    Driver(String id, String name, String lic) {
        driverId = id;
        driverName = name;
        licenseType = lic;
        totalTrips = 0;
    }

    void assignVehicle(Vehicle v) {
        assignedVehicle = v;
        v.currentStatus = "Assigned";
    }
}

class Fleet {
    Vehicle[] vehicles;
    Driver[] drivers;
    static int totalVehicles = 0;
    static double fleetValue = 0;
    static String companyName = "MoveIt";
    static double totalFuelConsumption = 0;

    Fleet(int vcap, int dcap) {
        vehicles = new Vehicle[vcap];
        drivers = new Driver[dcap];
    }

    void addVehicle(Vehicle v, double val) {
        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i] == null) {
                vehicles[i] = v;
                totalVehicles++;
                fleetValue += val;
                break;
            }
        }
    }

    void addDriver(Driver d) {
        for (int i = 0; i < drivers.length; i++) if (drivers[i] == null) { drivers[i] = d; break; }
    }

    double calculateTotalMaintenanceCost() {
        return totalVehicles * 1000;
    }

    Vehicle[] getVehiclesByType(String type) {
        java.util.ArrayList<Vehicle> list = new java.util.ArrayList<>();
        for (Vehicle v : vehicles) if (v != null && v.getClass().getSimpleName().equals(type)) list.add(v);
        return list.toArray(new Vehicle[0]);
    }
}

public class A7 {
    public static void main(String[] args) {
        Fleet f = new Fleet(10, 5);
        Car c1 = new Car("V1", "Hyundai", "i20", 2020, 30000, "Petrol", 5);
        Bus b1 = new Bus("V2", "Volvo", "B9", 2018, 80000, "Diesel", 40);
        Truck t1 = new Truck("V3", "Tata", "LPT", 2019, 120000, "Diesel", 5000);
        f.addVehicle(c1, 800000);
        f.addVehicle(b1, 5000000);
        f.addVehicle(t1, 2000000);
        Driver d1 = new Driver("D1", "Ramesh", "HGV");
        f.addDriver(d1);
        d1.assignVehicle(b1);
        System.out.println("Fleet Value: " + Fleet.fleetValue);
        Vehicle[] buses = f.getVehiclesByType("Bus");
        for (Vehicle v : buses) System.out.println("Bus: " + v.vehicleId);
    }
}
