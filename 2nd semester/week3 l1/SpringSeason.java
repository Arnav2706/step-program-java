public class SpringSeason {
    public static void main(String[] args) {
        System.out.println("Enter month:");
        int month = Integer.parseInt(System.console().readLine());
        System.out.println("Enter day:");
        int day = Integer.parseInt(System.console().readLine());

        if ((month == 3 && day >= 20) || (month == 6 && day <= 20) || (month > 3 && month < 6)) {
            System.out.println("It's a Spring Season");
        } else {
            System.out.println("Not a Spring Season");
        }
    }
}
