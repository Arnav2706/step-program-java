public class StoreValues {
    public static void main(String[] args) {
        double[] values = new double[10];
        int index = 0;
        double sum = 0.0;

        while (true) {
            if (index >= 10) break;

            System.out.println("Enter a number:");
            double num = Double.parseDouble(System.console().readLine());

            if (num <= 0) break;

            values[index] = num;
            sum += num;
            index++;
        }

        System.out.println("Numbers entered:");
        for (int i = 0; i < index; i++) {
            System.out.println(values[i]);
        }

        System.out.println("Sum of numbers: " + sum);
    }
}

