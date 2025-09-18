class BasicMath {
    public int calculate(int a, int b) {
        return a + b;
    }

    public double calculate(double a, double b) {
        return a + b;
    }

    public int calculate(int a, int b, int c) {
        return a + b + c;
    }
}

public class AdvancedMath extends BasicMath {
    public double calculate(double a, double b, double c) {
        return a * b * c;
    }

    public int calculate(int a) {
        return a * a;
    }

    public static void main(String[] args) {
        AdvancedMath am = new AdvancedMath();

        System.out.println("Sum (int): " + am.calculate(2, 3));
        System.out.println("Sum (double): " + am.calculate(2.5, 3.5));
        System.out.println("Sum (3 int): " + am.calculate(1, 2, 3));
        System.out.println("Square (int): " + am.calculate(5));
        System.out.println("Product (3 double): " + am.calculate(2.0, 3.0, 4.0));
    }
}
