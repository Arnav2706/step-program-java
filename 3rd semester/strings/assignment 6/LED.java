class Light {
    private int brightness;
    private String color;

    public Light() {
        this(50, "White");
        System.out.println("Light default constructor called");
    }

    public Light(int brightness) {
        this(brightness, "White");
        System.out.println("Light single-parameter constructor called");
    }

    public Light(int brightness, String color) {
        this.brightness = brightness;
        this.color = color;
        System.out.println("Light two-parameter constructor called");
    }
}

public class LED extends Light {
    private int power;

    public LED() {
        this(10);
        System.out.println("LED default constructor called");
    }

    public LED(int power) {
        super(70, "Warm White");
        this.power = power;
        System.out.println("LED single-parameter constructor called");
    }

    public LED(int power, int brightness, String color) {
        super(brightness, color);
        this.power = power;
        System.out.println("LED three-parameter constructor called");
    }

    public static void main(String[] args) {
        new LED();
        System.out.println("---------------");
        new LED(15);
        System.out.println("---------------");
        new LED(20, 100, "Cool White");
    }
}
