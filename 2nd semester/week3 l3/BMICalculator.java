public class BMICalculator {
    public static void main(String[] args) {
        System.out.println("Enter weight in kg:");
        double weight = Double.parseDouble(System.console().readLine());
        System.out.println("Enter height in cm:");
        double height = Double.parseDouble(System.console().readLine()) / 100;
        
        double bmi = weight / (height * height);
        System.out.printf("BMI: %.2f\n", bmi);
        
        if (bmi <= 18.4) {
            System.out.println("Status: Underweight");
        } else if (bmi <= 24.9) {
            System.out.println("Status: Normal");
        } else if (bmi <= 39.9) {
            System.out.println("Status: Overweight");
        } else {
            System.out.println("Status: Obese");
        }
    }
}