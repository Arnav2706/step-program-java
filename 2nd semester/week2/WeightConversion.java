class WeightConversion {
    public static void main(String[] args) {
        System.out.println("Enter weight in pounds:");
        float weight = Float.parseFloat(System.console().readLine());
        // Convert pounds to kilograms
        float weightInKg = weight * 2.2f;
        // Display result
        System.out.println("The weight of the person in pound is " + weight + 
                           " and in kg is " + weightInKg);
    }
}
