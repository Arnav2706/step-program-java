public class Vehicle {
    // Protected instance variables (accessible to subclasses)
    protected String make;
    protected String model;
    protected int year;
    protected double fuelLevel;
    
    // Constructor
    public Vehicle(String make, String model, int year, double fuelLevel) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.fuelLevel = fuelLevel;
    }
    
    // Common methods
    public void startVehicle() {
        System.out.println(make + " " + model + " is starting...");
    }
    
    public void stopVehicle() {
        System.out.println(make + " " + model + " is stopping...");
    }
    
    public void refuel(double amount) {
        fuelLevel += amount;
        System.out.println("Refueled: " + amount + " units. Current fuel: " + fuelLevel);
    }
    
    public void displayVehicleInfo() {
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Fuel Level: " + fuelLevel);
    }
    
    public static void main(String[] args) {
        // Create different types of vehicles using the base Vehicle class
        Vehicle car = new Vehicle("Toyota", "Camry", 2020, 50.0);
        Vehicle truck = new Vehicle("Ford", "F-150", 2019, 80.0);
        Vehicle motorcycle = new Vehicle("Honda", "CBR", 2021, 15.0);
        
        // Create an array of Vehicle objects
        Vehicle[] vehicles = {car, truck, motorcycle};
        
        // Demonstrate polymorphic behavior
        System.out.println("=== All Vehicles ===");
        for (Vehicle vehicle : vehicles) {
            vehicle.displayVehicleInfo();
            vehicle.startVehicle();
            vehicle.refuel(10.0);
            vehicle.stopVehicle();
            System.out.println("-------------------");
        }
        
        /*
        OOP BENEFITS EXPLANATION:
        
        REUSABILITY:
        - The Vehicle class provides a reusable blueprint for all vehicle types
        - Common functionality (start/stop/refuel) is written once and reused
        - New vehicle types can inherit from Vehicle without rewriting common code
        
        EXTENSIBILITY:
        - We can create subclasses like Car, Truck, Motorcycle that extend Vehicle
        - Subclasses can add specialized methods while inheriting common ones
        - Example: Truck could have loadCapacity(), Motorcycle could have wheelie()
        
        BENEFITS OVER SEPARATE CLASSES:
        - Avoids code duplication (DRY principle - Don't Repeat Yourself)
        - Easier maintenance - changes to common functionality only in one place
        - Enables polymorphism - can treat all vehicles uniformly in arrays/collections
        - Better organization and structure of the codebase
        */
    }
}