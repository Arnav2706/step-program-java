import java.util.Scanner;
public class DiscountFeeCalculator
{
    public static void main(String[] args)
	{
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the course fee (INR): ");
        double fee = input.nextDouble();
        System.out.print("Enter the discount percentage: ");
        double discountPercent = input.nextDouble();
        double discountAmount = (fee * discountPercent) / 100.0;
        double finalFee = fee - discountAmount;
        System.out.println("The discount amount is INR " + discountAmount + " and final discounted fee is INR " + finalFee);
        input.close();
    }
}
