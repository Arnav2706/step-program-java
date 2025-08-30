class CelsiusToFahrenheit {
    public static void main(String[] args) {
        System.out.println("Enter temperature in Celsius:");
        float celsius = Float.parseFloat(System.console().readLine());
        float fahrenheitResult = (celsius * 9 / 5) + 32;
        System.out.println("The " + celsius + " celsius is " + fahrenheitResult + " fahrenheit");
    }
}
