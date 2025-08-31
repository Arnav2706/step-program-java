public class Car {
    // Instance variables
    private String brand;
    private String model;
    private int year;
    private String color;
    private boolean isRunning;
    
    // Constructor
    public Car(String brand, String model, int year, String color) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.isRunning = false;
    }
    
    // Instance methods
    public void startEngine() {
        isRunning = true;
        System.out.println(brand + " " + model + " engine started. Vroom vroom!");
    }
    
    public void stopEngine() {
        isRunning = false;
        System.out.println(brand + " " + model + " engine stopped.");
    }
    
    public void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Color: " + color);
        System.out.println("Engine status: " + (isRunning ? "Running" : "Stopped"));
    }
    
    public int getAge() {
        return 2024 - year; // Assuming current year is 2024
    }
    
    public static void main(String[] args) {
        // Create 3 different Car objects
        Car car1 = new Car("Toyota", "Camry", 2020, "Blue");
        Car car2 = new Car("Honda", "Civic", 2018, "Red");
        Car car3 = new Car("Ford", "Mustang", 2022, "Black");
        
        // Demonstrate calling methods on each object
        System.out.println("=== Car 1 ===");
        car1.startEngine();
        car1.displayInfo();
        System.out.println("Age: " + car1.getAge() + " years");
        
        System.out.println("\n=== Car 2 ===");
        car2.displayInfo();
        car2.startEngine();
        car2.stopEngine();
        
        System.out.println("\n=== Car 3 ===");
        car3.displayInfo();
        System.out.println("Age: " + car3.getAge() + " years");
        
        // Show that each object maintains its own state
        System.out.println("\n=== Individual States ===");
        System.out.println("Car 1 running: " + car1.isRunning);
        System.out.println("Car 2 running: " + car2.isRunning);
        System.out.println("Car 3 running: " + car3.isRunning);
       
    }
}
