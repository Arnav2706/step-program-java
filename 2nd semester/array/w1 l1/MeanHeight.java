public class MeanHeight {
    public static void main(String[] args) {
        double[] heights = new double[11];
        double sum = 0.0;

        for (int i = 0; i < 11; i++) {
            System.out.println("Enter height of player " + (i + 1) + ":");
            heights[i] = Double.parseDouble(System.console().readLine());
            sum += heights[i];
        }

        double mean = sum / 11;
        System.out.println("Mean height of the football team: " + mean);
    }
}
