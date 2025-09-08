public class GameController {
    // Instance variables
    private String controllerBrand;
    private String connectionType;
    private boolean hasVibration;
    private int batteryLevel;
    private double sensitivity;

    // Default constructor - standard gaming setup
    public GameController() {
        controllerBrand = "GenericPad";
        connectionType = "USB";
        hasVibration = true;
        batteryLevel = 100;
        sensitivity = 1.0;
    }

    // Parameterized constructor for full custom configuration
    public GameController(String controllerBrand, String connectionType,
                          boolean hasVibration, int batteryLevel,
                          double sensitivity) {
        this.controllerBrand = controllerBrand;
        this.connectionType = connectionType;
        this.hasVibration = hasVibration;

        // Validation for battery (0-100)
        if (batteryLevel < 0) this.batteryLevel = 0;
        else if (batteryLevel > 100) this.batteryLevel = 100;
        else this.batteryLevel = batteryLevel;

        // Validation for sensitivity (0.1 - 3.0)
        if (sensitivity < 0.1) this.sensitivity = 0.1;
        else if (sensitivity > 3.0) this.sensitivity = 3.0;
        else this.sensitivity = sensitivity;
    }

    // Two-parameter convenience constructor
    public GameController(String brand, String connectionType) {
        this(brand, connectionType, true, 100, 1.0);
    }

    // Methods
    public void calibrateController() {
        System.out.println("Calibrating " + controllerBrand + " controller...");
    }

    public void displayConfiguration() {
        System.out.println("Controller Brand: " + controllerBrand);
        System.out.println("Connection: " + connectionType);
        System.out.println("Vibration: " + (hasVibration ? "Enabled" : "Disabled"));
        System.out.println("Battery Level: " + batteryLevel + "%");
        System.out.println("Sensitivity: " + sensitivity);
        System.out.println("------------------------------------");
    }

    public void testVibration() {
        if (hasVibration) {
            System.out.println("*BUZZ* Vibration test successful!");
        } else {
            System.out.println("Vibration disabled on this controller.");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== GAMING CONTROLLER SETUP ===");

        // Default controller
        GameController defaultController = new GameController();

        // Fully customized controller
        GameController customController = new GameController(
                "ProPad", "Wireless", false, 85, 2.5);

        // Convenience constructor
        GameController quickController = new GameController("LitePad", "Bluetooth");

        // Test all methods
        defaultController.displayConfiguration();
        defaultController.calibrateController();
        defaultController.testVibration();

        customController.displayConfiguration();
        customController.calibrateController();
        customController.testVibration();

        quickController.displayConfiguration();
        quickController.calibrateController();
        quickController.testVibration();
    }
}
