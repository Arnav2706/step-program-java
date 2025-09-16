

// Base class Animal
class Animal {
    protected String species;
    protected String habitat;
    protected int lifespan;
    protected boolean isWildlife;

    // Constructor
    public Animal(String species, String habitat, int lifespan, boolean isWildlife) {
        this.species = species;
        this.habitat = habitat;
        this.lifespan = lifespan;
        this.isWildlife = isWildlife;
        System.out.println("Animal constructor: Creating " + species);
    }

    // Methods
    public void eat() {
        System.out.println("Animal is eating");
    }

    public void sleep() {
        System.out.println("Animal is sleeping");
    }

    public void move() {
        System.out.println("Animal is moving");
    }

    public String getAnimalInfo() {
        return "Species: " + species +
               ", Habitat: " + habitat +
               ", Lifespan: " + lifespan +
               ", Wildlife: " + isWildlife;
    }
}

// Intermediate class Mammal
class Mammal extends Animal {
    protected String furColor;
    protected boolean hasWarmBlood;
    protected int gestationPeriod;

    // Constructor
    public Mammal(String species, String habitat, int lifespan, boolean isWildlife,
                  String furColor, int gestationPeriod) {
        super(species, habitat, lifespan, isWildlife);
        this.furColor = furColor;
        this.gestationPeriod = gestationPeriod;
        this.hasWarmBlood = true; // always true for mammals
        System.out.println("Mammal constructor: Adding mammal traits");
    }

    // Override move
    @Override
    public void move() {
        super.move();
        System.out.println("Mammal is walking/running");
    }

    // Mammal-specific methods
    public void nurse() {
        System.out.println("Mammal is nursing offspring");
    }

    public void regulateTemperature() {
        System.out.println("Maintaining body temperature");
    }
}

// Specific class Dog
class Dog extends Mammal {
    private String breed;
    private boolean isDomesticated;
    private int loyaltyLevel;
    private String favoriteActivity;

    // Constructor 1: Basic dog with minimal parameters
    public Dog() {
        super("Dog", "Domestic", 12, false, "Brown", 60);
        this.breed = "Mixed";
        this.isDomesticated = true;
        this.loyaltyLevel = 5;
        this.favoriteActivity = "Playing";
        System.out.println("Dog constructor: Creating default dog");
    }

    // Constructor 2: Detailed dog with all parameters
    public Dog(String species, String habitat, int lifespan, boolean isWildlife,
               String furColor, int gestationPeriod,
               String breed, boolean isDomesticated, int loyaltyLevel, String favoriteActivity) {
        super(species, habitat, lifespan, isWildlife, furColor, gestationPeriod);
        this.breed = breed;
        this.isDomesticated = isDomesticated;
        this.loyaltyLevel = loyaltyLevel;
        this.favoriteActivity = favoriteActivity;
        System.out.println("Dog constructor: Creating " + breed + " dog");
    }

    // Constructor 3: Copy constructor
    public Dog(Dog other) {
        this(other.species, other.habitat, other.lifespan, other.isWildlife,
             other.furColor, other.gestationPeriod,
             other.breed, other.isDomesticated, other.loyaltyLevel, other.favoriteActivity);
        System.out.println("Dog copy constructor: Copying " + other.breed + " dog");
    }

    // Override methods
    @Override
    public void eat() {
        super.eat();
        System.out.println("Dog is wagging tail while eating");
    }

    @Override
    public void move() {
        System.out.println("Dog is running and playing");
    }

    @Override
    public void sleep() {
        System.out.println("Dog is sleeping in doghouse");
    }

    // Dog-specific methods
    public void bark() {
        System.out.println("Woof! Woof!");
    }

    public void fetch() {
        System.out.println("Dog is fetching the ball");
    }

    public void showLoyalty() {
        System.out.println("Loyalty level: " + loyaltyLevel + "/10");
    }

    // Demonstrate inheritance
    public void demonstrateInheritance() {
        System.out.println("--- Demonstrating Inheritance Chain ---");
        super.move();   // Calls Mammal’s move()
        super.eat();    // Calls Animal’s eat()
        this.sleep();   // Dog’s sleep
        bark();
        nurse();        // Mammal method
        regulateTemperature();
        System.out.println(getAnimalInfo());
    }

    // Main method
    public static void main(String[] args) {
        System.out.println("=== Constructor Chaining ===");
        Dog dog1 = new Dog();
        System.out.println(dog1.getAnimalInfo());

        System.out.println("\n=== Detailed Constructor ===");
        Dog dog2 = new Dog("Dog", "House", 15, false,
                           "Black", 63,
                           "Labrador", true, 9, "Swimming");
        System.out.println(dog2.getAnimalInfo());

        System.out.println("\n=== Copy Constructor ===");
        Dog dog3 = new Dog(dog2);
        System.out.println(dog3.getAnimalInfo());

        System.out.println("\n=== Method Overriding ===");
        dog2.eat();
        dog2.move();
        dog2.sleep();

        System.out.println("\n=== Dog-Specific Methods ===");
        dog2.bark();
        dog2.fetch();
        dog2.showLoyalty();

        System.out.println("\n=== Inheritance Demonstration ===");
        dog2.demonstrateInheritance();

        System.out.println("\n=== instanceof Tests ===");
        System.out.println("dog2 instanceof Dog: " + (dog2 instanceof Dog));
        System.out.println("dog2 instanceof Mammal: " + (dog2 instanceof Mammal));
        System.out.println("dog2 instanceof Animal: " + (dog2 instanceof Animal));
    }
}