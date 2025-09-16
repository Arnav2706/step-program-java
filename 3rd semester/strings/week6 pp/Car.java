class Vehicle {
    // Protected fields for inheritance
    protected String brand;
    protected String model;
    protected int year;
    protected String engineType;

    // Private fields
    private String registrationNumber;
    private boolean isRunning;

    // Default constructor
    public Vehicle() {
        this.brand = "Unknown";
        this.model = "Unknown";
        this.year = 0;
        this.engineType = "Unknown";
        this.registrationNumber = generateRegistrationNumber();
        this.isRunning = false;
        System.out.println("Vehicle default constructor called");
    }

    // Parameterized constructor
    public Vehicle(String brand, String model, int year, String engineType) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.engineType = engineType;
        this.registrationNumber = generateRegistrationNumber();
        this.isRunning = false;
        System.out.println("Vehicle parameterized constructor called");
    }

    // Basic operations
    public void start() {
        this.isRunning = true;
        System.out.println("Vehicle started");
    }

    public void stop() {
        this.isRunning = false;
        System.out.println("Vehicle stopped");
    }

    public String getVehicleInfo() {
        return "Brand: " + brand +
               ", Model: " + model +
               ", Year: " + year +
               ", Engine: " + engineType +
               ", Reg#: " + registrationNumber +
               ", Running: " + isRunning;
    }

    public void displaySpecs() {
        System.out.println("Vehicle Specs:");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Engine Type: " + engineType);
    }

    // Getter/Setter for private fields
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public boolean isRunning() {
        return isRunning;
    }

    // Helper method
    private String generateRegistrationNumber() {
        return "REG" + (1000 + (int)(Math.random() * 9000));
    }
}

// Car class inside same file
class Car extends Vehicle {
    // Car-specific fields
    private int numberOfDoors;
    private String fuelType;
    private String transmissionType;

    // Default constructor
    public Car() {
        super(); // Calls Vehicle default constructor
        this.numberOfDoors = 4;
        this.fuelType = "Petrol";
        this.transmissionType = "Manual";
        System.out.println("Car default constructor called");
    }

    // Parameterized constructor
    public Car(String brand, String model, int year, String engineType,
               int numberOfDoors, String fuelType, String transmissionType) {
        super(brand, model, year, engineType); // Calls Vehicle parameterized constructor
        this.numberOfDoors = numberOfDoors;
        this.fuelType = fuelType;
        this.transmissionType = transmissionType;
        System.out.println("Car parameterized constructor called");
    }

    // Overridden methods
    @Override
    public void start() {
        super.start(); // Calls Vehicle’s start()
        System.out.println("Car-specific checks: seatbelt fastened, AC turned on.");
    }

    @Override
    public void displaySpecs() {
        super.displaySpecs(); // Show Vehicle specs first
        System.out.println("Car Specs:");
        System.out.println("Doors: " + numberOfDoors);
        System.out.println("Fuel Type: " + fuelType);
        System.out.println("Transmission: " + transmissionType);
    }

    // Car-specific methods
    public void openTrunk() {
        System.out.println("Trunk opened");
    }

    public void playRadio() {
        System.out.println("Radio playing music");
    }

    // Main method
    public static void main(String[] args) {
        // 1. Test constructor chaining
        System.out.println("=== Default Constructor Test ===");
        Car car1 = new Car();
        System.out.println(car1.getVehicleInfo());

        System.out.println("\n=== Parameterized Constructor Test ===");
        Car car2 = new Car("Toyota", "Camry", 2022, "Hybrid", 4, "Petrol", "Automatic");
        System.out.println(car2.getVehicleInfo());

        // 2. Test inheritance and methods
        System.out.println("\n=== Inherited and Overridden Methods ===");
        car2.start();
        car2.displaySpecs();
        car2.stop();

        // 3. Test car-specific methods
        System.out.println("\n=== Car-specific Methods ===");
        car2.openTrunk();
        car2.playRadio();
    }
}