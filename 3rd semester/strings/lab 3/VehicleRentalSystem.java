public class VehicleRentalSystem {
    static class Vehicle {
        private String vehicleId;
        private String brand;
        private String model;
        private double rentPerDay;
        private boolean isAvailable;
        private int rentalDays;
        private double totalEarnings;
        
        // Static variables
        private static int totalVehicles = 0;
        private static double totalRevenue = 0.0;
        private static String companyName = "Default Rental";
        private static int totalRentalDays = 0;
        private static int vehicleCounter = 1;
        
        public Vehicle(String brand, String model, double rentPerDay) {
            this.brand = brand;
            this.model = model;
            this.rentPerDay = rentPerDay;
            this.isAvailable = true;
            this.rentalDays = 0;
            this.totalEarnings = 0.0;
            this.vehicleId = generateVehicleId();
            totalVehicles++;
        }
        
        private static String generateVehicleId() {
            return String.format("V%03d", vehicleCounter++);
        }
        
        public void rentVehicle(int days) {
            if (!isAvailable) {
                System.out.println("Vehicle " + vehicleId + " is not available for rent!");
                return;
            }
            if (days <= 0) {
                System.out.println("Rental days must be positive!");
                return;
            }
            
            double rentAmount = calculateRent(days);
            isAvailable = false;
            rentalDays += days;
            totalEarnings += rentAmount;
            
            System.out.println("Vehicle " + vehicleId + " rented for " + days + " days");
            System.out.println("Rental amount: $" + rentAmount);
        }
        
        public void returnVehicle() {
            if (isAvailable) {
                System.out.println("Vehicle " + vehicleId + " was not rented!");
                return;
            }
            isAvailable = true;
            System.out.println("Vehicle " + vehicleId + " returned successfully");
        }
        
        public double calculateRent(int days) {
            double rentAmount = rentPerDay * days;
            totalRevenue += rentAmount;
            totalRentalDays += days;
            return rentAmount;
        }
        
        public void displayVehicleInfo() {
            System.out.println("╔══════════════════════════════════╗");
            System.out.println("║        VEHICLE INFORMATION       ║");
            System.out.println("╠══════════════════════════════════╣");
            System.out.println("║ ID: " + vehicleId + "                        ║");
            System.out.println("║ Brand: " + String.format("%-20s", brand) + "║");
            System.out.println("║ Model: " + String.format("%-20s", model) + "║");
            System.out.println("║ Rent per Day: $" + String.format("%-10.2f", rentPerDay) + "   ║");
            System.out.println("║ Available: " + String.format("%-17s", isAvailable) + "║");
            System.out.println("║ Total Rental Days: " + String.format("%-9d", rentalDays) + "   ║");
            System.out.println("║ Total Earnings: $" + String.format("%-11.2f", totalEarnings) + "   ║");
            System.out.println("╚══════════════════════════════════╝");
        }
        
        // Static methods
        public static void setCompanyName(String name) {
            companyName = name;
        }
        
        public static double getTotalRevenue() {
            return totalRevenue;
        }
        
        public static double getAverageRentPerDay() {
            return totalRentalDays > 0 ? totalRevenue / totalRentalDays : 0.0;
        }
        
        public static void displayCompanyStats() {
            System.out.println("╔══════════════════════════════════╗");
            System.out.println("║       COMPANY STATISTICS         ║");
            System.out.println("╠══════════════════════════════════╣");
            System.out.println("║ Company: " + String.format("%-20s", companyName) + "║");
            System.out.println("║ Total Vehicles: " + String.format("%-13d", totalVehicles) + "║");
            System.out.println("║ Total Revenue: $" + String.format("%-13.2f", totalRevenue) + "║");
            System.out.println("║ Total Rental Days: " + String.format("%-11d", totalRentalDays) + "║");
            System.out.println("║ Avg Rent per Day: $" + String.format("%-11.2f", getAverageRentPerDay()) + "║");
            System.out.println("╚══════════════════════════════════╝");
        }
    }
    
    public static void main(String[] args) {
        // Set company name
        Vehicle.setCompanyName("Java Car Rentals");
        
        // Create multiple vehicle objects
        Vehicle[] vehicles = {
            new Vehicle("Toyota", "Camry", 50.0),
            new Vehicle("Honda", "Civic", 45.0),
            new Vehicle("Ford", "Mustang", 80.0)
        };
        
        System.out.println("=== INITIAL VEHICLE STATUS ===");
        for (Vehicle vehicle : vehicles) {
            vehicle.displayVehicleInfo();
        }
        
        // Demonstrate renting vehicles
        System.out.println("\n=== RENTING VEHICLES ===");
        vehicles[0].rentVehicle(3);
        vehicles[1].rentVehicle(5);
        vehicles[2].rentVehicle(2);
        
        // Try to rent an already rented vehicle
        vehicles[0].rentVehicle(2);
        
        System.out.println("\n=== AFTER RENTING ===");
        Vehicle.displayCompanyStats();
        
        // Demonstrate returning vehicles
        System.out.println("\n=== RETURNING VEHICLES ===");
        vehicles[0].returnVehicle();
        vehicles[1].returnVehicle();
        
        System.out.println("\n=== AFTER RETURNS ===");
        Vehicle.displayCompanyStats();
        
        // Rent again to show instance variables are unique
        System.out.println("\n=== SECOND RENTAL ===");
        vehicles[0].rentVehicle(4);
        vehicles[2].returnVehicle();
        
        System.out.println("\n=== FINAL STATUS ===");
        for (Vehicle vehicle : vehicles) {
            vehicle.displayVehicleInfo();
        }
        
        Vehicle.displayCompanyStats();
        
        // Demonstrate static vs instance members
        System.out.println("\n=== STATIC VS INSTANCE DEMONSTRATION ===");
        System.out.println("Static total revenue: $" + Vehicle.getTotalRevenue());
        System.out.println("Static total rental days: " + Vehicle.totalRentalDays);
        
        for (Vehicle vehicle : vehicles) {
            System.out.println("Vehicle " + vehicle.vehicleId + " earnings (Instance): $" + 
                             vehicle.totalEarnings);
            System.out.println("Vehicle " + vehicle.vehicleId + " rental days (Instance): " + 
                             vehicle.rentalDays);
        }
    }
}