class SimpleInterest {
    public static void main(String[] args) {
        System.out.println("Enter Principal:");
        float principal = Float.parseFloat(System.console().readLine());
        System.out.println("Enter Rate of Interest:");
        float rate = Float.parseFloat(System.console().readLine());
        System.out.println("Enter Time:");
        float time = Float.parseFloat(System.console().readLine());
        // Compute simple interest
        float interest = (principal * rate * time) / 100;
        // Display result
        System.out.println("The Simple Interest is " + interest + " for Principal " + principal +
                           ", Rate of Interest " + rate + ", and Time " + time);
    }
}
