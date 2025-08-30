class DivideChocolates {
    public static void main(String[] args) {
        System.out.println("Enter number of chocolates:");
        int numberOfChocolates = Integer.parseInt(System.console().readLine());
        System.out.println("Enter number of children:");
        int numberOfChildren = Integer.parseInt(System.console().readLine());
        // Compute chocolates per child and remaining chocolates
        int chocolatesPerChild = numberOfChocolates / numberOfChildren;
        int remainingChocolates = numberOfChocolates % numberOfChildren;
        // Display result
        System.out.println("The number of chocolates each child gets is " + chocolatesPerChild + 
                           " and the number of remaining chocolates are " + remainingChocolates);
    }
}
