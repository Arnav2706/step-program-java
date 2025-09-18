class Phone {
    protected String brand;
    protected String model;

    public Phone() {
        this.brand = "Unknown";
        this.model = "Generic";
        System.out.println("Phone default constructor called");
    }

    public Phone(String brand, String model) {
        this.brand = brand;
        this.model = model;
        System.out.println("Phone parameterized constructor called");
    }
}

public class SmartPhone extends Phone {
    private String operatingSystem;

    public SmartPhone() {
        super();
        this.operatingSystem = "Android";
        System.out.println("SmartPhone default constructor called");
    }

    public SmartPhone(String brand, String model, String os) {
        super(brand, model);
        this.operatingSystem = os;
        System.out.println("SmartPhone parameterized constructor called");
    }

    public void showDetails() {
        System.out.println("Brand: " + brand + ", Model: " + model + ", OS: " + operatingSystem);
    }

    public static void main(String[] args) {
        SmartPhone sp1 = new SmartPhone();
        sp1.showDetails();

        SmartPhone sp2 = new SmartPhone("Apple", "iPhone 15", "iOS");
        sp2.showDetails();
    }
}
