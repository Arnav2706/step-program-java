public class DiscountCalculator
{
    public static void main(String[] args)
	{
        int fee = 125000;
        int discountPercent = 10;
        double discountAmount = (fee * discountPercent) / 100.0;
        double finalFee = fee - discountAmount;
        System.out.println("The discount amount is INR " + discountAmount + " and final discounted fee is INR " + finalFee);
    }
}
