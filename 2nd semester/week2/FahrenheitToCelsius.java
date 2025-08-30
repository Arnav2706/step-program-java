class FahrenheitToCelsius {
    public static void main(String[] args) {
        System.out.println("Enter temperature in Fahrenheit:");
        float fahrenheit = Float.parseFloat(System.console().readLine());
        float celsiusResult = (fahrenheit - 32) * 5 / 9;
        System.out.println("The " + fahrenheit + " fahrenheit is " + celsiusResult + " celsius");
    }
}
