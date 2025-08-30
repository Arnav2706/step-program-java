public class TwoDToOneDArray {
    public static void main(String[] args) {
        System.out.println("Enter number of rows:");
        int rows = Integer.parseInt(System.console().readLine());

        System.out.println("Enter number of columns:");
        int columns = Integer.parseInt(System.console().readLine());

        int[][] matrix = new int[rows][columns];
        int[] array = new int[rows * columns];
        int index = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.println("Enter element for position (" + i + "," + j + "):");
                matrix[i][j] = Integer.parseInt(System.console().readLine());
                array[index] = matrix[i][j];
                index++;
            }
        }

        System.out.println("1D Array:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
