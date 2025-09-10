class FoodOrder {
    String customerName;
    String foodItem;
    int quantity;
    double price;

    // 1. Default constructor
    public FoodOrder() {
        this("Unknown", "Unknown", 0, 0.0);
    }

    // 2. Constructor with food item
    public FoodOrder(String foodItem) {
        this("Unknown", foodItem, 1, 100.0);
    }

    // 3. Constructor with food item & quantity
    public FoodOrder(String foodItem, int quantity) {
        this("Unknown", foodItem, quantity, quantity * 100.0);
    }

    // 4. Full constructor
    public FoodOrder(String customerName, String foodItem, int quantity, double price) {
        this.customerName = customerName;
        this.foodItem = foodItem;
        this.quantity = quantity;
        this.price = price;
    }

    public void printBill() {
        System.out.println("Customer: " + customerName + 
                           ", Food: " + foodItem + 
                           ", Qty: " + quantity + 
                           ", Total: " + price);
    }
}

public class FoodOrderDemo {
    public static void main(String[] args) {
        FoodOrder o1 = new FoodOrder();
        FoodOrder o2 = new FoodOrder("Burger");
        FoodOrder o3 = new FoodOrder("Pizza", 3);
        FoodOrder o4 = new FoodOrder("Alice", "Pasta", 2, 400);

        o1.printBill();
        o2.printBill();
        o3.printBill();
        o4.printBill();
    }
}
