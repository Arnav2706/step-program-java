public class YoungestTallestFriend {
    public static void main(String[] args) {
        System.out.println("Enter age of Amar:");
        int age1 = Integer.parseInt(System.console().readLine());
        System.out.println("Enter height of Amar:");
        int height1 = Integer.parseInt(System.console().readLine());
        
        System.out.println("Enter age of Akbar:");
        int age2 = Integer.parseInt(System.console().readLine());
        System.out.println("Enter height of Akbar:");
        int height2 = Integer.parseInt(System.console().readLine());
        
        System.out.println("Enter age of Anthony:");
        int age3 = Integer.parseInt(System.console().readLine());
        System.out.println("Enter height of Anthony:");
        int height3 = Integer.parseInt(System.console().readLine());
        
        int youngest = Math.min(age1, Math.min(age2, age3));
        int tallest = Math.max(height1, Math.max(height2, height3));
        
        System.out.println("Youngest age: " + youngest);
        System.out.println("Tallest height: " + tallest);
    }
}