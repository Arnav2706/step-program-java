public class VirtualPet {
    private final String petId;
    private String petName;
    private int age;
    private int happiness;
    private int health;

    public static final String PET_SYSTEM_VERSION = "2.0";
    static final int MAX_HAPPINESS = 100;
    static final int MAX_HEALTH = 100;

    // Default constructor
    public VirtualPet() {
        this("Pet-" + System.currentTimeMillis(), "Unknown", 0, 50, 50);
    }

    // Constructor with name only
    public VirtualPet(String petName) {
        this("Pet-" + System.currentTimeMillis(), petName, 0, 60, 60);
    }

    // Full constructor
    public VirtualPet(String petId, String petName, int age, int happiness, int health) {
        this.petId = petId;
        this.petName = petName;
        this.age = age;
        this.happiness = validateStat(happiness);
        this.health = validateStat(health);
    }

    private int validateStat(int value) {
        if (value < 0) return 0;
        if (value > 100) return 100;
        return value;
    }

    public void feedPet(String foodType) {
        System.out.println(petName + " is eating " + foodType);
        happiness = validateStat(happiness + 10);
        health = validateStat(health + 5);
    }

    public void playWithPet(String gameType) {
        System.out.println(petName + " is playing " + gameType);
        happiness = validateStat(happiness + 15);
    }

    public void displayInfo() {
        System.out.println("🐾 Pet ID: " + petId);
        System.out.println("Name: " + petName);
        System.out.println("Age: " + age);
        System.out.println("Happiness: " + happiness);
        System.out.println("Health: " + health);
        System.out.println("System Version: " + PET_SYSTEM_VERSION);
        System.out.println("-------------------------");
    }

    // MAIN METHOD
    public static void main(String[] args) {
        VirtualPet pet1 = new VirtualPet();
        VirtualPet pet2 = new VirtualPet("Buddy");
        VirtualPet pet3 = new VirtualPet("Pet123", "Dragon", 2, 80, 90);

        pet1.displayInfo();
        pet2.displayInfo();
        pet3.displayInfo();

        pet2.feedPet("Berries");
        pet2.playWithPet("Fetch");
        pet2.displayInfo();
    }
}
